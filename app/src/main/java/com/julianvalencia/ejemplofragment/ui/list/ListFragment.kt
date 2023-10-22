package com.julianvalencia.ejemplofragment.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.julianvalencia.ejemplofragment.R
import com.julianvalencia.ejemplofragment.databinding.FragmentListBinding
import com.julianvalencia.ejemplofragment.model.Superheroe


class ListFragment : Fragment() {

    private lateinit var  listBinding: FragmentListBinding

    val superheroesList = mutableListOf<Superheroe>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container,false)
        val root :View = listBinding.root

        loadSuperheroes()





        val superheroesRecyclerViewAdapter = superheroesRecyclerViewAdapter(superheroesList, onItemClicked = { onSuperheroeItemClicked(it)})

        listBinding.superheroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = superheroesRecyclerViewAdapter
            setHasFixedSize(false)
        }

        return root

    }

    private fun loadSuperheroes() {
        superheroesList.clear()
        var superheroes = Superheroe(
            id = 0,
            name = resources.getString(R.string.batman_name),
            alias = resources.getString(R.string.batman_alias),
            image = R.drawable.batman,
            powers = resources.getString(R.string.batman_power))
        superheroesList.add(superheroes)

        superheroes = Superheroe(
            id = 1,
            name = resources.getString(R.string.flash_name),
            alias = resources.getString(R.string.flash_alias),
            image = R.drawable.flash,
            powers = resources.getString(R.string.flash_power))
        superheroesList.add(superheroes)

        superheroes = Superheroe(
            id = 2,
            name = resources.getString(R.string.superman_name),
            alias = resources.getString(R.string.superman_alias),
            image = R.drawable.superman,
            powers = resources.getString(R.string.superman_power))
        superheroesList.add(superheroes)

        superheroes = Superheroe(
            id = 3,
            name = resources.getString(R.string.wonder_woman_name),
            alias = resources.getString(R.string.wonder_woman_alias),
            image = R.drawable.wonderwoman,
            powers = resources.getString(R.string.wonder_woman_powers))
        superheroesList.add(superheroes)
    }

    private fun onSuperheroeItemClicked(superheroe: Superheroe) {
        when(superheroe.id){
            0 ->findNavController().navigate(ListFragmentDirections.actionListFragmentToBatmanFragment())
            1 ->findNavController().navigate(ListFragmentDirections.actionListFragmentToFlashFragment())
            2 ->findNavController().navigate(ListFragmentDirections.actionListFragmentToSupermanFragment())
            else ->findNavController().navigate(ListFragmentDirections.actionListFragmentToWonderWomanFragment())
        }
    }

}