package com.example.shaadi.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shaadi.model.Results
import com.example.shaadi.repo.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val homeRepo: HomeRepo) : ViewModel() {

    fun getApiResponse(context: Context, count: Int) {
        return homeRepo.getApiResponse(context, count = count)
    }

    fun getResult(): MutableLiveData<List<Results>> {
        return homeRepo.dbResultsLiveData
    }


    fun updateStatus(statusFlag: Int, uniqueId: Int, email: String): Disposable {
        return homeRepo.updateStatus(statusFlag, uniqueId, email)
    }


    override fun onCleared() {
        super.onCleared()
        homeRepo.onDestroy()
    }
}