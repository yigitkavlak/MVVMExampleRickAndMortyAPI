package com.yigitkavlak.rickandmortytaskvlmedia.service


import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CharacterAPIService {

    //https://rickandmortyapi.com/api/character/
    //Base URL -->> https://rickandmortyapi.com/api/
    //Extention -->character/

    private val BASE_URL = "https://rickandmortyapi.com/api/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CharacterAPI::class.java)

    fun getCharacterData() : Single<List<Character>>{

        return api.getCharacters()
    }

}