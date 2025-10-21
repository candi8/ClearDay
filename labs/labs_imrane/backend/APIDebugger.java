
System.setProperty("java.util.logging.config.file", ""); 

java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.FINEST);
java.util.logging.Logger.getLogger("org.apache.http.wire").setLevel(java.util.logging.Level.FINEST);


System.setProperty("jdk.httpclient.HttpClient.log", "all");


TrustManager[] trustAllCerts = new TrustManager[] {
    new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
    }
};
SSLContext sc = SSLContext.getInstance("SSL");
sc.init(null, trustAllCerts, new java.security.SecureRandom());
HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .header("User-Agent", "Mozilla/5.0 (Java-API-Client)")
    .header("Accept", "application/json")
    .header("Content-Type", "application/json")
    
    .header("Authorization", "Bearer d66c2b3a05f9106df63a84b2a6f22a4c")
    .GET()
    .build();
// Set proxy if needed
System.setProperty("https.proxyHost", "your-proxy.com");
System.setProperty("https.proxyPort", "5501");

import java.net.http.*;
import java.net.*;
import javax.net.ssl.*;

public class APIDebugger {
    public static void main(String[] args) throws Exception {

        System.setProperty("jdk.httpclient.HttpClient.log", "all");
        
        HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();
            
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("d66c2b3a05f9106df63a84b2a6f22a4c"))
            .header("User-Agent", "Java-HTTP-Client")
            .header("Accept", "application/json")
            .timeout(Duration.ofSeconds(10))
            .GET()
            .build();
            
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("=== RESPONSE DEBUG INFO ===");
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Headers: " + response.headers().map());
            System.out.println("Body: " + response.body());
            System.out.println("===========================");
            
        } catch (Exception e) {
            System.out.println("=== ERROR ===");
            e.printStackTrace();
        }
    }
}