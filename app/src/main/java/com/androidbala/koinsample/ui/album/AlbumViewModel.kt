package com.androidbala.koinsample.ui.album



import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidbala.koinsample.data.model.Albums
import com.androidbala.koinsample.data.repository.MainRepository
import com.androidbala.koinsample.utils.NetworkHelper
import com.androidbala.koinsample.utils.Resource
import kotlinx.coroutines.launch

class AlbumViewModel(private val mainRepository: MainRepository, private val networkHelper: NetworkHelper): ViewModel() {

    private val _albums = MutableLiveData<Resource<List<Albums>>>()
    val albums : LiveData<Resource<List<Albums>>>
        get()  = _albums

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {

        viewModelScope.launch {
            _albums.postValue(Resource.loading(null))

            if(networkHelper.isNetworkConnected()){
                mainRepository.getAlbums().let {
                    if(it.isSuccessful){
                        _albums.postValue(Resource.success(it.body()))
                    }else {
                        _albums.postValue(Resource.error(it.errorBody().toString(),null))
                    }
                }
            }else{
                _albums.postValue(Resource.error("No internet connection", null))
            }

        }

    }

}