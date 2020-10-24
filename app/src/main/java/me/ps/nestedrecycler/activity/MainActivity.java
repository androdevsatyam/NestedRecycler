package me.ps.nestedrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import me.ps.nestedrecycler.R;
import me.ps.nestedrecycler.adapter.FirstAdapter;
import me.ps.nestedrecycler.internet.Connection;
import me.ps.nestedrecycler.model.FirstModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    FirstAdapter firstAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar=findViewById(R.id.toolbar);

//        setSupportActionBar(toolbar);
        progressBar=findViewById(R.id.progress);
        recyclerView=findViewById(R.id.data);

        prepareList();
        getData();
    }

    private void prepareList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);

        Connection.licGyan().getJson(new Callback<FirstModel>() {
            @Override
            public void success(FirstModel firstModel, Response response) {
                progressBar.setVisibility(View.GONE);
                firstAdapter=new FirstAdapter(MainActivity.this,firstModel);
                recyclerView.setAdapter(firstAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("MainActivity","Error="+error.getMessage());
                showToast(MainActivity.this,error.getMessage());
            }
        });

//        ConInterface conInterface=Connection.licGyan();
        /*conInterface.getJson().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                showToast(MainActivity.this,t.getMessage());
            }
        });*/

    }

    private void showToast(Context context, String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}