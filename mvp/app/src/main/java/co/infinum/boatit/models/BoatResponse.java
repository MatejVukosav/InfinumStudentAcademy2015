package co.infinum.boatit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class BoatResponse {

    @SerializedName("response")
    private List<Boat> boats;

    public List<Boat> getBoats() {
        return boats;
    }
}
