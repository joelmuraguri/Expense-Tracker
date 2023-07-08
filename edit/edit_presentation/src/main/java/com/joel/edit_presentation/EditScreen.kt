package com.joel.edit_presentation

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.design.WalletIcons
import com.joel.design.components.NavigationToolBar

@Composable
fun EditScreen(){

    Scaffold(
        topBar = {
            NavigationToolBar(title = "Add") {

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AddFinanceAction(action = "Add Income", onActionClick = {})
                AddFinanceAction(action = "Add Expense", onActionClick = {})
            }
        }
    }


}

@Composable
fun AddFinanceAction(
    action : String,
    onActionClick : () -> Unit
){

    Card(
        modifier = Modifier
            .clickable { onActionClick() }
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                   .width(130.dp)
        ) {
            Icon(
                painter = painterResource(id = WalletIcons.walletIcon),
                contentDescription = "",
                modifier = Modifier
                    .padding(12.dp)
            )

            Text(
                text = action,
                modifier = Modifier
                    .padding(6.dp)
            )
        }
    }
}

@Preview("Finance contents")
@Preview("Finance contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewFinanceDrawer() {

    AddFinanceAction(action = "Add Income", onActionClick = {})

}

@Preview("Edit Screen contents")
@Preview("Edit Screen contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewEditScreenDrawer() {

    EditScreen()

}