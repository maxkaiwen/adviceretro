package example.com.adviceretro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import example.com.adviceretro.repo.MainRepository
import example.com.adviceretro.data.ApiHelper


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}