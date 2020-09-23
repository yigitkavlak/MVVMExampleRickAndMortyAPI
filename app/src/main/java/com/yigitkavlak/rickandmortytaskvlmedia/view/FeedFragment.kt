package com.yigitkavlak.rickandmortytaskvlmedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yigitkavlak.rickandmortytaskvlmedia.R
import com.yigitkavlak.rickandmortytaskvlmedia.adapter.CharacterAdapter
import com.yigitkavlak.rickandmortytaskvlmedia.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val characterAdapter = CharacterAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        characterList.layoutManager = LinearLayoutManager(context)
        characterList.adapter = characterAdapter

        swipeRefreshLayout.setOnRefreshListener {
            characterList.visibility = View.GONE
            characterError.visibility = View.GONE
            characterLoading.visibility = View.GONE
            viewModel.refreshData()
            swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    private fun observeLiveData() {
        viewModel.characters.observe(viewLifecycleOwner, Observer { characters ->

            characters?.let {
                characterList.visibility = View.VISIBLE
                characterAdapter.updateCharacterList(characters)

            }


        })

        viewModel.characterError.observe(viewLifecycleOwner, Observer { error ->

            error?.let {

                if (it) {

                    characterError.visibility = View.VISIBLE

                } else {
                    characterError.visibility = View.GONE
                }

            }

        })

        viewModel.characterLoading.observe(viewLifecycleOwner, Observer { loading ->

            loading?.let {
                if (it) {

                    characterLoading.visibility = View.VISIBLE
                    characterList.visibility = View.GONE
                    characterError.visibility = View.GONE
                } else {
                    characterLoading.visibility = View.GONE

                }
            }

        })

    }


}