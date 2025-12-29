package com.island.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.island.app.ui.auth.SignUpScreen

@Composable
fun IslandNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.SignUp.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.SignUp.route) {
            SignUpScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                },
                onSignUpSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Login.route) {
            // TODO: LoginScreen
        }
        
        composable(Screen.Home.route) {
            // TODO: HomeScreen
        }
    }
}
