package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.MessageAdapter
import bonch.dev.school.ui.activities.MainAppActivity
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_chat.view.*

class ChatFragment : Fragment() {

    private lateinit var messageRecycler : RecyclerView
    private lateinit var sendMessageButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        sendMessageButton = view.findViewById(R.id.send_message_button)
        messageRecycler = view.findViewById(R.id.message_recycle_view)
        messageRecycler.layoutManager = LinearLayoutManager(container!!.context)
        messageRecycler.adapter = MessageAdapter()

        return view
    }


}