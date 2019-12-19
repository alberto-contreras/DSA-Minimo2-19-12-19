package com.example.minimo2dsa_19_12_2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.minimo2dsa_19_12_2019.models.Element;
import com.example.minimo2dsa_19_12_2019.models.Museums;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Element> listofmuseums;
    API api;
    //DECLARED ELEMENTS
    private ProgressBar progressBar;
    private RecyclerView museumsRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://do.diba.cat/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
        //DEFINITION ELEMENTS
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);// Show progress bar
        //HOW TO PRESENT THE LIST OF ITEMS
        museumsRV = (RecyclerView) findViewById(R.id.RecyclerMuseums);
        museumsRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //HOW TO PRESENT THE LIST OF ITEMS
        getMuseums();

    }
    //EXTRA FUNCTION THAT MAKE THE PETITION
    private void getMuseums() {

//        Call<Museums> call = jsonPlaceHolderApi.getMuseums("1", "15");

        Call<Museums> call = api.getMuseums();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if (response.isSuccessful()) {
                    Museums museums = response.body();
                    listofmuseums = museums.getElements();

                    for (Element elem : listofmuseums) {
                        Log.d("ALBERTO", elem.getAdrecaNom());
                    }

                    RecyclerViewAdapter adapter1 = new RecyclerViewAdapter(listofmuseums);//Create the adapter and send the list of museum
                    progressBar.setVisibility(View.GONE);//close progress bar
                    museumsRV.setAdapter(adapter1);//Set the adapter
                }
            }
            @Override
            public void onFailure(Call<Museums> call, Throwable t) {

            }
        });
    }
}
