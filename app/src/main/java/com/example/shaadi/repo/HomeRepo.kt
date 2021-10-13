package com.example.shaadi.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.shaadi.common.CommonConstant.Companion.DEFAULT_STATUS
import com.example.shaadi.common.CommonConstant.Companion.isNetworkConnected
import com.example.shaadi.database.AppDatabase
import com.example.shaadi.model.Results
import com.example.shaadi.network.NetworkServices
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeRepo
@Inject constructor(
    private val networkServices: NetworkServices,
    private val appDatabase: AppDatabase,


    ) {
    var bag: CompositeDisposable = CompositeDisposable()
    val dbResultsLiveData: MutableLiveData<List<Results>> = MutableLiveData()


    companion object {
        private const val TAG = "HomeRepo"
    }

    //ONLINE API CALL
    fun getApiResponse(context: Context, count: Int?) {
        if (isNetworkConnected(context = context)) {
            bag.add(
                networkServices.getApiResponse(count).subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe({
                        Log.e(TAG, "API-Success: ${it}")

                        insertDataToDb(it.results)

                    }, { t ->
                        Log.e(TAG, "API-Error: ${t.localizedMessage}")
                        dbResultsLiveData.postValue(null)
                    })
            )

        } else {

            getAllResultFromDb()
        }

    }

    //INSERT DATA
    private fun insertDataToDb(
        responseData: List<Results>
    ): Disposable {
        return Completable.fromAction {
            appDatabase.homeDao().deleteAll()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({

                responseData?.forEach {
                    it.statusFlag = DEFAULT_STATUS
                }
                appDatabase.homeDao().insertAll(responseData)
                Log.e(TAG, "inserted successfully")
                getAllResultFromDb()

            }, { t ->
                Log.e(TAG, "${t.localizedMessage}")
            })

    }


    //GET ALL DATA
    private fun getAllResultFromDb() {
        bag.add(
            appDatabase.homeDao().getAllResultFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({

                    dbResultsLiveData.postValue(it)

                }, {
                    Log.e(TAG, "DB-Error: ${it.localizedMessage}")
                    dbResultsLiveData.postValue(null)
                })
        )

    }

    //UPDATE METHOD
    fun updateStatus(statusFlag: Int, uniqueId: Int, email: String): Disposable {
        return Completable.fromAction {
            appDatabase.homeDao().update(statusFlag, uniqueId, email)

        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({

                Log.e(TAG, "status updated successfully")
            }, { t ->
                Log.e(TAG, "${t.localizedMessage}")
            })

    }

    fun onDestroy() {
        bag.dispose()
    }
}