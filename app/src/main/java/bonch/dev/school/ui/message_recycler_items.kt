package bonch.dev.school.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.models.MessageLab
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageHolder>(){

    companion object{
        private const val VIEW_TYPE_OTHER = 0
        private const val VIEW_TYPE_USER = 1
    }

    val messageList = MessageLab().messageList

    override fun getItemViewType(position: Int): Int = when(messageList[position].isUser){
        true -> VIEW_TYPE_USER
        false -> VIEW_TYPE_OTHER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val view = when(viewType){
            VIEW_TYPE_OTHER -> LayoutInflater.from(parent.context).inflate(R.layout.other_message_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.user_message_item, parent,false)
        }
        return MessageHolder(view)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bind(position)
    }

    inner class MessageHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bind( position: Int){
            if(messageList[position].isUser){
                val userMessageText = itemView.findViewById<TextView>(R.id.user_message_text)
                userMessageText.text = messageList[position].messageText
                val userSentDate = itemView.findViewById<TextView>(R.id.user_sent_date)
                userSentDate.text = "${messageList[position].sentDate}"
            }
            else{

                val otherMessageText = itemView.findViewById<TextView>(R.id.other_message_text)
                otherMessageText.text = messageList[position].messageText
                val otherSentDate = itemView.findViewById<TextView>(R.id.other_sent_date)
                otherSentDate.text = "${messageList[position].sentDate}"
                val otherName = itemView.findViewById<TextView>(R.id.other_name)
                otherName.text = "Kotik"

                val otherAvatarImageView =
                    itemView.findViewById<ImageView>(R.id.other_avatar_image_view)

                Glide.with(itemView)
                    .load(R.drawable.other_avatar_image)
                    .apply(RequestOptions.circleCropTransform())
                    .into(otherAvatarImageView)
            }
        }
    }

}