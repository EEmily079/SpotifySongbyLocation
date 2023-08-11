package location.sample.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import location.sample.demo.Model.SongHistory;
import location.sample.demo.Repository.SongHistoryRepository;

import java.util.List;


@Service
public class SongHistoryService {
    @Autowired
    private SongHistoryRepository songHistoryRepository;

    
    
    //     public List<SongHistory> findSongHistoriesByLocationAddress(String currentAddress) {
    //     return songHistoryRepository.findSongHistoriesByLocationAddress(currentAddress);
    // }
    
    //     public List<Long> findSongIdsByLocationAddress(String currentAddress){
    //         return songHistoryRepository.findSongIdsByLocationAddress(currentAddress);
    //     }
    
    public List<String> findSongUrisByUserIdAndTimeType(int timetype, int userId){
        return songHistoryRepository.findSongUrisByUserIdAndTimeType(timetype,userId);
    }
}
