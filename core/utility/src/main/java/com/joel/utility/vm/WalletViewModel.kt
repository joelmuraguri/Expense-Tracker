package com.joel.utility.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.utility.snackbar.SnackBarManager
import com.joel.utility.snackbar.SnackBarMessage.Companion.toSnackBarMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class WalletViewModel : ViewModel() {

    fun launchCatching(snackBar: Boolean = true, block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                if (snackBar) {
                    SnackBarManager.showMessage(throwable.toSnackBarMessage())
                }
            },
            block = block
        )


}