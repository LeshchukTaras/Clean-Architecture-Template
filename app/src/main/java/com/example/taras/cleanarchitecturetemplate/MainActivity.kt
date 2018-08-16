package com.example.taras.cleanarchitecturetemplate

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.taras.cleanarchitecturetemplate.R.id.srl_lines_status
import com.taras.domain.repository.StatusRepository
import com.taras.domain.rx.GetLineStatusInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getLinesStatusInteractor: GetLineStatusInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).applicationComponent.inject(this)

        (findViewById(srl_lines_status) as SwipeRefreshLayout).setOnRefreshListener {
            if (isNetworkAvailable()) {
                getLinesStatusInteractor.execute()
                        .subscribe(
                                { linesStatus ->
                                    refresh(false)
                                    Toast.makeText(applicationContext,
                                            linesStatus.toString(), Toast.LENGTH_LONG).show()
                                },
                                { throwable: Throwable? ->
                                    refresh(false)
                                    Toast.makeText(applicationContext,
                                            throwable?.message, Toast.LENGTH_LONG).show()
                                })
            } else {
                refresh(false)
                Toast.makeText(applicationContext,
                        "Network is unavailable !", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun refresh(isRefresh : Boolean) {
        (findViewById(srl_lines_status) as SwipeRefreshLayout).isRefreshing = isRefresh
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }
}


