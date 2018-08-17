package com.example.taras.cleanarchitecturetemplate

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout.VERTICAL
import com.example.taras.cleanarchitecturetemplate.model.LineStatusPresentation
import com.example.taras.cleanarchitecturetemplate.presenter.StatusPresenter
import com.example.taras.cleanarchitecturetemplate.view.StatusView
import com.example.taras.cleanarchitecturetemplate.view.adapter.LinesStatusAdapter
import kotlinx.android.synthetic.main.activity_status.*
import javax.inject.Inject

class StatusActivity : AppCompatActivity(), StatusView {

    @Inject
    lateinit var statusPresenter: StatusPresenter

    @Inject
    lateinit var statusAdapter: LinesStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)
        (application as App).applicationComponent.inject(this)

        statusPresenter.attachView(this)

        initSwipeRefreshLayout()
        initRecyclerView()
    }

    //region StatusView
    override fun showLoading(loading: Boolean) {
        srl_lines_status.isRefreshing = loading
    }

    override fun showLinesStatus(linesStatus: List<LineStatusPresentation>) {
        statusAdapter.setLinesStatus(linesStatus)
    }

    override fun showError() {
        Snackbar.make(activity_main, R.string.error_message, Snackbar.LENGTH_LONG).show()
    }
    //endregion

    //region Utility Api
    private fun initSwipeRefreshLayout() {
        srl_lines_status.setOnRefreshListener { statusPresenter.fetchLinesStatus() }
    }

    private fun initRecyclerView() {
        recycler_view_lines_status.layoutManager = LinearLayoutManager(this)
        recycler_view_lines_status.adapter = statusAdapter

        val itemDecor = DividerItemDecoration(this, VERTICAL)
        recycler_view_lines_status.addItemDecoration(itemDecor)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }
    //endregion
}


