package com.swanky.rickandmortymvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.swanky.rickandmortymvvm.R
import com.swanky.rickandmortymvvm.adapters.CharacterAdapter
import com.swanky.rickandmortymvvm.databinding.FragmentCharactersBinding
import com.swanky.rickandmortymvvm.utils.hide
import com.swanky.rickandmortymvvm.utils.show
import com.swanky.rickandmortymvvm.viewmodels.CharactersFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private lateinit var viewModel: CharactersFragmentViewModel
    private lateinit var dataBinding: FragmentCharactersBinding
    private val characterAdapter = CharacterAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        if (!::dataBinding.isInitialized) {
            dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_characters, container, false)
        }

        return dataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CharactersFragmentViewModel::class.java]
        viewModel.getCharacters()
        onLoading(loading = true)

        dataBinding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = characterAdapter
            setHasFixedSize(true)
        }

        defineRefreshLayout()
        observeLiveData()
    }

    private fun defineRefreshLayout(){
        dataBinding.refreshLayout.setOnRefreshListener {
            onLoading(loading = true)
            dataBinding.errorTextView.visibility = View.GONE
            viewModel.refreshCharacters()
            dataBinding.refreshLayout.isRefreshing = false
        }
    }

    private fun observeLiveData(){
        viewModel.charactersLiveData.observe(viewLifecycleOwner) {
            characterAdapter.updateList(it)
            onLoading(false)
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            onError(it)
        }

        viewModel.pageNumber.observe(viewLifecycleOwner) {
            dataBinding.pageNumberTxt.text = "Displayed page number: $it\nSwipe down to refresh"
        }
    }

    private fun onError(errorMessage: String){
        dataBinding.recyclerView.hide()
        dataBinding.loadingProgress.hide()
        dataBinding.topLayout.hide()
        dataBinding.errorTextView.show()
        dataBinding.errorString = errorMessage
    }

    private fun onLoading(loading: Boolean){
        val errorTxt = dataBinding.errorTextView
        val recyclerView = dataBinding.recyclerView
        val progressBar = dataBinding.loadingProgress
        val topLayout = dataBinding.topLayout

        if(loading){
            recyclerView.hide()
            progressBar.show()
            topLayout.hide()
        }else{
            recyclerView.show()
            progressBar.hide()
            topLayout.show()
        }

        errorTxt.hide()
    }


}