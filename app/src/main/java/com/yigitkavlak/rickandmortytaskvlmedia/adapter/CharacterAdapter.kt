package com.yigitkavlak.rickandmortytaskvlmedia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.yigitkavlak.rickandmortytaskvlmedia.R
import com.yigitkavlak.rickandmortytaskvlmedia.model.Character
import com.yigitkavlak.rickandmortytaskvlmedia.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_character.view.*
import com.yigitkavlak.rickandmortytaskvlmedia.model.Result
import com.yigitkavlak.rickandmortytaskvlmedia.util.downloadFromAPI
import com.yigitkavlak.rickandmortytaskvlmedia.util.placeHolderProgressBar

class CharacterAdapter( val characterList : ArrayList<Result>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(var view:View) : RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_character,parent,false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
       holder.view.characterID.text = characterList[position].name
       holder.view.characterStatus.text = characterList[position].status




        holder.view.characterImageView.downloadFromAPI(characterList[position].image,
            placeHolderProgressBar(holder.view.context))


    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun updateCharacterList(newCharacterList: List<Result>){

        characterList.clear()
        characterList.addAll(newCharacterList)
        notifyDataSetChanged()



    }
}