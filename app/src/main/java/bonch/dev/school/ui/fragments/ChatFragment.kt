package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
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
import bonch.dev.school.ui.models.Message
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_chat.view.*
import java.sql.Date

private var savedState: Parcelable? = null

class ChatFragment : Fragment() {

    private lateinit var messageRecycler: RecyclerView
    private lateinit var sendMessageButton: Button
    private lateinit var messageEt: EditText


    private var user_message: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        messageEt = view.findViewById(R.id.message_et)
        sendMessageButton = view.findViewById(R.id.send_message_button)
        messageRecycler = view.findViewById(R.id.message_recycle_view)

        messageRecycler.layoutManager = LinearLayoutManager(container!!.context)


        messageRecycler.adapter = MessageAdapter()

        (messageRecycler.layoutManager as LinearLayoutManager).onRestoreInstanceState(savedState)

        (messageRecycler.scrollToPosition((messageRecycler.adapter as MessageAdapter).messageList.size - 1))

        sendMessageButton.setOnClickListener {

            user_message = messageEt.getText().toString()

            if (!user_message.isBlank()) {
                Log.wtf("MyApp", "TXT")
                messageEt.setText("")
                (messageRecycler.adapter as MessageAdapter).addMessage(user_message)
                (messageRecycler.scrollToPosition((messageRecycler.adapter as MessageAdapter).messageList.size - 1))
            }
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (messageRecycler.layoutManager as LinearLayoutManager).onRestoreInstanceState(savedState)
    }

    override fun onPause() {
        super.onPause()
        savedState = (messageRecycler.layoutManager as LinearLayoutManager).onSaveInstanceState()

    }

    override fun onResume(){
        super.onResume()
        (messageRecycler.layoutManager as LinearLayoutManager).onRestoreInstanceState(savedState)
    }

    override fun onDestroy() {
        super.onDestroy()
        savedState = (messageRecycler.layoutManager as LinearLayoutManager).onSaveInstanceState()

    }







}

