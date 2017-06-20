package michaelkim.dailyreminders;

/**
 * Created by Michael Kim on 6/19/2017.
 */

public class Reminder {

    String name;
    String TD;
    String constantNoti;
    String repeatNoti;

    public Reminder (String n, String td, String cN, String rN){
        this.name = n;
        this.TD = td;
        this.constantNoti = cN;
        this.repeatNoti = rN;
    }

}
