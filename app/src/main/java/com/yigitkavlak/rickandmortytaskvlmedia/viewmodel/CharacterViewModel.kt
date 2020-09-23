package com.yigitkavlak.rickandmortytaskvlmedia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yigitkavlak.rickandmortytaskvlmedia.model.Character

class CharacterViewModel : ViewModel() {


    val characterLiveData = MutableLiveData<Character>()



    fun getDataFromRoom(){

       // val character = Character(3,"Yigit","Alive","Yenimahalle","www.yigit.com")
       // characterLiveData.value = character

    }

}