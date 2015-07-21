package co.infinum.boatit.mvp.interactors;

import co.infinum.boatit.mvp.listeners.LoginListener;

/**
 * Created by kjurkovic on 20/07/15.
 */
public interface LoginInteractor {

    void login(LoginListener listener, String username, String password);
}
