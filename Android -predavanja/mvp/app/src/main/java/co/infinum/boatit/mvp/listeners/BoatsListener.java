package co.infinum.boatit.mvp.listeners;

import java.util.List;

import co.infinum.boatit.models.Boat;

/**
 * Created by kjurkovic on 16/07/15.
 */
public interface BoatsListener {

    void onBoatsReceived(List<Boat>boats);

    void onTokenExpired();

    void onError(String error);
}
