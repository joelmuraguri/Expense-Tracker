package com.joel.design.widget

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.design.R
import com.joel.design.WalletIcons

enum class CollapsibleFABState{
    Expanded,
    Collapsed
}

data class FABItem(
    val label : String,
    val route : String,
)

@Composable
fun CollapsibleFAB(
    collapsibleFABState: CollapsibleFABState,
    onCollapsibleFABChange: (CollapsibleFABState) -> Unit,
    items: List<FABItem>,
    onFABRoutes : (FABItem) -> Unit
){
    
    val transition = updateTransition(targetState = collapsibleFABState, label = "transition")

    val rotate by transition.animateFloat(label = "rotate") {
        if (it == CollapsibleFABState.Expanded) 315f else 0f
    }

    Column(
        horizontalAlignment = Alignment.End
    ) {
        if (transition.currentState == CollapsibleFABState.Expanded){
            items.forEach { items ->
                MinFABItem(
                    item = items,
                    onMinFABItemClicked = {
                       onFABRoutes(it)
                    })
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
        FloatingActionButton(
            onClick = {
                onCollapsibleFABChange(
                    if (transition.currentState == CollapsibleFABState.Expanded) {
                        CollapsibleFABState.Collapsed
                    } else {
                        CollapsibleFABState.Expanded
                    }
                )
            },
        ) {
            Icon(
                painter = painterResource(id = WalletIcons.Add),
                contentDescription = stringResource(id = R.string.add_icon_description),
                modifier = Modifier
                    .rotate(rotate)
            )
        }
    }
}

@Composable
fun MinFABItem(
    item : FABItem,
    onMinFABItemClicked : (FABItem) -> Unit
){

    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable {
                onMinFABItemClicked(item)
            },
    ) {
        Text(
            text = item.label,
            modifier = Modifier
                .padding(16.dp),
            fontSize = 18.sp
        )
    }
}

