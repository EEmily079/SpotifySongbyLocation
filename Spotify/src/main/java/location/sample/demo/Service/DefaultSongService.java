package location.sample.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import location.sample.demo.Model.DefaultSong;
import location.sample.demo.Repository.DefaultSongRepository;
@Service
public class DefaultSongService {

    @Autowired
    DefaultSongRepository defaultSongRepository;

    public List<String> findDefaultSongs(){
        return defaultSongRepository.findRandomSongs();
    }
    
}
