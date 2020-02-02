package com.example.uclapuritytest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    var questionIndex = 0
    var numYes = 0
    val questions = listOf<String>(
        "Been approached by Andre on Bruinwalk?", 
        "Been taken by Andre to the ATM?", 
        "Walked through Ackerman to avoid Bruinwalk flyers?", 
        "Had Rende West two or more times in one day?", 
        "Eaten only at B-Plate for at least three consecutive days?", 
        "Gone to Diddy Reise more than once in a week?", 
        "Cried in the stairwell?", 
        "Chosen UCLA over UC Berkeley?", 
        "Chosen UCLA over USC?", 
        "Been rejected from a club?"
    )

    lateinit var questionNumText: TextView
    lateinit var questionText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val renderedView = inflater.inflate(R.layout.fragment_game, container, false)

        questionNumText = renderedView.findViewById<TextView>(R.id.questionNumberField)
        questionText = renderedView.findViewById<TextView>(R.id.questionField)
        questionNumText.text = "Question 1"
        questionText.text = questions[0]

        val yesButton = renderedView.findViewById<Button>(R.id.buttonYes)
        val noButton = renderedView.findViewById<Button>(R.id.buttonNo)

        yesButton.setOnClickListener {
            numYes++
            goToNextQuestion()
        }

        noButton.setOnClickListener {
            goToNextQuestion()
        }

        return renderedView
    }

    fun goToNextQuestion() {
        questionIndex++
        if (questionIndex == questions.size) {
            findNavController().navigate(
                GameFragmentDirections.actionGameFragmentToScoreFragment(
                    questions.size,
                    numYes
                )
            )
            return
        }
        val questionNum = questionIndex + 1
        questionNumText.text = "Question $questionNum"
        questionText.text = questions[questionIndex]
    }

}
