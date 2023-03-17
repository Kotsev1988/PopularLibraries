package com.example.popularlibraries.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.UsersPresenter
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.example.popularlibraries.domain.Users
import com.example.popularlibraries.domain.UsersView


class MainActivity : AppCompatActivity(), UsersView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = UsersRecyclerAdapter()
    private val presenter = UsersPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerData.adapter = adapter

        binding.loadDataButton.setOnClickListener {
            binding.frameLoading.visibility = View.VISIBLE
            presenter.showUsers()
        }
    }

    override fun usersList(users: Users) {

        adapter.setData(users)
    }

    override fun onError(e: Throwable) {
        Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoad() {
        binding.frameLoading.visibility = View.VISIBLE
    }

    override fun hideLoad() {
        binding.frameLoading.visibility = View.GONE
    }


}