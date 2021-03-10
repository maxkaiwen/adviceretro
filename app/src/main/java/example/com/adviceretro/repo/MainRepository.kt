package example.com.adviceretro.repo

import example.com.adviceretro.data.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun  getQuote()=apiHelper.getQuote()
}