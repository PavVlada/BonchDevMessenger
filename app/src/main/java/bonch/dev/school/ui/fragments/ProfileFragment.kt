package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.R
import bonch.dev.school.ui.activities.MainAppActivity

class ProfileFragment : Fragment(){

    private lateinit var changePasswordButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val passwordFragment = PasswordFragment()
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        changePasswordButton = view.findViewById(R.id.change_password_button)
        changePasswordButton.setOnClickListener{
            passwordFragment.show((context as MainAppActivity).fm, "dialog_tag")
        }
        return view
    }

}