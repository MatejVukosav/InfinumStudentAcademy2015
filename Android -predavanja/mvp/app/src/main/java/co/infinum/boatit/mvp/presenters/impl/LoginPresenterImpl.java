package co.infinum.boatit.mvp.presenters.impl;

import android.text.TextUtils;

import co.infinum.boatit.BoatApplication;
import co.infinum.boatit.R;
import co.infinum.boatit.helpers.SharedPrefsHelper;
import co.infinum.boatit.mvp.interactors.LoginInteractor;
import co.infinum.boatit.mvp.listeners.LoginListener;
import co.infinum.boatit.mvp.presenters.LoginPresenter;
import co.infinum.boatit.mvp.views.LoginView;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;

    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView view, LoginInteractor loginInteractor) {
        this.view = view;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void login(String username, String password) {
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            view.showProgress();
            loginInteractor.login(loginListener, username, password);
        } else {
            view.showError(R.string.error_empty_login);
        }
    }

    private LoginListener loginListener = new LoginListener() {
        @Override
        public void onLoginSuccess(String token) {
            SharedPrefsHelper.setToken(BoatApplication.getInstance(), token);
            view.hideProgress();
            view.onLoginSuccess();
        }

        @Override
        public void onLoginFail(String error) {
            view.hideProgress();
            view.onLoginFailed();
        }
    };
}
