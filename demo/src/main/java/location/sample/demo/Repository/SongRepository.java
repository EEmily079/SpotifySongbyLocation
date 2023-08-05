package location.sample.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import location.sample.demo.Model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {


    
}
