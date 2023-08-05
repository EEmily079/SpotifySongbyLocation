package location.sample.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import location.sample.demo.Model.Song;
import location.sample.demo.Repository.SongRepository;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> retrieveSongsByIds(List<Long> songIds) {
        return songRepository.findAllById(songIds);
    }
}
