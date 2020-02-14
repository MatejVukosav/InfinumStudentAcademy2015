package co.infinum.boatit.network;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by kjurkovic on 20/07/15.
 */
public abstract class BaseCallback<T> implements Callback<T> {

    private static final int STATUS_UNAUTHORIZED = 401;

    @Override
    public void failure(RetrofitError error) {
        if (error.getResponse().getStatus() == STATUS_UNAUTHORIZED) {
            onTokenExpired();
        } else {
            error(error);
        }
    }

    public abstract void onTokenExpired();

    public abstract void error(RetrofitError error);
}
