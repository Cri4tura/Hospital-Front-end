package com.example.hospital_front_end.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hospital_front_end.ui.screens.home.HomeView
import com.example.hospital_front_end.ui.screens.login.LoginView
import com.example.hospital_front_end.ui.screens.login.LoginViewModel
import com.example.hospital_front_end.ui.screens.nurseInfo.FindByNameView
import com.example.hospital_front_end.ui.screens.nurseInfo.NurseList
import com.example.hospital_front_end.ui.screens.profile.ProfileView
import com.example.hospital_front_end.ui.screens.signIn.SignInView

import com.example.hospital_front_end.ui.screens.splash_screen.SplashScreen
import com.example.hospital_front_end.utils.Constants

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: NavigationViewModel
) {

    LaunchedEffect(key1 = viewModel) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                Constants.NavigationEvent.NavigateToHome -> navController.navigate(Constants.Screen.Home.route)
                Constants.NavigationEvent.NavigateToLogin -> navController.navigate(Constants.Screen.Login.route)
                Constants.NavigationEvent.NavigateToFindByName -> navController.navigate(Constants.Screen.FindByName.route)
                Constants.NavigationEvent.NavigateToNurseList -> navController.navigate(Constants.Screen.NurseList.route)
                Constants.NavigationEvent.NavigateToRegister -> navController.navigate(Constants.Screen.SignIn.route)
                Constants.NavigationEvent.NavigateToProfile -> navController.navigate(Constants.Screen.Profile.route)
                Constants.NavigationEvent.NavigateToSplashScreen -> navController.navigate(Constants.Screen.SplashScreen.route)
                Constants.NavigationEvent.NavigateBack -> navController.popBackStack()
            }
        }
    }

    NavHost(navController = navController, startDestination = Constants.Screen.SplashScreen.route) {
        composable(Constants.Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Constants.Screen.Home.route) {
            HomeView(
                onConfirmLogout = { navController.popBackStack(); viewModel.navigateToLogin() },
                onViewNurseList = { viewModel.navigateToNurseList() },
                onSearchByName = { viewModel.navigateToFindByName() }
            )
        }
        composable(Constants.Screen.Login.route) {
            LoginView(
                viewModel = LoginViewModel(),
                onNavigateToHome = { viewModel.navigateToHome() },
                navigateToSignIn = { viewModel.navigateToSignIn() }
            )
        }
        composable(Constants.Screen.SignIn.route) {
            SignInView(
                onRegister = { _, _, _, _ ->
                    navController.popBackStack(); viewModel.navigateToHome( )
                },
                onBack = { viewModel.navigateBack() }
            )
        }
        composable(Constants.Screen.NurseList.route) {
            val nurseList by viewModel.nurseList.collectAsState()
            NurseList(
                nurseList = nurseList,
                onBack = { viewModel.navigateBack() },
                navigateToProfile = { nurse ->
                    viewModel.navigateToProfile(nurse)
                }
            )
        }
        composable(Constants.Screen.FindByName.route) {
            val nurseList by viewModel.nurseList.collectAsState()
            FindByNameView(
                nurseList = nurseList,
                onBack = { viewModel.navigateBack() },
                navigateToProfile = { nurse ->
                    viewModel.navigateToProfile(nurse)
                }
            )
        }
        composable(Constants.Screen.Profile.route) {
            ProfileView(
                nurse = viewModel.selectedNurse,
                onBack = { viewModel.navigateBack() }
            )
        }
    }
}
