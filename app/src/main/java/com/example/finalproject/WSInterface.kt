package com.formationandroid.demoappkotlin.metier.ws

import com.example.finalproject.Vehicules
import retrofit2.Call
import retrofit2.http.GET

interface WSInterface
{
    // appel get :
    @GET("get-vehicules.php")
    fun getVehicules(): Call<Vehicules>
}