package location.sample.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import location.sample.demo.Model.SongHistory;

@Repository
public interface SongHistoryRepository extends JpaRepository<SongHistory, Long> {

    // Add custom query method to find song histories by address
    
    List<SongHistory> findByUserLocation_Address(String address);

    // You can add more custom query methods as needed
    
}
