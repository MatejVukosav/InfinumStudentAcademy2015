package co.infinum.boatit.mvp.listeners;

/**
 * Created by kjurkovic on 20/07/15.
 */
public interface LoginListener {

    void onLoginSuccess(String token);

    void onLoginFail(String error);
}
