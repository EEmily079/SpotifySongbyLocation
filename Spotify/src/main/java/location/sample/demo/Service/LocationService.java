package location.sample.demo.Service;
import location.sample.demo.Model.Location;
import location.sample.demo.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
@Autowired
    private LocationRepository locationRepository;

 


    public void saveLocation( Location location){
        if (!locationRepository.existsByAddress(location.getAddress()))
        {
             locationRepository.save(location);
        }       
    }

    public int findLocationIdByAddress(String address){
        return locationRepository.findLocationIdByAddress(address);
    }

}
