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

    val messageList = MessageLab().messageList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.other_message_item, parent, false)
        return MessageHolder(view)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bind(position)
    }

    inner class MessageHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bind( position: Int){

            val otherMessageText = itemView.findViewById<TextView>(R.id.other_message_text)
            otherMessageText.text = messageList[position].messageText
            val otherSentDate = itemView.findViewById<TextView>(R.id.other_sent_date)
            otherSentDate.text = "${messageList[position].sentDate}"
            val otherName = itemView.findViewById<TextView>(R.id.other_name)
            otherName.text = "Kotik"

            val otherAvatarImageView = itemView.findViewById<ImageView>(R.id.other_avatar_image_view)

            Glide.with(itemView)
                .load(R.drawable.other_avatar_image)
                .apply(RequestOptions.circleCropTransform())
                .into(otherAvatarImageView)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}