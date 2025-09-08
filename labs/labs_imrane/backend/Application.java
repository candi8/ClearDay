

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
    @Document(collection = "todos")
    static class Todo {
        @Id
        private String id;
        private String text;
        private boolean done;

        public Todo() {}
        public Todo(String text) { this.text = text; this.done = false; }

        public String getId() { return id; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public boolean isDone() { return done; }
        public void setDone(boolean done) { this.done = done; }
    }

    interface TodoRepo extends MongoRepository<Todo, String> {}

    @Autowired
    private TodoRepo repo;

  
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return repo.findAll();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Map<String, String> body) {
        String text = body.getOrDefault("text", "Untitled Task");
        return repo.save(new Todo(text));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }

  
    @GetMapping("/weather/{city}")
    public Map<String, Object> getWeather(@PathVariable String city) {
        String apiKey = "d4d8e21cca5ea0655c7acb8d77513871"; 
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                     + city + "&appid=" + apiKey + "&units=metric";

        RestTemplate rest = new RestTemplate();
        try {
            ResponseEntity<Map> resp = rest.getForEntity(url, Map.class);
            return resp.getBody();
        } catch (Exception e) {
            return Map.of("error", "City not found or API error");
        }
    }
}



