package com.example.learn.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learn.R
import com.example.learn.data.Message
import com.example.learn.utils.Constans.RECIEVE_ID
import com.example.learn.utils.Constans.SEND_ID

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>(){

    var messagesList = mutableListOf<Message>()
    inner class MessageViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener {
            messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
       return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item ,parent,false))
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage= messagesList[position]
        when (currentMessage.id){
            SEND_ID ->{
                holder.itemView.tv_message.apply{
                    text= currentMessage.message
                    visibility= View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility =View.GONE
            }
            RECIEVE_ID ->{
                holder.itemView.tv_bot_message.apply{
                    text= currentMessage.message
                    visibility= View.VISIBLE
                }
                holder.itemView.tv_message.visibility=View.GONE
            }
        }
    }

fun insertMessage(message:Message){
    this.messagesList.add(message)
    notifyItemInserted(messagesList.size)


}
}