package SpielfeldKlassen;

import java.util.Date;
import java.util.TimerTask;

public class Timer {
    private boolean vorwaerts;
    private Date time;

    public Timer(){
        setTime(new Date());
    }

    public void cancel(){
        setTime(null);
    }

    public void schedual(TimerTask task, Date time){

    }

    public boolean isVorwaerts() {
        return vorwaerts;
    }

    public void setVorwaerts(boolean vorwaerts) {
        this.vorwaerts = vorwaerts;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
