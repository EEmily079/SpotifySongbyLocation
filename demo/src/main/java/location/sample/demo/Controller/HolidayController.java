package location.sample.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import location.sample.demo.Model.Holiday;
import location.sample.demo.Service.HolidayService;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    @Autowired
    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/{year}/{countryCode}")
    public ResponseEntity<List<Holiday>> getHolidays(@PathVariable int year, @PathVariable String countryCode) {
        List<Holiday> holidays = holidayService.getHolidaysForYear(year, countryCode);
        if (holidays != null && !holidays.isEmpty()) {
            return ResponseEntity.ok(holidays);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
