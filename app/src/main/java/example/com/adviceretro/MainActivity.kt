package example.com.adviceretro

import example.com.adviceretro.data.JsonModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import example.com.adviceretro.data.ApiHelper
import example.com.adviceretro.data.RetrofitBuilder
import androidx.lifecycle.*
import android.widget.TextView


class MainActivity(applicationContext: Any) : AppCompatActivity() {
    lateinit var view: TextView
    private val TAG = "ERROR: "
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupObserver()

    }


    private fun setupObserver() {
        mainViewModel.getQuotes().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {


                    it.data?.let { quote -> renderQuote(quote)}

                }
            Status.LOADING->{
                Toast.makeText(this, "loading", Toast.LENGTH_LONG).show()
            }
                Status.ERROR -> {
                    //Handle Error
                    it.message?.let { it1 -> Log.e(TAG, it1) }
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }

            }
        })
    }
    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun renderQuote(jsonModel: JsonModel) {
        view=findViewById(R.id.textViewQuote)
            view.text=jsonModel.slip.advice
        Toast.makeText(this,jsonModel.slip.advice,Toast.LENGTH_LONG).show()

    }
}