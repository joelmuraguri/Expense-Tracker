package com.joel.design.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.design.WalletIcons

@Composable
fun ProfileActions(
    icon : Int,
    text: String,
    color: Color,
    modifier: Modifier = Modifier
){

    TextButton(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),

    ) {
        Box(
            modifier = Modifier
                .background(color)
                .shadow(shape = RoundedCornerShape(10.dp), elevation = 0.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                tint = Color.White
            )
        }
        Text(
            text = text,
            modifier = Modifier
                .padding(8.dp)
        )
        Box(
           contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                painter = painterResource(id = WalletIcons.ArrowForward),
                contentDescription = "",
                modifier = Modifier

            )
        }
    }
}

@Preview("Profile Actions contents")
@Preview("Profile Actions (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewProfileActions() {

    ProfileActions(
        icon = WalletIcons.Privacy,
        text = "Privacy Policy",
        color = Color.Magenta
    )

}

enum class Actions(
    val icon : Int,
    val text : String,
    val color : Color
){
    ACCOUNT(
        icon = WalletIcons.Profile,
        text = "Account Info",
        color = Color.Blue
    ),
    SECURITY(
        icon = WalletIcons.Security,
        text = "Security Code",
        color = Color.Green
    ),
    PRIVACY(
        icon = WalletIcons.Privacy,
        text = "Privacy Policy",
        color = Color.Magenta
    ),
    SETTINGS(
        icon = WalletIcons.Settings,
        text = "Settings",
        color = Color.Yellow
    ),
    LOGOUT(
        icon = WalletIcons.Logout,
        text = "Logout",
        color = Color.Red
    )
}
