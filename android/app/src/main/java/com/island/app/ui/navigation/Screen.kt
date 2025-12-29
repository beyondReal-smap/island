package com.island.app.ui.navigation

sealed class Screen(val route: String) {
    object SignUp : Screen("signup")
    object Login : Screen("login")
    object Home : Screen("home")
    object Onboarding : Screen("onboarding")
}
