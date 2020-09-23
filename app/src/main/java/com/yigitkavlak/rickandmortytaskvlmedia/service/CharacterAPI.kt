package com.yigitkavlak.rickandmortytaskvlmedia.service


import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.Call

interface CharacterAPI {

    //GET, POST İşlemlerini burada yapabiliriz. Biz sadece veri okuyacağımız için GET işlemini kullanacağız.
    //Verileri :call ile de çekebiliriz fakat , RxJAVA bizim için daha yararlı olacağından dolayı :Observable'ı kullanacağız.

    //https://rickandmortyapi.com/api/character/
    //Base URL -->> https://rickandmortyapi.com/api/
    //Extention -->character/
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json


    @GET("character/")
    fun getCharacters(): Single<List<Character>>

    @GET("character/")

    fun getCharacterRetro(): Call<com.yigitkavlak.rickandmortytaskvlmedia.model.Character>


}