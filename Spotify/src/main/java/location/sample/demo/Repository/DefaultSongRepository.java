package location.sample.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import location.sample.demo.Model.DefaultSong;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface DefaultSongRepository extends JpaRepository<DefaultSong, Integer> {

    @Query(value = "SELECT df.uri FROM defaultsong df ORDER BY RAND() LIMIT 6", nativeQuery = true)
    List<String> findRandomSongs();
}

