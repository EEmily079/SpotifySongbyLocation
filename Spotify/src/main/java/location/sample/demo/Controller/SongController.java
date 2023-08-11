package location.sample.demo.Controller;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import location.sample.demo.Model.Location;
import location.sample.demo.Model.SongHistory;

import location.sample.demo.Service.LocationService;
import location.sample.demo.Service.PythonService;
import location.sample.demo.Service.SongHistoryService;
import location.sample.demo.Service.UserService;
import location.sample.demo.Utilitty.GeocodingUtility;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private PythonService pythonService;
    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private SongHistoryService songHistoryService;

    @GetMapping("/default-song")
        public ResponseEntity<List<String>> generateDefaultSong() { 
             try {
            int userId = 0, locationId = 0, timeType = -1, number = 6;
           
            List<String> playlist = pythonService.senddatatoPython(userId, locationId, timeType, number);

            return ResponseEntity.ok(playlist);
        } catch (Exception e) {
            // log the exception and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PostMapping("/by-location")
    public ResponseEntity<List<String>> generateSongByLocation(@RequestBody Location location, @RequestParam int userId) {
        try {
            int locationId, timeType = -1, number;
            
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            String address = GeocodingUtility.getAddressFromCoordinates(latitude, longitude);
            locationId = locationService.findLocationIdByAddress(address);
            
            if (userService.isUserPremium(userId)) {
                number = 24;
            } else {
                number = 12;
            }

            List<String> playlist = pythonService.senddatatoPython(userId, locationId, timeType, number);

            return ResponseEntity.ok(playlist);
        } catch (Exception e) {
            // log the exception and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
    
    //  @GetMapping("/by-time")
    //     public ResponseEntity<Integer> generateSongByTime() { 
    //         int timetype = -1 ;
    //      LocalTime currentTime = LocalTime.now();

    //     if (currentTime.isAfter(LocalTime.of(5, 59)) && currentTime.isBefore(LocalTime.of(12, 0))) {
    //         timetype = 0;
    //     } else if (currentTime.isAfter(LocalTime.of(11, 59)) && currentTime.isBefore(LocalTime.of(17, 0))) {
    //         timetype = 1;
    //     } else if (currentTime.isAfter(LocalTime.of(16, 59)) && currentTime.isBefore(LocalTime.of(21, 0))) {
    //          timetype = 2;
    //     } else {
    //          timetype = 3;
    //     }
    //      return ResponseEntity.ok(timetype);    
    // }

     @GetMapping("/by-time")
        public ResponseEntity<List<String>> generateSongByTime(@RequestParam int userId) { 
            int timetype = -1 ;         
         LocalTime currentTime = LocalTime.now();

        if (currentTime.isAfter(LocalTime.of(5, 59)) && currentTime.isBefore(LocalTime.of(12, 0))) {
            timetype = 0;
        } else if (currentTime.isAfter(LocalTime.of(11, 59)) && currentTime.isBefore(LocalTime.of(17, 0))) {
            timetype = 1;
        } else if (currentTime.isAfter(LocalTime.of(16, 59)) && currentTime.isBefore(LocalTime.of(21, 0))) {
             timetype = 2;
        } else {
             timetype = 3;
        }
        List<String> songUris = songHistoryService.findSongUrisByUserIdAndTimeType(timetype, userId);

          return ResponseEntity.ok(songUris);   
    }   
}

//     @GetMapping("/api/song-by-location")
//     public ResponseEntity<List<String>> generateSongByLocation(@RequestBody Location location, @RequestParam int userId) {
       
//         int locationId, timeType, number;

//         double latitude = location.getLatitude();
//         double longitude = location.getLongitude();
//         String address = GeocodingUtility.getAddressFromCoordinates(latitude, longitude);
        
//         if(userService.isUserPremium(userId)){
//             //get locationId from database 
//              locationId = locationService.findLocationIdByAddress(address);
//              timeType = -1;
//              number = 24;
//         }
//         else{
//             locationId = locationService.findLocationIdByAddress(address);
//              timeType = -1;
//              number = 12;
//         }
//         //this will catch data from python 
       
//         List<String> playlist = pythonService.senddatatoPython(userId,locationId,timeType,number);

        
//         return ResponseEntity.ok(playlist);
//     }
// }

