

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


@Document(collection = "todos")
class Todo {
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


@RestController
@RequestMapping("/api")
class ApiController {

    @Autowired
    private TodoRepo repo;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return repo.findAll();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Map<String, String> body) {
        return repo.save(new Todo(body.getOrDefault("text", "Untitled Task")));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    
    @GetMapping("/weather/{city}")
    public Object getWeather(@PathVariable String city) {
        String apiKey = "d66c2b3a05f9106df63a84b2a6f22a4c"; 
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                     + city + "&appid=" + apiKey + "&units=metric";

        try {
            RestTemplate rest = new RestTemplate();
            ResponseEntity<Map> resp = rest.getForEntity(url, Map.class);
            return resp.getBody();
        } catch (Exception e) {
            return Map.of("error", "City not found or API error");
        }
    }
}




