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

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.data.Personality.AFFECTIONATE
import com.example.androiddevchallenge.data.Personality.ANXIOUS
import com.example.androiddevchallenge.data.Personality.CURIOUS
import com.example.androiddevchallenge.data.Personality.FEARLESS
import com.example.androiddevchallenge.data.Personality.FRIENDLY
import com.example.androiddevchallenge.data.Personality.GENTLE
import com.example.androiddevchallenge.data.Personality.NAUGHTY
import com.example.androiddevchallenge.data.Personality.PATIENT
import com.example.androiddevchallenge.data.Personality.SHY
import com.example.androiddevchallenge.data.Personality.SMART
import com.example.androiddevchallenge.data.Personality.STUBBORN
import com.example.androiddevchallenge.data.Personality.STUPID

class MainActivityViewModel: ViewModel() {
    val dogs: List<Dog> = listOf(
        Dog(
            id = 0,
            name = "Beau",
            gender = Gender.MALE,
            age = 1,
            personalities = listOf(SMART, GENTLE, SHY),
            houseTrained = true,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_1
        ),
        Dog(
            id = 1,
            name = "Jax",
            gender = Gender.MALE,
            age = 2,
            personalities = listOf(FRIENDLY, NAUGHTY),
            houseTrained = false,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_2
        ),
        Dog(
            id = 2,
            name = "Iris",
            gender = Gender.FEMALE,
            age = 3,
            personalities = listOf(AFFECTIONATE, CURIOUS),
            houseTrained = false,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_3
        ),
        Dog(
            id = 3,
            name = "Matilda",
            gender = Gender.FEMALE,
            age = 2,
            personalities = listOf(PATIENT, STUBBORN),
            houseTrained = true,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_4
        ),
        Dog(
            id = 4,
            name = "Avalon",
            gender = Gender.FEMALE,
            age = 2,
            personalities = listOf(FEARLESS, NAUGHTY),
            houseTrained = false,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_5
        ),
        Dog(
            id = 5,
            name = "Cail",
            gender = Gender.MALE,
            age = 1,
            personalities = listOf(STUPID, NAUGHTY),
            houseTrained = false,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_6
        ),
        Dog(
            id = 6,
            name = "Tarzan",
            gender = Gender.MALE,
            age = 3,
            personalities = listOf(CURIOUS, STUBBORN),
            houseTrained = true,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_7
        ),
        Dog(
            id = 7,
            name = "Ivy",
            gender = Gender.FEMALE,
            age = 2,
            personalities = listOf(SMART, ANXIOUS),
            houseTrained = true,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_8
        ),
        Dog(
            id = 9,
            name = "Ariel",
            gender = Gender.FEMALE,
            age = 2,
            personalities = listOf(PATIENT, SHY),
            houseTrained = true,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_9
        ),
        Dog(
            id = 10,
            name = "Pepper",
            gender = Gender.MALE,
            age = 1,
            personalities = listOf(FRIENDLY, CURIOUS),
            houseTrained = false,
            fee = 350.00,
            health = "Vaccinations up to date.",
            image = R.drawable.dog_10
        )
    )
}