package com.example.motivationapp.presentation.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.motivationapp.navigation.MotivScreens
import kotlinx.coroutines.delay


@Composable
fun CreateAccountScreen(
     navController: NavHostController,
     viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{ mutableStateOf("") }

    var passwordVisibility by rememberSaveable{ mutableStateOf(false) }





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
                        text = "Create Account",
                        fontWeight = FontWeight.Light,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "Enter a valid email id ",
                        fontStyle = FontStyle.Normal,
                        color = Color.White,
                    )
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
                                  viewModel.signUpWithEmailAndPassword(email = email.toString().trim(),password = password.trim() )
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
                        Text(text = "Create", fontSize = 16.sp, fontWeight = FontWeight.W300)
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
                                  navController.navigate(MotivScreens.LoginScreen.name)

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
                        Text(text = "Go to Login", fontSize = 16.sp, fontWeight = FontWeight.W300)
                    }

                }




            }

        }

    }

}

fun isValidEmail(email: String): Boolean {
    val emailPattern = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    return emailPattern.matches(email)
}