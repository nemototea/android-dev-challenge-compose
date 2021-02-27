package com.example.androiddevchallenge.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.main.MainActivityViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.Neutral8

@Composable
fun DogDetail(
    viewModel: MainActivityViewModel,
    id: Int,
    upPress: () -> Unit
) {
    val dog = viewModel.dogs.first { it.id == id }
    Box(Modifier.fillMaxSize()) {
        Body(dog)
        Header()
        RoundedImage(dog.image)
        Up(upPress)
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(MyTheme.colors.interactivePrimary))
    )
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Neutral8.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = MyTheme.colors.iconInteractive,
            contentDescription = null
        )
    }
}

@Composable
private fun RoundedImage(
    image: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(240.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
private fun Body(dog: Dog) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState(0))
    ) {
        Spacer(modifier = Modifier.size(360.dp))
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = dog.name,
                color = Color.Black,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = dog.age.toString() + " y.o.",
                color = Color.Black,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.size(24.dp))
            Icon(
                imageVector = when (dog.gender) {
                    Gender.MALE -> Icons.Filled.Male
                    Gender.FEMALE -> Icons.Filled.Female
                },
                contentDescription = null,
                modifier = Modifier.size(40.dp),
            )
        }
        Spacer(modifier = Modifier.size(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "HOUSE・TRAINED",
                color = Color.Black,
                fontSize = 32.sp
            )
            Text(
                text = when {
                    dog.houseTrained -> "yes"
                    else -> "no"
                },
                color = Color.DarkGray,
                fontSize = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "ADOPTION FEE",
                color = Color.Black,
                fontSize = 32.sp
            )
            Text(
                text = "$ " + dog.fee,
                color = Color.DarkGray,
                fontSize = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "HEALTH",
                color = Color.Black,
                fontSize = 32.sp
            )
            Text(
                text = dog.health,
                color = Color.DarkGray,
                fontSize = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "PERSONALITIES",
                color = Color.Black,
                fontSize = 32.sp
            )
            Text(
                text = dog.personalities.joinToString("/"),
                color = Color.DarkGray,
                fontSize = 24.sp
            )
        }
    }
}