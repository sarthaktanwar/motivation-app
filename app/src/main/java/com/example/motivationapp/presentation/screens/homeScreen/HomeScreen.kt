package com.example.motivationapp.presentation.screens.homeScreen

import android.graphics.Bitmap
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivationapp.R

@Preview
@Composable
fun HomeScreen(){
    val QuateList : List<String> = listOf("you are awasome"," you are the best", "God is with you ")
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color(0xff06091C),
                cutoutShape = CircleShape
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            selectedIndex = 0
                        /* Navigate to screen 1 */
                        }
                    ) {
                        Icon(
                            Icons.Filled.Home, contentDescription = "Home",
                            tint = if (selectedIndex == 0) Color.White else Color.Gray
                        )
                    }
                    IconButton(
                        onClick = {
                            selectedIndex = 1
                        /* Navigate to screen 2 */ }
                    ) {
                        Icon(
                            Icons.Filled.Search, contentDescription = "Search",
                            tint = if (selectedIndex == 1) Color.White else Color.Gray
                        )
                    }
                    IconButton(
                        onClick = {
                            selectedIndex = 2
                        /* Navigate to screen 3 */ }
                    ) {
                        Icon(
                            Icons.Filled.Add, contentDescription = "Add",
                            tint = if (selectedIndex == 2) Color.White else Color.Gray
                        )
                    }
                    IconButton(
                        onClick = {
                            selectedIndex = 3
                        /* Navigate to screen 4 */ }
                    ) {
                        Icon(
                            Icons.Filled.HeartBroken, contentDescription = "Profile",
                            tint = if (selectedIndex == 3) Color.White else Color.Gray
                        )

                    }
                    IconButton(
                        onClick = {
                            selectedIndex = 4/* Navigate to screen 5 */ }
                    ) {
                        Icon(
                            Icons.Filled.Person, contentDescription = "Profile",
                            tint = if (selectedIndex == 4) Color.White else Color.Gray
                        )
                    }
                }
            }
        }
    ) { PaddingValues->
        Surface(
            modifier = Modifier
                .padding(PaddingValues)
                .fillMaxSize()
        ) {

            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painterResource(id =com.example.motivationapp.R.drawable.motivate ) ,
                    contentDescription = "Ni",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(0.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(0.9f)

                ) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        userScrollEnabled = true,

                    ) {
                        items(quotes) { items->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 400.dp)
                                    .graphicsLayer(0.9f)
                            ){

                                Column(
                                    modifier = Modifier.background(Color.Transparent),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    Text(
                                        text = items.split(" - ")[0],

                                        color = Color.White,
                                        fontSize = 40.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "- ${items.split(" - ")[1]}",
                                        color = Color.White,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )



                                }





                            }



                        }
                    }



                }

            }




        }

    }





}

val quotes = listOf(
    "\"Believe you can and you're halfway there.\" - Theodore Roosevelt",
    "\"You miss 100% of the shots you don't take.\" - Wayne Gretzky",
    "\"The future belongs to those who believe in the beauty of their dreams.\" - Eleanor Roosevelt",
    "\"The only way to do great work is to love what you do.\" - Steve Jobs",
    "\"Success is not final, failure is not fatal: It is the courage to continue that counts.\" - Winston Churchill",
    "\"It's not about perfect. It's about effort. And when you bring that effort every single day, that's where transformation happens. That's how change occurs.\" - Jillian Michaels",
    "\"The only limit to our realization of tomorrow will be our doubts of today.\" - Franklin D. Roosevelt",
    "\"Challenges are what make life interesting and overcoming them is what makes life meaningful.\" - Joshua J. Marine",
    "\"Don't watch the clock; do what it does. Keep going.\" - Sam Levenson",
    "\"You are never too old to set another goal or to dream a new dream.\" - C.S. Lewis",
    "\"I have not failed. I've just found 10,000 ways that won't work.\" - Thomas A. Edison",
    "\"You are the master of your destiny. You can influence, direct and control your own environment. You can make your life what you want it to be.\" - Napoleon Hill",
    "\"If you want to achieve greatness stop asking for permission.\" - Unknown",
    "\"Success is walking from failure to failure with no loss of enthusiasm.\" - Winston Churchill",
    "\"The only person you are destined to become is the person you decide to be.\" - Ralph Waldo Emerson",
    "\"Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.\" - Christian D. Larson",
    "\"You don't have to be great to start, but you have to start to be great.\" - Zig Ziglar",
    "\"The best way to predict the future is to create it.\" - Peter Drucker",
    "\"The greatest glory in living lies not in never falling, but in rising every time we fall.\" - Nelson Mandela",
    "\"If you want to make your dreams come true, the first thing you have to do is wake up.\" - J.M. Power",
    "\"Success is not how high you have climbed, but how you make a positive difference to the world.\" - Roy T. Bennett",
    "\"Do not wait for opportunities, create them.\" - Roy T. Bennett",
    "\"The biggest adventure you can ever take is to live the life of your dreams.\" - Oprah Winfrey",
    "\"The man who has confidence in himself gains the confidence of others.\" - Hasidic Proverb",
    "\"You can have anything you want if you are willing to give up the belief that you can't have it.\" - Dr. Robert Anthony",
    "\"Believe in yourself, take on your challenges, dig deep within yourself to conquer fears. Never let anyone bring you down. You got this.\" - Chantal Sutherland"
)





