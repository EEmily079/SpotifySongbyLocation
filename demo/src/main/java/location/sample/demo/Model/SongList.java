package location.sample.demo.Model;


import java.util.List;

import jakarta.persistence.*;


@Entity
public class SongList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songListId;

    private String songListName;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    
    @ManyToMany
    @JoinTable(name = "songlist_song",
        joinColumns = @JoinColumn(name = "song_list_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;


    public SongList(){

    }
    public SongList(String songListName, String type, User user) {
        this.songListName = songListName;
        this.type = type;
        this.user = user;
    }
    
    public String getSongListName() {
        return songListName;
    }
    public void setSongListName(String songListName) {
        this.songListName = songListName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    

    
}
