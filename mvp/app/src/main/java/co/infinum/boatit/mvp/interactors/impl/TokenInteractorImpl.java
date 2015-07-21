package co.infinum.boatit.mvp.interactors.impl;

import android.content.Context;

import co.infinum.boatit.helpers.SharedPrefsHelper;
import co.infinum.boatit.mvp.interactors.TokenInteractor;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class TokenInteractorImpl implements TokenInteractor {

    private Context context;

    public TokenInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean isUserExists() {
        return getToken() != null;
    }

    @Override
    public String getToken() {
        return SharedPrefsHelper.getToken(context);
    }
}
