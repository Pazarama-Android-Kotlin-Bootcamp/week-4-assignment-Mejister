package com.example.weatherapp.ui

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.adapter.WeatherAdapter


class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
   private lateinit var lat:TextView
    private lateinit var long:TextView
    private lateinit var ShowBtn:Button
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main , container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ShowBtn=view.findViewById(R.id.mBtn)
        long=view.findViewById(R.id.etLong)
        lat=view.findViewById(R.id.etLat)





        ShowBtn=WeatherAdapter((), object : WeatherAdapter{
            override fun onClicked(button:String) {
                navController.navigate(
                    MainFragmentDirections.actionMainFragmentToDetailFragment(button);
                )
            } } ) } }




