package co.infinum.boatit.mvp.interactors.impl;

import co.infinum.boatit.BoatApplication;
import co.infinum.boatit.models.BoatResponse;
import co.infinum.boatit.mvp.interactors.BoatsInteractor;
import co.infinum.boatit.mvp.listeners.BoatsListener;
import co.infinum.boatit.network.BaseCallback;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class BoatsInteractorImpl implements BoatsInteractor {

    private BoatsListener boatsListener;

    @Override
    public void getBoats(BoatsListener listener) {
        boatsListener = listener;
        BoatApplication.getApiService().getBoats(boatResponseCallback);
    }

    private Callback<BoatResponse> boatResponseCallback = new BaseCallback<BoatResponse>() {
        @Override
        public void success(BoatResponse boatResponse, Response response) {
            boatsListener.onBoatsReceived(boatResponse.getBoats());
        }

        @Override
        public void onTokenExpired() {
            boatsListener.onTokenExpired();
        }

        @Override
        public void error(RetrofitError error) {
            boatsListener.onError(error.getMessage());
        }
    };




//            new Callback<BoatResponse>() {
//        @Override
//        public void success(BoatResponse boatResponse, Response response) {
//            boatsListener.onBoatsReceived(boatResponse.getBoats());
//        }
//
//        @Override
//        public void failure(RetrofitError error) {
//            error.printStackTrace();
//            boatsListener.onError(error.getMessage());
//        }
//    };
}
