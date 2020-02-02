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
        "Thrown up on RA?",
        "Had dorm or apartment party/kickback shut down?",
        "Masturbated while someone else is in the room without them knowing?",
        "Been walked in on by a roommate while masturbating?",
        "Walked in on a roommate masturbating?",
        "Been walked in on by roommate while having sex?",
        "Walked in on roommate having sex?",
        "Engaged in any sexual act with roommate(s)?",
        "Been to a Roebling block party",
        "Been sexiled at least twice in one day?"
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
