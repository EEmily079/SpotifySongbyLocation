package location.sample.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import location.sample.demo.Model.Song;
import location.sample.demo.Model.SongHistory;
import location.sample.demo.Repository.SongHistoryRepository;
import location.sample.demo.Repository.SongRepository;
@Service
public class SongHistoryService {
    @Autowired
    private SongHistoryRepository songHistoryRepository;
    SongRepository songRepository;

    public List <SongHistory> findSongHistorybyAddress(String addressToCheck) {
        return songHistoryRepository.findByUserLocation_Address(addressToCheck);
       
    }

    
}
