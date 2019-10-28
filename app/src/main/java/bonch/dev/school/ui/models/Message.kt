package bonch.dev.school.ui.models

import java.sql.Date


data class Message(val messageId: Int, val messageText: String,
                   val sentDate: Date, val isUser: Boolean)

class MessageLab(){

    val messageList: MutableList<Message>
    var rnd: Int = 0
    var bool: Boolean = false

    init{
        messageList = mutableListOf()
        for(i in 0..99){
            rnd = (0..1).random()
            when(rnd){
                0 -> bool = false
                1 -> bool = true
            }
            val message = Message(i, "Meow #$i", Date(2019, 10, 28), bool)
            messageList.add(message)
        }
    }
}