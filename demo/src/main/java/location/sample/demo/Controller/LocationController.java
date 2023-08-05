package location.sample.demo.Controller;
import location.sample.demo.Service.UserLocationService;
import location.sample.demo.Utilitty.GeocodingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import location.sample.demo.Model.UserLocation;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class LocationController {
    @Autowired
private UserLocationService userLocationService;

    @PostMapping("/api/saveLocation")
    public ResponseEntity<String> saveUserLocation(@RequestBody UserLocation userLocation) {
        // Here, you can handle the received userLocation object as needed.
        // For demonstration purposes, let's just print the coordinates and send a success response.

        double latitude = userLocation.getLatitude();
        double longitude = userLocation.getLongitude();
        long timestamp=userLocation.getTimeStamp();
        String address = GeocodingUtility.getAddressFromCoordinates(latitude, longitude);
                
        if (address != null) {
            System.out.println("Address: " + address);
        } else {
            System.out.println("Unable to find address for the given coordinates.");
        }
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime =dateFormat.format(timestamp);



        System.out.println("Received location - Latitude: " + latitude + ", Longitude: " + longitude);
        System.out.println("Time Received: " + dateTime);
        UserLocation userLocationEntity = new UserLocation();
        userLocationEntity.setLatitude(latitude);
        userLocationEntity.setLongitude(longitude);
        userLocationEntity.setTimeStamp(timestamp);
        userLocationEntity.setAddress(address);
        userLocationEntity.setDateTime(dateTime);

        // Your logic to save the location data to the database or perform other actions.
            userLocationService.saveUserlocation(userLocationEntity);
            System.out.println("Save to database");
        // Send a success response to the client.
        return ResponseEntity.ok("Location saved successfully.");

    }


    @GetMapping("/api/getLocation")
    public ResponseEntity<UserLocation> getUserLocation() {

        UserLocation userLocation = new UserLocation();
        //userLocation.setLatitude(37.7749); // Sample latitude value
        //userLocation.setLongitude(-122.4194); // Sample longitude value

        // Return the UserLocation as JSON in the response body.
        return ResponseEntity.ok(userLocation);
    }
}


