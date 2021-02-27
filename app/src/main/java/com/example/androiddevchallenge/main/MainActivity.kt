/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Female
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigate
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.composable
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.detail.DogDetail
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                NavGraph(viewModel)
            }
        }
    }
}

@Composable
fun NavGraph(viewModel: MainActivityViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(viewModel, navController) }
        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { defaultValue = 0 })
        ) {
            DogDetail(
                viewModel = viewModel,
                id = it.arguments?.getInt("id", 0) ?: throw Exception("Invalid value."),
                upPress = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun MainScreen(viewModel: MainActivityViewModel, navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(
            Modifier.background(Color.White)
        ) {
            items(viewModel.dogs) { dog ->
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(16.dp)
                ) {
                    Column(
                        Modifier.clickable {
                            // Transition by using Navigation Compose.
                            navController.navigate("detail/${dog.id}")
                        }
                    ) {
                        Image(
                            painter = painterResource(id = dog.image),
                            contentDescription = null,
                            modifier = Modifier
                                .height(160.dp)
                                .fillMaxWidth(),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Crop
                        )
                        Row(
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Text(
                                text = dog.name,
                                color = Color.Black,
                                fontSize = 24.sp
                            )
                            Spacer(modifier = Modifier.size(24.dp))
                            Text(
                                text = dog.age.toString() + " y.o.",
                                color = Color.Black,
                                fontSize = 24.sp
                            )
                            Spacer(modifier = Modifier.size(24.dp))
                            Icon(
                                imageVector = when (dog.gender) {
                                    Gender.MALE -> Icons.Filled.Male
                                    Gender.FEMALE -> Icons.Filled.Female
                                },
                                contentDescription = null,
                                modifier = Modifier.size(40.dp),
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
