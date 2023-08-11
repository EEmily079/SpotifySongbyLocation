package location.sample.demo.Controller;
import location.sample.demo.Service.LocationService;
import location.sample.demo.Utilitty.GeocodingUtility;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import location.sample.demo.Model.Location;



@RestController
@CrossOrigin(origins = "*")
public class LocationController {
@Autowired
private LocationService locationService;

    @PostMapping("/api/saveLocation")
    public ResponseEntity<String> saveUserLocation(@RequestBody Location Location) {
        // Here, you can handle the received userLocation object as needed.
        // For demonstration purposes, let's just print the coordinates and send a success response.
        
        double latitude = Location.getLatitude();
        double longitude = Location.getLongitude();
        String address = GeocodingUtility.getAddressFromCoordinates(latitude, longitude);
                        

        DecimalFormat df = new DecimalFormat("#.##");

        latitude = Double.valueOf(df.format(latitude));
        longitude = Double.valueOf(df.format(longitude));

        if (address != null) {
            System.out.println("Address: " + address);
        } else {
            System.out.println("Unable to find address for the given coordinates.");
        }
        System.out.println("Received location - Latitude: " + latitude + ", Longitude: " + longitude);
    

        Location LocationEntity = new Location();
        LocationEntity.setLatitude(latitude);
        LocationEntity.setLongitude(longitude);
        LocationEntity.setAddress(address);
      
        // Your logic to save the location data to the database or perform other actions.
           locationService.saveLocation(LocationEntity);
            System.out.println("Save to database");
        // Send a success response to the client.
        return ResponseEntity.ok("Location saved successfully.");

    }
    
}


