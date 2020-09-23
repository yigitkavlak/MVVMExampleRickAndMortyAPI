package com.yigitkavlak.rickandmortytaskvlmedia.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yigitkavlak.rickandmortytaskvlmedia.model.Character
import com.yigitkavlak.rickandmortytaskvlmedia.model.Result
import com.yigitkavlak.rickandmortytaskvlmedia.service.CharacterAPI
import com.yigitkavlak.rickandmortytaskvlmedia.service.CharacterAPIService
import com.yigitkavlak.rickandmortytaskvlmedia.service.RetrofitClient
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Response

class FeedViewModel : ViewModel() {
    //.subscribeOn(Schedulers.newThread()) //başka thread
    //                .observeOn(AndroidSchedulers.mainThread()) //mainthread

    private val characterAPIService = CharacterAPIService()
    private val disposable =
        CompositeDisposable() //Fragmentler kapandıgında call'lardan kurtulmak ve hafızada yer kaplamamasını sağlamak için disposable kullanıyoruz. Kullan at gibi bir işlev sağlıyor.


    val characters = MutableLiveData<List<Result>>()
    val characterError = MutableLiveData<Boolean>()
    val characterLoading = MutableLiveData<Boolean>()

    lateinit var carlist: ArrayList<Result>

    //DummyDataSet

    fun refreshData() {

        getDataFromAPI()


    }



    private fun getDataFromAPI() {

        characterLoading.value = true

        RetrofitClient.getClient().create(CharacterAPI::class.java)
            .getCharacterRetro().enqueue(object : retrofit2.Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {

                    characters.value = response.body()!!.results
                    characterError.value = false
                    characterLoading.value = false
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {

                    characterLoading.value = false
                    characterError.value = true
                    t.printStackTrace()

                    println("başarısız")
                }


            })


    }

}