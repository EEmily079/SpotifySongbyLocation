// package location.sample.demo.Controller;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import location.sample.demo.Model.Location;
// import location.sample.demo.Model.Song;
// import location.sample.demo.Service.LocationService;
// import location.sample.demo.Service.SongHistoryService;
// import location.sample.demo.Service.SongService;

// @RestController
// public class SongGenerationController {

//     @Autowired
//     private LocationService currentLocationService;

//     @Autowired
//     private SongHistoryService songHistoryService;
//     @Autowired
//     private SongService songservice;

//     @GetMapping("/generate-latest-location")
//     public ResponseEntity<Location> generateLatestLocation() {
//         // Get the latest saved current location
//         Location latestCurrentLocation = currentLocationService.findLatestCurrentLocation();
//         return ResponseEntity.ok(latestCurrentLocation);
//     }
//      @GetMapping("/song-by-location")
//     public ResponseEntity<List<Song>> generateSongHistoryByLocation() {
//         // Get the latest saved current location
//         Location latestCurrentLocation = currentLocationService.findLatestCurrentLocation();   
//          if (latestCurrentLocation != null) {
//             String currentAddress = latestCurrentLocation.getAddress();
          
//             List <Long>songIds = songHistoryService.findSongIdsByLocationAddress(currentAddress);

//                 List <Song> songsByLocation = new ArrayList<>();
//                 for (Long id : songIds) {
//                     Song associatedSong = songservice.findSongById(id);
//                        songsByLocation.add(associatedSong);
//                 }
//               return ResponseEntity.ok(songsByLocation);
//          }
//                //Return an empty list if no matching history or current location found
//          return ResponseEntity.ok(Collections.emptyList());
//     }
 
//     // @GetMapping("/generate-songs")
//     // public ResponseEntity<List<Song>> generateSongsFromLocation() {
//     //     // Get the latest saved current location
//     //     CurrentLocation latestCurrentLocation = currentLocationService.findLatestCurrentLocation();
    
//     //     if (latestCurrentLocation != null) {
//     //         String currentAddress = latestCurrentLocation.getAddress();
         
//     //         List <SongHistory> matchingSongHistory = songHistoryService.findSongHistoriesByLocationAddress(currentAddress);
//     //             List<Song> matchingSongs = new ArrayList<>();
//     //             for (SongHistory songHistory : matchingSongHistory) {
                        
//     //                 Song associatedSong = songHistory.getSong();
//     //                     matchingSongs.add(associatedSong);
//     //             }

//     //             return ResponseEntity.ok(matchingSongs);
             
//     //     }

//     //     //Return an empty list if no matching history or current location found
//     //     return ResponseEntity.ok(Collections.emptyList());
//     // }
// }
