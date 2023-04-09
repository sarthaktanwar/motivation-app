package com.example.motivationapp.presentation.screens.splashScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.motivationapp.R
import com.example.motivationapp.navigation.MotivScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController
) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF01060E)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        )  {
            
            Spacer(modifier = Modifier.height(40.dp))
            Ninetiesagreektempleturningtodustwindy()

            Spacer(modifier = Modifier.height(30.dp))


            RomeWasNotBuiltInADay()
            Spacer(modifier = Modifier.height(120.dp))
            Rectangle(navController = navController)


        }
}

@Preview
@Composable
fun Ninetiesagreektempleturningtodustwindy() {
    Image(
        painter = painterResource(id = R.drawable.greek_temple ),
        contentDescription = "Nineties_a_greek_temple_turning_to_dust._windy 1",
        modifier = Modifier
            .width(width = 362.dp)
            .height(height = 346.dp)
            .clip(shape = RoundedCornerShape(32.dp)))
}

@Composable
fun RomeWasNotBuiltInADay() {

    var isVisible = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {
        delay(2000)
        isVisible.value = true
    }

    AnimatedVisibility(
        visible = isVisible.value,
        enter = fadeIn(
            animationSpec = TweenSpec(
                durationMillis = 500
            )
        ),
        exit = fadeOut(
            animationSpec = TweenSpec(
                durationMillis = 1000
            )
        )

    ) {
        Text(
            text = "rome was not built in a day",
            color = Color(0xff878695),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 32.sp
            ),

            modifier = Modifier
                .width(width = 237.dp)
                .height(height = 164.dp)
        )
    }


}

@Composable
fun Rectangle(navController: NavHostController) {

    var isVisible = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {
        delay(2500)
        isVisible.value = true
    }

    AnimatedVisibility(
        visible = isVisible.value,
        enter = fadeIn(
            animationSpec = TweenSpec(
                durationMillis = 500
            )
        ),
        exit = fadeOut(
            animationSpec = TweenSpec(
                durationMillis = 1000
            )
        )

    ){

        Box(
            modifier = Modifier
                .width(width = 246.dp)
                .height(height = 52.dp)
                .clip(shape = RoundedCornerShape(32.dp))
                .background(color = Color(0xff1C3281))
                .clickable {

                    navController.navigate(MotivScreens.LoginScreen.name)



                    /*
                    if(FirebaseAuth.getInstance().currentUser!!.email.isNullOrEmpty()){
                        navController.popBackStack()

                        navController.navigate(MotivScreens.LoginScreen.name)

                    }
                    else {
                        navController.popBackStack()

                        navController.navigate(MotivScreens.HomeScreen.name)

                    }

                     */

                }
                
        ){

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Let's Get Started",
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    color =  Color(0xffA7C0D8)
                )
            }
         
        }

    }



}