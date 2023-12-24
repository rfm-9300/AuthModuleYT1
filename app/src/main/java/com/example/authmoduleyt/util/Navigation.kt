package com.example.authmoduleyt.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authmoduleyt.presentation.FinalDestinationScreen
import com.example.authmoduleyt.presentation.LoginScreen
import com.example.authmoduleyt.presentation.RegisterScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Login.route
    ) {
        composable(route = ScreenRoutes.Login.route) {
            LoginScreen(
                onLoginSuccessNavigation = {
                    navController.navigate(ScreenRoutes.FinalDestination.route){
                        popUpTo(0)
                    }
                },
                onNavigateToRegisterScreen = {
                    navController.navigate(ScreenRoutes.Register.route){
                        popUpTo(0)
                    }
                }
            )
        }
        composable(route = ScreenRoutes.Register.route) {
            RegisterScreen(
                onRegisterSuccessNavigation = {
                    navController.navigate(ScreenRoutes.FinalDestination.route){
                        popUpTo(0)
                    }
                },
                onNavigateToLoginScreen = {
                    navController.navigate(ScreenRoutes.Login.route){
                        popUpTo(0)
                    }
                }
            )
        }
        composable(route = ScreenRoutes.FinalDestination.route) {
            FinalDestinationScreen()
        }

    }

}

sealed class ScreenRoutes(val route: String) {
    object Login : ScreenRoutes("login")
    object Register : ScreenRoutes("register")
    object FinalDestination : ScreenRoutes("final_destination")
}