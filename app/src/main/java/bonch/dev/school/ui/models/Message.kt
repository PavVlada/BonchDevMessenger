package bonch.dev.school.ui.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Date
import java.text.SimpleDateFormat


@Parcelize
data class Message(val messageId: Int, val messageText: String,
                   val sentDate: Date, val isUser: Boolean): Parcelable

class MessageLab(){

    val messageList: MutableList<Message>
    private var bool: Boolean = false
    val date = Date(System.currentTimeMillis())

    init{
        messageList = mutableListOf()
        for(i in 0..48){
            bool = !bool
            val message = Message(i, "Мяу #$i", date, bool)
            messageList.add(message)
        }
    }
}