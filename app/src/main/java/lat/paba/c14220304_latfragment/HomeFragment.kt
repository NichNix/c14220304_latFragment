package lat.paba.c14220304_latfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var score = 50
    private var randomRange = 5
    private lateinit var scoreTextView: TextView
    private lateinit var guessButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        scoreTextView = view.findViewById(R.id.scoreTextView)
        guessButton = view.findViewById(R.id.guessButton)

        scoreTextView.text = "Score: $score"

        startGame()

        guessButton.setOnClickListener {
            val correct = checkGuess()
            if (correct) {
                score += 10
            } else {
                score -= 5
            }
            scoreTextView.text = "Score: $score"
        }

        return view
    }

    private fun startGame() {

        val numbers = List(10) { Random.nextInt(1, randomRange + 1) }

    }

    private fun checkGuess(): Boolean {

        return Random.nextBoolean()
    }
}
