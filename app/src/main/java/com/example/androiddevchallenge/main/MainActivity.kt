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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
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
            DetailScreen(
                id = it.arguments?.getInt("id", 0) ?: throw Exception("Invalid value.")
            )
        }
    }
}

@Composable
fun MainScreen(viewModel: MainActivityViewModel, navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Card {
                Text(text = "Ready... Set... GO!")
                Text(text = "Ready... Set... GO!")
                Text(text = "Ready... Set... GO!")
            }
        }
    }
}

@Composable
fun DetailScreen(id: Int) {

}
