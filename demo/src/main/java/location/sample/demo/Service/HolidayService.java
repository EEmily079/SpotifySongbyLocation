package location.sample.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import location.sample.demo.Model.Holiday;

@Service
public class HolidayService {
    private final WebClient webClient;

    public HolidayService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://date.nager.at/Api/v2/").build();
    }

    public List<Holiday> getHolidaysForYear(int year, String countryCode) {
        String url = String.format("publicholidays/%d/%s", year, countryCode);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(Holiday.class)
                .collectList()
                .block();
    }
}
