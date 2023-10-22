package com.julianvalencia.ejemplofragment.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.julianvalencia.ejemplofragment.R
import com.julianvalencia.ejemplofragment.databinding.CardViewItemSuperheroesBinding
import com.julianvalencia.ejemplofragment.model.Superheroe

class superheroesRecyclerViewAdapter(
    private val superheroeslist: MutableList<Superheroe>,
    private val onItemClicked: (Superheroe) ->Unit
) : RecyclerView.Adapter<superheroesRecyclerViewAdapter.SuperheroeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_superheroes, parent, false)
        return SuperheroeViewHolder(itemView)
    }

    override fun getItemCount(): Int =superheroeslist.size

    override fun onBindViewHolder(holder: SuperheroeViewHolder, position: Int) {
        val superheroe = superheroeslist[position]
        holder.bindSuperheroe(superheroe)
        holder.itemView.setOnClickListener{onItemClicked(superheroe)}
    }

    class SuperheroeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val binding = CardViewItemSuperheroesBinding.bind(itemView)

        fun bindSuperheroe(superheroe: Superheroe){
            with (binding){
                nameTextView.text = superheroe.name
                superheroeImageView.setImageResource(superheroe.image)
            }
        }
    }
}