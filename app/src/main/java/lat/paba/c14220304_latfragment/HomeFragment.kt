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
    private lateinit var newGameButton: Button
    private lateinit var giveUpButton: Button
    private lateinit var numberGrid: List<Button>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        scoreTextView = view.findViewById(R.id.scoreTextView)
        guessButton = view.findViewById(R.id.guessButton)
        newGameButton = view.findViewById(R.id.newGameButton)
        giveUpButton = view.findViewById(R.id.giveUpButton)

        scoreTextView.text = "Score: $score"

        numberGrid = listOf(
            view.findViewById(R.id.numberButton1),
            view.findViewById(R.id.numberButton2),
            view.findViewById(R.id.numberButton3),
            view.findViewById(R.id.numberButton4),
            view.findViewById(R.id.numberButton5),
            view.findViewById(R.id.numberButton6)
        )

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

        newGameButton.setOnClickListener {
            startGame()
        }

        giveUpButton.setOnClickListener {
            revealAnswer()
        }

        return view
    }

    private fun startGame() {
        score = 50
        scoreTextView.text = "Score: $score"

        val numbers = List(6) { Random.nextInt(1, randomRange + 1) }
        for (i in numberGrid.indices) {
            numberGrid[i].text = "?"
            numberGrid[i].setOnClickListener {
                numberGrid[i].text = numbers[i].toString()
            }
        }
    }

    private fun checkGuess(): Boolean {
        return Random.nextBoolean()
    }

    private fun revealAnswer() {
        for (i in numberGrid.indices) {
            numberGrid[i].text = (i + 1).toString()
        }
    }
}
