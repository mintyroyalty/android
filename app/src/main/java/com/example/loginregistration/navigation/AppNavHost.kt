package com.example.loginregistration.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginregistration.ui.theme.screens.home.Home_screen
import com.example.loginregistration.ui.theme.screens.login.login
import com.example.loginregistration.ui.theme.screens.register.Reg

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController= rememberNavController(),
    startDestination: String=ROUTE_HOME
) {
    NavHost(modifier = Modifier, startDestination = startDestination,navController=navController)
    {
    composable(ROUTE_HOME){ Home_screen(navController) }
        composable(ROUTE_LOGIN) { login(navController) }
        composable (ROUTE_REGISTER){ Reg(navController) }
    }
}