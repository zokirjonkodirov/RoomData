package com.example.memory.roomdata.data

import androidx.lifecycle.LiveData

/**
 * @author user
 * @date 20.08.2021
 */
class UserRepository(private val userDao: UserDao ) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

        suspend fun addUser(user: User) {
            userDao.addUser(user)
        }
}