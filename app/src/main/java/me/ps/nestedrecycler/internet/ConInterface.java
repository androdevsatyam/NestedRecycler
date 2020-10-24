package me.ps.nestedrecycler.internet;

import me.ps.nestedrecycler.model.FirstModel;
import retrofit.Callback;
import retrofit.http.GET;

public interface ConInterface {

    @GET("/app.php")
    void getJson(Callback<FirstModel> callBAck);
}
