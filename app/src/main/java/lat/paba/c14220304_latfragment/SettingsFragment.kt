package lat.paba.c14220304_latfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SettingsFragment : Fragment() {
    private lateinit var numberLimitEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)


        numberLimitEditText = view.findViewById(R.id.numberLimitEditText)
        saveButton = view.findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val limit = numberLimitEditText.text.toString()

        }

        return view
    }
}