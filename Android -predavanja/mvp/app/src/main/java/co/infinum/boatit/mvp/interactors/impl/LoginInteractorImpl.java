package co.infinum.boatit.mvp.interactors.impl;

import co.infinum.boatit.BoatApplication;
import co.infinum.boatit.models.LoginRequest;
import co.infinum.boatit.models.LoginResponse;
import co.infinum.boatit.mvp.interactors.LoginInteractor;
import co.infinum.boatit.mvp.listeners.LoginListener;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener loginListener;

    @Override
    public void login(LoginListener listener, String username, String password) {
        loginListener = listener;
        LoginRequest request = new LoginRequest(username, password);
        BoatApplication.getApiService().login(request, loginResponseCallback);
    }

    private Callback<LoginResponse> loginResponseCallback = new Callback<LoginResponse>() {
        @Override
        public void success(LoginResponse loginResponse, Response response) {
            loginListener.onLoginSuccess(loginResponse.getUser().getToken());
        }

        @Override
        public void failure(RetrofitError error) {
            loginListener.onLoginFail(error.getMessage());
        }
    };
}
