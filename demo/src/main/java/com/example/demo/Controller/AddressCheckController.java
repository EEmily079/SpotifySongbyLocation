// package com.example.demo.Controller;

// import java.util.Collections;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import location.sample.demo.Model.Song;
// import location.sample.demo.Model.SongHistory;

// @RestController
// @RequestMapping("/api")
// public class AddressCheckController {

//     @Autowired
//     private SongHistory songHistoryRepository;

//     @PostMapping("/check-address")
// public ResponseEntity<List<Song>> checkAddressAndReturnSongList(@RequestBody String addressToCheck) {
//     // Retrieve song history records with matching address
//     List<SongHistory> matchingSongHistories = songHistoryRepository.findByAddress(addressToCheck);

//     if (!matchingSongHistories.isEmpty()) {
//         // Extract song IDs from matching song histories
//         List<Long> songIds = matchingSongHistories.stream()
//                 .map(SongHistory::getSongId)
//                 .collect(Collectors.toList());

//         // Retrieve songs by song IDs
//         List<Song> matchingSongs = retrieveSongsByIds(songIds);

//         return ResponseEntity.ok(matchingSongs);
//     } else {
//         return ResponseEntity.ok(Collections.emptyList());
//     }
// }

// }
