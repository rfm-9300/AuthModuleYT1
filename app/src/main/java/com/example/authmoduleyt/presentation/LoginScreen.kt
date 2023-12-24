package com.example.authmoduleyt.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.authmoduleyt.presentation.components.HeaderBackground
import com.example.authmoduleyt.presentation.viewModel.LoginViewModel
import com.example.authmoduleyt.ui.theme.orange
import com.example.authmoduleyt.ui.theme.white
import com.example.authmoduleyt.ui.theme.whiteGrayOrange

@Composable
fun LoginScreen(
    onLoginSuccessNavigation: () -> Unit,
    onNavigateToRegisterScreen: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(120.dp),
            contentAlignment = Alignment.Center
        ){
            HeaderBackground(
                leftColor = orange,
                rightColor = whiteGrayOrange,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text ="Login",
                style = MaterialTheme.typography.h4,
                color = white,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}