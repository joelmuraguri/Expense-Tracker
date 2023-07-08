package com.joel.edit_presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val EDIT_GRAPH = "edit_graph"
const val EDIT_ROUTE = "edit"
const val ADD_EXPENSE_ROUTE = "add_expense"
const val ADD_INCOME_ROUTE = "add_income"

fun NavController.navigateToEdit(navOptions: NavOptions?= null){
    this.navigate(EDIT_ROUTE, navOptions)
}

fun NavController.navigateToAddExpense(){
    this.navigate(ADD_EXPENSE_ROUTE){
        launchSingleTop = true
    }
}

fun NavController.navigateToAddIncome(){
    this.navigate(ADD_INCOME_ROUTE){
        launchSingleTop = true
    }
}

fun NavGraphBuilder.editRoute(
    onAddIncomeClick: () -> Unit,
    onAddExpenseClick: () -> Unit,
    onPopBackStack : () -> Unit

){


    composable(route = EDIT_ROUTE) {
        EditScreen(
            onAddIncomeClick = { onAddIncomeClick() },
            onAddExpenseClick = { onAddExpenseClick() },
            onPopBackStack = onPopBackStack
        )
    }

}


fun NavGraphBuilder.addExpenseRoute(onPopBackStack : () -> Unit){
    composable(route = ADD_EXPENSE_ROUTE){
        AddExpense(onPopBackStack)
    }
}

fun NavGraphBuilder.addIncomeRoute(onPopBackStack : () -> Unit){
    composable(route = ADD_INCOME_ROUTE){
        AddIncome(onPopBackStack = onPopBackStack)
    }
}


