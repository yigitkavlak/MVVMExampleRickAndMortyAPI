package com.yigitkavlak.rickandmortytaskvlmedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yigitkavlak.rickandmortytaskvlmedia.view.DetailFragmentArgs
import com.yigitkavlak.rickandmortytaskvlmedia.R
import com.yigitkavlak.rickandmortytaskvlmedia.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private lateinit var viewModel : CharacterViewModel


    private var characterUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        viewModel.getDataFromRoom()

        arguments?.let {

            characterUuid = DetailFragmentArgs.fromBundle(it).characterUuid
        }
    }

   private fun observeLiveData(){

       viewModel.characterLiveData.observe(viewLifecycleOwner, Observer { character ->

           character?.let {
               /*characterNameText.text = character.characterName
               characterStatusText.text = character.characterStatus
               characterLocationText.text = character.characterLocation

                */


           }

       })


   }
}