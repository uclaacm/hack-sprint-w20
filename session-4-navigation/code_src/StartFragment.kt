package com.example.uclapuritytest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val renderedView = inflater.inflate(R.layout.fragment_start, container, false)
        // get reference to the startButton
        val startButton = renderedView.findViewById<Button>(R.id.startButton)

        // create a function that navigates to the game fragment
        val navigationAction = Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_gameFragment)
        // execute the navigation function on click
        startButton.setOnClickListener (navigationAction)

        return renderedView
    }
}
