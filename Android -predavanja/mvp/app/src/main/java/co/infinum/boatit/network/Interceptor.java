package co.infinum.boatit.network;

import android.text.TextUtils;

import co.infinum.boatit.BoatApplication;
import co.infinum.boatit.helpers.SharedPrefsHelper;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class Interceptor implements retrofit.RequestInterceptor {

    private static final String TOKEN = "token";

    @Override
    public void intercept(RequestFacade request) {
        String token = SharedPrefsHelper.getToken(BoatApplication.getInstance());
        if (!TextUtils.isEmpty(token)) {
            request.addQueryParam(TOKEN, token);
        }
    }
}
