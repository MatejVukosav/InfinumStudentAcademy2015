package co.infinum.boatit.mvp.views;

import java.util.List;

import co.infinum.boatit.models.Boat;

/**
 * Created by kjurkovic on 16/07/15.
 */
public interface BoatsView extends BaseView {

    void onBoatListReceived(List<Boat> boats);

    void onBoatListEmpty();

    void onTokenExpired();

}