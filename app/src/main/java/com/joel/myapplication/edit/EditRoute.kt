package com.joel.myapplication.edit

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val INCOME_ROUTE = "income_route"
const val EXPENSE_ROUTE = "expense_route"

fun NavGraphBuilder.expenseRoute(
    popBackStack :() -> Unit

){
    composable(route = EXPENSE_ROUTE){
        ExpenseScreen(popBackStack)
    }

}

fun NavGraphBuilder.incomeRoute(
    popBackStack :() -> Unit

){
    composable(route = INCOME_ROUTE){
        IncomeScreen(popBackStack)
    }
}