package com.example.androidstarter.features.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.airbnb.epoxy.TypedEpoxyController
import com.example.androidstarter.R
import com.example.androidstarter.features.base.ui.model.ViewState

abstract class BaseActivity : AppCompatActivity() {
    @BindView(R.id.base_recycler)
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        ButterKnife.bind(this)
    }

    fun configRecycler(controller: TypedEpoxyController<ViewState>) {
        var controller = getController()

        recyclerView.adapter = controller.adapter
        controller.requestModelBuild()
    }

    abstract fun getController():TypedEpoxyController<ViewState>
}