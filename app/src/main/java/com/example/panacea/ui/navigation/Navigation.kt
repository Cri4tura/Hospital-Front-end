package com.example.panacea.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.panacea.ui.screens.home.HomeView
import com.example.panacea.ui.screens.home.HomeViewModel
import com.example.panacea.ui.screens.login.LoginView
import com.example.panacea.ui.screens.login.LoginViewModel
import com.example.panacea.ui.screens.directory.DirectoryView
import com.example.panacea.ui.screens.directory.DirectoryViewModel
import com.example.panacea.ui.screens.detail.nurse.NurseDetailView
import com.example.panacea.ui.screens.detail.nurse.NurseDetailViewModel
import com.example.panacea.ui.screens.detail.room.RoomDetailView
import com.example.panacea.ui.screens.detail.room.RoomDetailViewModel
import com.example.panacea.ui.screens.documents.DocsView
import com.example.panacea.ui.screens.history.HistoryView
import com.example.panacea.ui.screens.news.NewsView
import com.example.panacea.ui.screens.profile.ProfileView
import com.example.panacea.ui.screens.profile.ProfileViewModel
import com.example.panacea.ui.screens.signIn.SignInView
import com.example.panacea.ui.screens.splash.SplashView
import com.example.panacea.ui.screens.signIn.SignInViewModel
import com.example.panacea.ui.screens.splash.SplashViewModel
import org.koin.compose.koinInject

@Composable
fun Navigation(
    nav: NavHostController
) {

    NavHost(navController = nav, startDestination = SPLASH) {
        composable<SPLASH> {
            SplashView(nav = nav, SplashViewModel(koinInject(), koinInject(),/* koinInject()*/))
        }
        composable<HOME> {
            HomeView(
                nav = nav,
                vm = HomeViewModel(koinInject(), koinInject())
            )
        }
        composable<LOGIN> {
            LoginView(
                vm = LoginViewModel(koinInject()),
                onLogIn = { nav.navigate(HOME) },
                onSignIn = { nav.navigate(SIGNING) },
                onConectionError = { nav.navigate(SPLASH) }
            )
        }
        composable<SIGNING> {
            SignInView(
                viewModel = SignInViewModel(koinInject()),
                onRegister = { name, lastName, birdthDay, email ->
                    nav.navigate(HOME)
                },
                onBack = { nav.popBackStack() }
            )
        }
        composable<DIRECTORY> {
            DirectoryView(
                nav = nav,
                vm = DirectoryViewModel(koinInject())
            )
        }
        composable<NURSE_DETAIL> { backStackEntry ->
            val detail = backStackEntry.toRoute<NURSE_DETAIL>()
            NurseDetailView(
                nurseId = detail.nurseId,
                nav = nav,
                vm = NurseDetailViewModel(
                    repository = koinInject(),
                    nurseId = detail.nurseId
                )
            )
        }
        composable<PROFILE> {
            ProfileView(
                nav = nav,
                vm = ProfileViewModel(koinInject())
            )
        }
        composable<DOCUMENTS> {
            DocsView(nav = nav)
        }
        composable<NEWS> {
            NewsView(nav = nav)
        }
        composable<HISTORY> {
            HistoryView(nav = nav)
        }
        composable<ROOM_DETAIL> { backStackEntry ->
            val detail = backStackEntry.toRoute<ROOM_DETAIL>()
            RoomDetailView(
                roomId = detail.roomId,
                nav = nav,
                vm = RoomDetailViewModel(
                    repository = koinInject(),
                    roomId = detail.roomId
                )
            )
        }
    }
}
