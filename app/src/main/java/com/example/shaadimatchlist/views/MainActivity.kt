package com.example.shaadimatchlist.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders

import com.example.shaadimatchlist.R;
import com.example.shaadimatchlist.adapters.OnButtonClickListener;
import com.example.shaadimatchlist.adapters.UserRecyclerAdapter;
import com.example.shaadimatchlist.requests.Resource;
import com.example.shaadimatchlist.requests.ServiceGenerator
import com.example.shaadimatchlist.room.DatabaseHelperImpl
import com.example.shaadimatchlist.room.UserInfoDatabaseBuilder
import com.example.shaadimatchlist.utils.ViewModelFactory
import com.example.shaadimatchlist.viewmodels.UserListViewModel;

class MainActivity : AppCompatActivity(), OnButtonClickListener {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: UserRecyclerAdapter
    private lateinit var viewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewModel()
        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.userResponse.observe(this, Observer {
         when(it) {
             is Resource.Success -> {
                 mAdapter.setUsers(it.value)
             }
         }
        })
    }

    private fun initRecyclerView(){
        mRecyclerView = findViewById(R.id.user_list)
        mAdapter = UserRecyclerAdapter(this as OnButtonClickListener)
        mRecyclerView.setAdapter(mAdapter)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        mRecyclerView.hasFixedSize()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(
                        ServiceGenerator.getRestApi(),
                        DatabaseHelperImpl(UserInfoDatabaseBuilder.getInstance(applicationContext))
                )
        ).get(UserListViewModel::class.java)
    }

    override fun onAcceptButtonClicked(userId: String) {
        viewModel.onAcceptButtonClicked(userId)
    }

    override fun onDeclineButtonClicked(userId: String) {
        viewModel.onDeclineButtonClicked(userId)
    }
}