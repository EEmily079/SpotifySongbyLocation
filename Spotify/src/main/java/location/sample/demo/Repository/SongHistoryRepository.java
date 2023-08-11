package location.sample.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import location.sample.demo.Model.SongHistory;

@Repository
public interface SongHistoryRepository extends JpaRepository<SongHistory, Integer> {

    // @Query("SELECT sh FROM SongHistory sh JOIN sh.userLocation loc WHERE loc.address = :currentAddress")
    // List<SongHistory> findSongHistoriesByLocationAddress(@Param("currentAddress") String currentAddress);

    // @Query("SELECT sh.song.id FROM SongHistory sh JOIN sh.userLocation loc WHERE loc.address = :currentAddress")
    // List<Long> findSongIdsByLocationAddress(@Param("currentAddress") String currentAddress);

  
    @Query("SELECT sh.song.uri FROM SongHistory sh WHERE sh.user.id = :userId AND sh.timetype = :timetype")
    List<String> findSongUrisByUserIdAndTimeType(@Param("userId") int userId, @Param("timetype") int timetype);

}
