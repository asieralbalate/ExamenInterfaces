package com.example.exameninterfaces

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.palette.graphics.Palette
import com.example.exameninterfaces.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun Foto(navControllerName: String, navController: NavHostController) {
    val imageResId = when (navControllerName) {
        "Image 1" -> R.drawable.image1
        "Image 2" -> R.drawable.image2
        "Image 3" -> R.drawable.image3
        "Image 4" -> R.drawable.image4
        "Image 5" -> R.drawable.image5
        "Image 6" -> R.drawable.image6
        "Image 7" -> R.drawable.image7
        "Image 8" -> R.drawable.image8
        else -> R.drawable.image1
    }
    val context = LocalContext.current
    val bitmap = remember {
        BitmapFactory.decodeResource(context.resources, imageResId)
    }
    val palette = remember {
        Palette.from(bitmap).generate()
    }
    val darkVibrantSwatch = palette.darkVibrantSwatch
    val lightVibrantSwatch = palette.lightVibrantSwatch
    val vibrantSwatch = palette.vibrantSwatch
    val lightMutedSwatch = palette.lightMutedSwatch
    val mutedSwatch = palette.mutedSwatch
    val darkMutedSwatch = palette.darkMutedSwatch

    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = palette.darkVibrantSwatch?.rgb ?: colorScheme.primary.toArgb()

    Scaffold(floatingActionButtonPosition = FabPosition.End, floatingActionButton = {
        FloatingActionButton(
            modifier = Modifier.padding(10.dp),
            containerColor = PurpleGrey80,
            onClick = {
                navController.navigate("Portada")
            }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }, topBar = {
        MyTopAppBarFoto(vibrantSwatch, navControllerName)
    }, content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding()
                )

        ) {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.Black),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(400.dp)
                            .fillMaxWidth()
                    )
                }

                Row(modifier =
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(lightVibrantSwatch?.let { Color(it.rgb) } ?: Color.Green),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Light Vibrant")
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(darkVibrantSwatch?.let { Color(it.rgb) } ?: Color.Green),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Dark Vibrant")
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(lightMutedSwatch?.let { Color(it.rgb) } ?: Color.Green),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Light Muted")
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(mutedSwatch?.let { Color(it.rgb) } ?: Color.Green),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Muted")
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(darkMutedSwatch?.let { Color(it.rgb) } ?: Color.Green),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Dark Muted")
                }

            }
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {

            }
        }
    }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MyTopAppBarFoto(vibrantSwatch: Palette.Swatch?, navControllerName: String) {
    TopAppBar(colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = vibrantSwatch?.let {
        Color(
            it.rgb
        )
    }
        ?: Color.Transparent),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                    Text(
                        text = navControllerName,
                        color = vibrantSwatch?.let { Color(it.titleTextColor) } ?: Color.Red
                    )
                }
                Row {
                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
    )
}