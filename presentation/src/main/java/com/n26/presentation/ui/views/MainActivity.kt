package com.n26.presentation.ui.views

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.n26.presentation.R
import com.n26.presentation.databinding.ActivityMainBinding
import com.n26.presentation.ui.adapter.ChatAdapter

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        setupChat()
    }

    private fun setupChat() {
        binding?.sparkview?.adapter = ChatAdapter()

    }
}