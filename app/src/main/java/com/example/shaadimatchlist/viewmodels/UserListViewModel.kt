package com.example.shaadimatchlist.viewmodels;

import androidx.lifecycle.*
import com.example.shaadimatchlist.repositories.UserRepository
import com.example.shaadimatchlist.requests.Resource
import com.example.shaadimatchlist.requests.UserApi
import com.example.shaadimatchlist.room.DatabaseHelper
import com.example.shaadimatchlist.room.UserInfo
import kotlinx.coroutines.launch

class UserListViewModel(private val apiHelper: UserApi, private val dbHelper: DatabaseHelper): ViewModel() {
    private val repository = UserRepository(apiHelper)
    private val _userResponse: MutableLiveData<Resource<List<UserInfo>>> = MutableLiveData()
    val userResponse: LiveData<Resource<List<UserInfo>>>
        get() = _userResponse

    init {
        fetchUsers()
    }

    fun fetchUsers() = viewModelScope.launch {
        _userResponse.value = Resource.Loading
        val localDataSource = dbHelper.getUsers()
        localDataSource.observeForever(Observer {
            if (it.isEmpty()) {
                viewModelScope.launch {
                    val remoteDataSource = repository.getUsers(10)
                    val usersToInsertInDB = mutableListOf<UserInfo>()
                    remoteDataSource.let {
                        when (it) {
                            is Resource.Success -> {
                                val users = it.value.users
                                users.forEach() {
                                    usersToInsertInDB.add(UserInfo(it.login.uuid,
                                            it.login.username,
                                            it.name?.first,
                                            it.name?.last,
                                            it.dob?.age,
                                            it.location?.city,
                                            it.location?.state,
                                            it.location?.country,
                                            it.picture?.large,
                                            false,
                                            false
                                    ))
                                }
                                dbHelper.insertAll(usersToInsertInDB)
                            }
                            else -> {
                            }
                        }
                    }
                }
            } else {
                _userResponse.postValue(Resource.Success(it))
            }
        })
    }

    fun onAcceptButtonClicked(userId: String) = viewModelScope.launch {
        val userInfo = dbHelper.getUser(userId)
        userInfo.onAcceptClicked()
        dbHelper.updateUser(userInfo)
    }

    fun onDeclineButtonClicked(userId: String) = viewModelScope.launch {
        val userInfo = dbHelper.getUser(userId)
        userInfo.onDeclineClicked()
        dbHelper.updateUser(userInfo)
    }
}
