package co.infinum.boatit.network;

import co.infinum.boatit.models.BoatResponse;
import co.infinum.boatit.models.LoginRequest;
import co.infinum.boatit.models.LoginResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by kjurkovic on 16/07/15.
 */
public interface BoatItService {

    @POST("/api/v1/users/login")
    void login(@Body LoginRequest request, Callback<LoginResponse> callback);

    @GET("/api/v1/posts")
    void getBoats(Callback<BoatResponse> callback);
}
