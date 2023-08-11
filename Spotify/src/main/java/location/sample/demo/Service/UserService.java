package location.sample.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import location.sample.demo.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean isUserPremium(int userId){
        return userRepository.isUserPremium(userId);
    }
}
