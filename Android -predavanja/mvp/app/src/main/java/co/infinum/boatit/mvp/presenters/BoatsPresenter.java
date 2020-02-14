package co.infinum.boatit.mvp.presenters;

import co.infinum.boatit.models.Boat;

/**
 * Created by kjurkovic on 16/07/15.
 */
public interface BoatsPresenter {

    void getBoats();

    void onBoatClicked(Boat boat);
}
