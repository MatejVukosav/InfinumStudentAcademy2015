package co.infinum.boatit;

import android.app.Application;

import co.infinum.boatit.network.ApiManager;
import co.infinum.boatit.network.BoatItService;

/**
 * Created by kjurkovic on 16/07/15.
 */
public class BoatApplication extends Application {

    private static BoatApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    public static BoatApplication getInstance() {
        return instance;
    }

    private void init() {
        ApiManager.getInstance().init();
    }

    public static BoatItService getApiService() {
        return ApiManager.getInstance().getService();
    }
}
