package com.example.birra_2.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectwork.classes.CAccount
import com.example.projectwork.R
import com.example.projectwork.databinding.ItemAccountBinding
import com.squareup.picasso.Picasso

class Adapter : ListAdapter<CAccount, Holder>(object : DiffUtil.ItemCallback<CAccount>(){
    override fun areItemsTheSame(oldItem: CAccount, newItem: CAccount): Boolean {

        return oldItem.accountID==newItem.accountID
    }
    //controlla se le due classi sono uguali basandosi su tutta la classe, si controlla l'id
    override fun areContentsTheSame(oldItem: CAccount, newItem: CAccount): Boolean {
        return oldItem==newItem //qui si controllano tutti gli attributi della classe e non solo la memoria per accertarsi se sono due elementi uguali
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemAccountBinding.inflate(LayoutInflater.from(parent.context)))
    } //crea un istanza "Holder" (definita poi) che poi verrata spostata, nell'Activity main, all'interno del recycler view

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val account = getItem(position)
        holder.bind(account)

        holder.itemView.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putInt("item_id", account.accountID)
            bundle.putString("item_image", account.profileImage)
            //val navController = findNavController(holder.itemView)
            //navController.navigate(R.id.action_beerListFragment_to_beerInfoFragment, bundle)
            val beerImage=view.findViewById<ImageView>(R.id.imgBeer)
            val extras = FragmentNavigatorExtras(beerImage to "imgBeer")

            view.findNavController().navigate(
                R.id.OtherAccountLayout,
                bundle, // Bundle of args
                null, // NavOptions
                extras)
        }
    }
    //quando l'elemento poi verrà visto nello schermo
}

class Holder(private val binding: ItemAccountBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(account : CAccount){
        binding.header.text=account.name
        binding.desc.text=account.surname
        Picasso.get()
            .load(account.profileImage)
            .resize(130, 500) // Imposta la dimensione desiderata
            .centerCrop() // Effettua il ridimensionamento con taglio al centro
            .into(binding.imgBeer)
    }
    //imposta l'xml
}