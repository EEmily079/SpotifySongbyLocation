package location.sample.demo.Model;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserCurrentLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double currlatitude;

    private double currlongitude;

    private long currtimeStamp;

    private String curraddress;
    
    private String currdateTime;

      
    
     public UserCurrentLocation() {

      }

    public UserCurrentLocation(double currlatitude, double currlongitude, long currtimeStamp,String curraddress,String currdateTime) {
        this.currlatitude = currlatitude;
        this.currlongitude = currlongitude;
        this.curraddress = curraddress;
        this.currtimeStamp = currtimeStamp;
        this.currdateTime = currdateTime;
    }

    public double getCurrlatitude() {
        return currlatitude;
    }

    public void setCurrlatitude(double currlatitude) {
        this.currlatitude = currlatitude;
    }

    public double getCurrlongitude() {
        return currlongitude;
    }

    public void setCurrlongitude(double currlongitude) {
        this.currlongitude = currlongitude;
    }

    public long getCurrtimeStamp() {
        return currtimeStamp;
    }

    public void setCurrtimeStamp(long currtimeStamp) {
        this.currtimeStamp = currtimeStamp;
    }

    public String getCurraddress() {
        return curraddress;
    }

    public void setCurraddress(String curraddress) {
        this.curraddress = curraddress;
    }

    public String getCurrdateTime() {
        return currdateTime;
    }

    public void setCurrdateTime(String currdateTime) {
        this.currdateTime = currdateTime;
    }

    

}
