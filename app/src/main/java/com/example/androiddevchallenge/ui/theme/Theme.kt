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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val LightColorPalette = MyColors(
    gradient2_1 = listOf(Shadow4, Shadow11),
    uiBackground = Neutral0,
    iconInteractive = Neutral0,
    isDark = false
)

private val DarkColorPalette = MyColors(
    gradient2_1 = listOf(Ocean3, Shadow3),
    uiBackground = Neutral8,
    iconInteractive = Neutral7,
    isDark = true
)

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideMyColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object MyTheme {
    val colors: MyColors
    @Composable
    get() = LocalMyColors.current
}

/**
 * My custom Color Palette
 */
@Stable
class MyColors(
    gradient2_1: List<Color>,
    interactivePrimary: List<Color> = gradient2_1,
    uiBackground: Color,
    iconInteractive: Color,
    isDark: Boolean
) {
    var gradient2_1 by mutableStateOf(gradient2_1)
        private set
    var interactivePrimary by mutableStateOf(interactivePrimary)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var iconInteractive by mutableStateOf(iconInteractive)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: MyColors) {
        gradient2_1 = other.gradient2_1
        interactivePrimary = other.interactivePrimary
        uiBackground = other.uiBackground
        iconInteractive = other.iconInteractive
        isDark = other.isDark
    }
}

@Composable
fun ProvideMyColors(
    colors: MyColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalMyColors provides colorPalette, content = content)
}

private val LocalMyColors = staticCompositionLocalOf<MyColors> {
    error("No MyColorPalette provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.White
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)
