package com.n26.presentation.ui.views

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.n26.presentation.R
import com.n26.presentation.databinding.ActivityMainBinding
import com.n26.presentation.ui.adapter.ChatAdapter
import com.n26.presentation.ui.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupChat()
    }

    private fun setupChat() {
        binding?.sparkview?.adapter = ChatAdapter()

    }

    override val layoutResId: Int
        get() = R.layout.activity_main
}