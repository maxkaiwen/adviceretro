package example.com.adviceretro.data


import retrofit2.http.GET

private const val id:String="1"
//private const val apiWe:String="group?id=524901,703448,2643743&appid="
private val TAG = "INFO: "
interface ApiService {
    @GET("advice")
   suspend fun getQuote(): JsonModel

}