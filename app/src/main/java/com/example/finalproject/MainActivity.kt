package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.demoappkotlin.metier.ws.ReseauHelper
import com.formationandroid.demoappkotlin.metier.ws.RetrofitSingleton
import com.formationandroid.demoappkotlin.metier.ws.WSInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var vehiculesAdapter: VehiculesAdapter
    private lateinit var recyclerViewVehicules: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!ReseauHelper.estConnecte(this))
        {
            Toast.makeText(this, "Aucune connexion internet !", Toast.LENGTH_LONG).show()
            return
        }

        // recyclerView :
        recyclerViewVehicules = findViewById(R.id.liste_vehicules)

        // à ajouter pour de meilleures performances :
        recyclerViewVehicules.setHasFixedSize(true)

        // layout manager, décrivant comment les items sont disposés :
        val layoutManager = LinearLayoutManager(this)
        recyclerViewVehicules.layoutManager = layoutManager

        // contenu :
        val service = RetrofitSingleton.retrofit.create(WSInterface::class.java)
        val call = service.getVehicules()
        call.enqueue(object : Callback<Vehicules>
        {
            override fun onResponse(call: Call<Vehicules>, response: Response<Vehicules>)
            {
                if (response.isSuccessful)
                {

                    var listeVehicules: List<Vehicules>? = ArrayList()


                    if (listeVehicules != null)
                    {
                        val vehicules = listeVehicules[Random.nextInt(listeVehicules.size - 1)]
                    }

                }
            }
            override fun onFailure(call: Call<Vehicules>, t: Throwable)
            {
                Log.e("tag", "${t.message}")
            }
        })

        // adapter :
        vehiculesAdapter = VehiculesAdapter(listVehicules.toMutableList(), this)
        recyclerViewVehicules.adapter = vehiculesAdapter


    }
}