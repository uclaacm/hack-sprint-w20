package com.example.uclapuritytest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedView = inflater.inflate(R.layout.fragment_score, container, false)
        val scoreText = inflatedView.findViewById<TextView>(R.id.scoreField)
        val doneBtn = inflatedView.findViewById<Button>(R.id.doneButton)

        doneBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_scoreFragment_to_startFragment))

        val args = ScoreFragmentArgs.fromBundle(arguments!!)
        scoreText.text = "${args.numYes} out of ${args.numAnswered}"
        return inflatedView
    }


}
