package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

const val EXTRA_VEHICULE = "vehicule"

class DetailFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val arguments = requireArguments()
        val course: vehicule? = arguments.getParcelable(EXTRA_VEHICULE)
        val textView: TextView = view.findViewById(R.id.libelle_vehicule)
        textView.text = vehicule?.nom
    }

}