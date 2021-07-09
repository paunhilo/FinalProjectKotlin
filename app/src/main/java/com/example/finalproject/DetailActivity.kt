package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

const val EXTRA_VEHICULE_DETAIL = "extraVehiculeDetail"

class DetailActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // argument envoyé depuis la liste :
        val vehicule: vehicule? = intent.getParcelableExtra(EXTRA_VEHICULE_DETAIL)

        // fragment :
        val fragment = DetailFragment()

        // paramètres vers le fragment :
        val bundle = Bundle()
        bundle.putParcelable(EXTRA_VEHICULE, vehicule)
        fragment.arguments = bundle

        // transaction :
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conteneur_fragment, fragment, "exemple2")
        transaction.commit()
    }

}