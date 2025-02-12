package otus.gpb.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter : RecyclerView.Adapter<ItemViewHolder>(){
    private val chatList = mutableListOf<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ItemViewHolder(itemView)

    }
    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val chat = chatList[position]
        holder.bind(chat)
    }
    fun submitData(data: MutableList<ItemData>) {
        chatList.clear()
        chatList.addAll(data)
    }
    fun removeItem(adapterPosition: Int) {
        chatList.removeAt(adapterPosition)
    }

    fun addData(newDataList: MutableList<ItemData>) {
        val oldSize = chatList.size
        chatList.addAll(newDataList)
        notifyItemRangeInserted(oldSize, newDataList.size)
    }
}