package lat.paba.c14220304_latfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ResultFragment : Fragment() {

    private lateinit var scoreTextView: TextView
    private lateinit var playAgainButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        scoreTextView = view.findViewById(R.id.scoreTextView)
        playAgainButton = view.findViewById(R.id.playAgainButton)

        val score = arguments?.getInt("SCORE", 0) ?: 0
        scoreTextView.text = "Your Last Score: $score"

        playAgainButton.setOnClickListener {
            val homeFragment = HomeFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, homeFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

    companion object {
        fun newInstance(score: Int): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putInt("SCORE", score)
            fragment.arguments = args
            return fragment
        }
    }
}
