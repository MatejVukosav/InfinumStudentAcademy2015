package co.infinum.boatit.helpers;

import android.content.Context;

import co.infinum.boatit.mvp.interactors.impl.BoatsInteractorImpl;
import co.infinum.boatit.mvp.interactors.impl.LoginInteractorImpl;
import co.infinum.boatit.mvp.interactors.impl.TokenInteractorImpl;
import co.infinum.boatit.mvp.presenters.BoatsPresenter;
import co.infinum.boatit.mvp.presenters.LoginPresenter;
import co.infinum.boatit.mvp.presenters.SplashPresenter;
import co.infinum.boatit.mvp.presenters.impl.BoatsPresenterImpl;
import co.infinum.boatit.mvp.presenters.impl.LoginPresenterImpl;
import co.infinum.boatit.mvp.presenters.impl.SplashPresenterImpl;
import co.infinum.boatit.mvp.views.BoatsView;
import co.infinum.boatit.mvp.views.LoginView;
import co.infinum.boatit.mvp.views.SplashView;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class MvpFactory {

    public static SplashPresenter getPresenter(Context context, SplashView view) {
        return new SplashPresenterImpl(view, new TokenInteractorImpl(context));
    }

    public static LoginPresenter getPresenter(LoginView view) {
        return new LoginPresenterImpl(view, new LoginInteractorImpl());
    }

    public static BoatsPresenter getPresenter(BoatsView view) {
        return new BoatsPresenterImpl(view, new BoatsInteractorImpl());
    }
}
