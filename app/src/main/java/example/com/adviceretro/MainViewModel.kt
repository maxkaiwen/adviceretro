package example.com.adviceretro

import android.util.Log
import androidx.lifecycle.ViewModel

import androidx.lifecycle.liveData
import example.com.adviceretro.repo.MainRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
private val TAG = "INFO: "

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    fun getQuotes()= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try{
            Log.i(TAG,"Acessing repo")
            emit(Resource.success(data= mainRepository.getQuote()))
        }catch (exception:Exception){
            emit(Resource.error(data=null,msg=exception.message?:"error"))
        }
    }

}
