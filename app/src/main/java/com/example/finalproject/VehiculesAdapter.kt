package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "VehiculesAdapter"

class VehiculesAdapter(private var listVehicules: MutableList<Vehicules>, private val listeActivity: MainActivity) : RecyclerView.Adapter<VehiculesAdapter.VehiculesViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculesViewHolder
    {
        val viewVehicules = LayoutInflater.from(parent.context)
                                       .inflate(R.layout.item_vehicule, parent, false)
        return VehiculesViewHolder(viewVehicules)
    }

    override fun onBindViewHolder(holder: VehiculesViewHolder, position: Int)
    {
        holder.textViewLibelleVehicule.text = listVehicules[position].nom
    }

    override fun getItemCount(): Int = listVehicules.size

    fun updateCourses(listeVehicules: MutableList<Vehicules>)
    {
        this.listVehicules = listeVehicules
        notifyDataSetChanged()
    }

    inner class VehiculesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewLibelleVehicule: TextView = itemView.findViewById(R.id.libelle_vehicule)

        init
        {
            itemView.setOnClickListener {
                val vehicule = listVehicules[adapterPosition]
                Log.d(TAG, "vehicule : $vehicule")

                if (listeActivity.findViewById<FrameLayout>(R.id.conteneur_fragment) != null)
                {
                    // tablette :
                    val fragment = DetailFragment()

                    // paramètres vers le fragment :
                    val bundle = Bundle()
                    bundle.putParcelable(EXTRA_VEHICULE, vehicule)
                    fragment.arguments = bundle

                    // transaction :
                    val transaction: FragmentTransaction = listeActivity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.conteneur_fragment, fragment, "exemple2")
                    transaction.commit()
                }
                else
                {
                    // smartphone :
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(EXTRA_VEHICULE_DETAIL, vehicule)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}