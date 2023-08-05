package location.sample.demo.Service;

import location.sample.demo.Model.UserLocation;
import location.sample.demo.Repository.UserLocationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLocationService {
@Autowired
    private UserLocationRepository userlocationRepo;

    public void saveUserlocation(UserLocation userlocation){
        userlocationRepo.save(userlocation);
    }
    public List<UserLocation> getAllUserLocation(){
        return userlocationRepo.findAll();
     }

}
