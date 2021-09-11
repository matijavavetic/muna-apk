package ffos.p3.muna;

import java.io.Serializable;

public class Info implements Serializable {

    private String state;
    private String time;
    private String value;

    public Info() {
        this.state = state;
        this.time = time;
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) { this.state = state; }
}
