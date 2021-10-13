package com.example.shaadi.common

import android.content.Context
import android.net.ConnectivityManager

class CommonConstant {

    companion object {

        var baseUrl = "https://randomuser.me/"


        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            return cm?.activeNetworkInfo != null
        }

        //status
        const  val  DEFAULT_STATUS=2
        const  val  REJECT=1
        const  val  APPROVED=0
    }
}