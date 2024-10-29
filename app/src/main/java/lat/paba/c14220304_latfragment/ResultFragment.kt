package lat.paba.c14220304_latfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultFragment : Fragment() {

    private var finalScore: Int = 0
    private lateinit var scoreTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        scoreTextView = view.findViewById(R.id.scoreTextView)

        displayScore(finalScore)

        return view
    }

    fun displayScore(score: Int) {
        finalScore = score
        if (this::scoreTextView.isInitialized) {
            scoreTextView.text = "Your Score: $finalScore"
        }
    }
}
