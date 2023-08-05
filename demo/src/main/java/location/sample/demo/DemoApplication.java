package location.sample.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;



@SpringBootApplication
@EntityScan(basePackages = "location.sample.demo") 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
    
	
	@Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
