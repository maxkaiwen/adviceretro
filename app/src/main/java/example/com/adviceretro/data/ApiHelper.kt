package example.com.adviceretro.data

import example.com.adviceretro.data.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getQuote() = apiService.getQuote()
}