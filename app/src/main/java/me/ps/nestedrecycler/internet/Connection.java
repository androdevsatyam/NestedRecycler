package me.ps.nestedrecycler.internet;

import retrofit.RestAdapter;

public class Connection {

    public static ConInterface licGyan() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://pswebsoft.com/videoadd").build();
        return adapter.create(ConInterface.class);
    }
}
