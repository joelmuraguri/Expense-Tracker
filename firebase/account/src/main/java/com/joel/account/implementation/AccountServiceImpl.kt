package com.joel.account.implementation

import androidx.tracing.trace
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.joel.account.model.User
import com.joel.account.service.AccountService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class AccountServiceImpl(
    private val auth : FirebaseAuth
) : AccountService {


    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    override val hasUser: Boolean
        get() = auth.currentUser != null

    override val currentUser: Flow<User>
        get() = callbackFlow {
            val listener = FirebaseAuth.AuthStateListener { auth ->
                    this.trySend(auth.currentUser?.let { User(it.uid, it.isAnonymous) } ?: User())
                }
            auth.addAuthStateListener(listener)
            awaitClose { auth.removeAuthStateListener(listener) }
        }


    override suspend fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signUp(userName: String, password: String, email: String) {
        auth.createUserWithEmailAndPassword(email, password).await()
            .user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(userName).build())?.await()
    }

    override suspend fun createAnonymousAccount() {
        auth.signInAnonymously().await()
    }

    override suspend fun signInWithGoogle() {
        TODO("Not yet implemented")
    }

    override suspend fun linkAccount(email: String, password: String) {
        trace(LINK_ACCOUNT_TRACE){
            val credential = EmailAuthProvider.getCredential(email, password)
            auth.currentUser!!.linkWithCredential(credential)
        }
    }

    override suspend fun deleteAccount() {
        auth.currentUser!!.delete().await()
    }

    override suspend fun signOut() {
        if (auth.currentUser!!.isAnonymous){
            auth.currentUser!!.delete()
        }

        auth.signOut()
    }

    override suspend fun sendPasswordChange(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }


    companion object {
        private const val LINK_ACCOUNT_TRACE = "linkAccount"
    }
}