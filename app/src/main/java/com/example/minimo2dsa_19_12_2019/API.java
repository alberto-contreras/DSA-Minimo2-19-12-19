package com.example.minimo2dsa_19_12_2019;


import com.example.minimo2dsa_19_12_2019.models.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    //All the request that we are going to do against the API

    @GET("/api/dataset/museus/format/json/pag-ini/1/pag-fi/10")
    Call <Museums> getMuseums(); //We receive the object museum where we have a list of elemets that are museus
}
