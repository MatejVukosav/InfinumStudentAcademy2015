package co.infinum.boatit.mvp.presenters.impl;

import java.util.List;

import co.infinum.boatit.R;
import co.infinum.boatit.models.Boat;
import co.infinum.boatit.mvp.interactors.BoatsInteractor;
import co.infinum.boatit.mvp.listeners.BoatsListener;
import co.infinum.boatit.mvp.presenters.BoatsPresenter;
import co.infinum.boatit.mvp.views.BoatsView;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class BoatsPresenterImpl implements BoatsPresenter {

    private BoatsView view;

    private BoatsInteractor boatsInteractor;

    public BoatsPresenterImpl(BoatsView view, BoatsInteractor boatsInteractor) {
        this.view = view;
        this.boatsInteractor = boatsInteractor;
    }

    @Override
    public void getBoats() {
        view.showProgress();
        boatsInteractor.getBoats(listener);
    }

    @Override
    public void onBoatClicked(Boat boat) {
        // nesto

    }

    private BoatsListener listener = new BoatsListener() {
        @Override
        public void onBoatsReceived(List<Boat> boats) {
            view.hideProgress();
            if (boats != null && boats.size() > 0) {
                view.onBoatListReceived(boats);
            } else {
                view.onBoatListEmpty();
            }
        }

        @Override
        public void onTokenExpired() {
            view.onTokenExpired();
        }

        @Override
        public void onError(String error) {
            view.hideProgress();
            view.showError(R.string.error_boats);
        }
    };
}
