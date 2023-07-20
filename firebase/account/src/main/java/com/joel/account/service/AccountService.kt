package com.joel.account.service

import com.joel.account.model.User
import kotlinx.coroutines.flow.Flow

interface AccountService {

    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>
    suspend fun signIn(email : String, password : String)
    suspend fun signUp(userName : String, password : String, email : String)
    suspend fun createAnonymousAccount()
    suspend fun signInWithGoogle()
    suspend fun linkAccount(email: String, password: String)
    suspend fun deleteAccount()
    suspend fun signOut()
    suspend fun sendPasswordChange(email: String)
}