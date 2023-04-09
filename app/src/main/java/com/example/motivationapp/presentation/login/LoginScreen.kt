package com.example.motivationapp.presentation.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.motivationapp.navigation.MotivScreens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay


@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var email by rememberSaveable{
        mutableStateOf("")
    }
    var password by rememberSaveable{ mutableStateOf("") }

    var passwordVisibility by rememberSaveable{ mutableStateOf(false) }
    var LoadingButton by remember {
        mutableStateOf(false)
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xff050C16)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 529.dp)
                    .background(
                        color = Color(0xff37a3f2),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 108.dp,
                            bottomEnd = 108.dp
                        )


                    )

            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(529.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Text(
                        text = "LOGIN",
                        fontWeight = FontWeight.Light,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    TextField(
                        value = email,
                        onValueChange = {it->
                             email = it
                        },
                        placeholder = { Text(text = "EmailId") },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xffD6E6F1),
                            textColor = Color.Black,
                            placeholderColor = Color.Gray
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        singleLine = true,
                        maxLines = 1,
                        visualTransformation = VisualTransformation.None


                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    TextField(
                        value = password,
                        onValueChange = {it->
                            password = it
                        },
                        placeholder = { Text(text = "Password") },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xffD6E6F1),
                            textColor = Color.Black,
                            placeholderColor = Color.Gray
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        singleLine = true,
                        maxLines = 1,
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                Icon(
                                    if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                                )
                            }
                        }


                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        onClick = {
                            viewModel.signInWithEmailAndPassword(email = email.trim(),password = password.trim())

                            if(Firebase.auth.currentUser!!.email.toString() !=null){
                                navController.navigate(MotivScreens.HomeScreen.name)
                            }else{
                                navController.navigate(MotivScreens.LoginScreen.name)

                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(66.dp)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            disabledBackgroundColor = Color.Gray,
                            disabledContentColor = Color.LightGray
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 16.dp
                        ),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text(text = "LOGIN", fontSize = 16.sp, fontWeight = FontWeight.W300)
                    }



            }
            }
            Spacer(modifier = Modifier.height(66.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(529.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){


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

                    Button(
                        onClick = {

                                navController.navigate(MotivScreens.CreateAccountScreen.name)

                                  },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(66.dp)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xff1E9A7C),
                            contentColor = Color.White,
                            disabledBackgroundColor = Color.Gray,
                            disabledContentColor = Color.LightGray
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 16.dp
                        ),
                        shape = RoundedCornerShape(28.dp)
                    ) {
                        Text(text = "Sign Up", fontSize = 16.sp, fontWeight = FontWeight.W300)
                    }

                }
                val  indicatorSize: Dp = 100.dp
                val circleColors: List<Color> = listOf(
                Color(0xFF5851D8),
                Color(0xFF833AB4),
                Color(0xFFC13584),
                Color(0xFFE1306C),
                Color(0xFFFD1D1D),
                Color(0xFFF56040),
                Color(0xFFF77737),
                Color(0xFFFCAF45),
                Color(0xFFFFDC80),
                Color(0xFF5851D8)
                )
                val animationDuration: Int = 360
                val infiniteTransition = rememberInfiniteTransition()

                val rotateAnimation by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = animationDuration,
                            easing = LinearEasing
                        )
                    )
                )

                if(viewModel.loading.value == true){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(size = indicatorSize)
                            .rotate(degrees = rotateAnimation)
                            .border(
                                width = 4.dp,
                                brush = Brush.sweepGradient(circleColors),
                                shape = CircleShape
                            ),
                        progress = 1f,
                        strokeWidth = 1.dp,
                        color = MaterialTheme.colors.background // Set background color
                    )

                }







            }

        }

    }

}
/*

@Composable
fun LoadingAnimation(
    indicatorSize: Dp = 100.dp,
    circleColors: List<Color> = listOf(
        Color(0xFF5851D8),
        Color(0xFF833AB4),
        Color(0xFFC13584),
        Color(0xFFE1306C),
        Color(0xFFFD1D1D),
        Color(0xFFF56040),
        Color(0xFFF77737),
        Color(0xFFFCAF45),
        Color(0xFFFFDC80),
        Color(0xFF5851D8)
    ),
    animationDuration: Int = 360
) {

    val infiniteTransition = rememberInfiniteTransition()

    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = LinearEasing
            )
        )
    )


    CircularProgressIndicator(
        modifier = Modifier
            .size(size = indicatorSize)
            .rotate(degrees = rotateAnimation)
            .border(
                width = 4.dp,
                brush = Brush.sweepGradient(circleColors),
                shape = CircleShape
            ),
        progress = 1f,
        strokeWidth = 1.dp,
        color = MaterialTheme.colors.background // Set background color
    )
}

 */

