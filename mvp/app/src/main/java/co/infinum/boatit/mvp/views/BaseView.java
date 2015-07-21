package co.infinum.boatit.mvp.views;

import android.support.annotation.StringRes;

/**
 * Created by kjurkovic on 20/07/15.
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showError(@StringRes int error);
}
