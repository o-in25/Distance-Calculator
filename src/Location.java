/**
 * Created by o_in25 on 9/7/16.
 */
public class Location {
    private String address;
    private String stringTime;
    private int integerTime;


    public Location(String address, String stringTime, int integerTime) {
        this.address = address;
        this.stringTime = stringTime;
        this.integerTime = integerTime;
    }

    public String getAddress() {
        return address;
    }

    public String getStringTime() {
        return stringTime;
    }

    public int getIntegerTime() {
        return integerTime;
    }


}
