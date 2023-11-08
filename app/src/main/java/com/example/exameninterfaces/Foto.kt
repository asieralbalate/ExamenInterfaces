package com.example.exameninterfaces

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.exameninterfaces.ui.theme.FontTittle
import com.example.exameninterfaces.ui.theme.Purple80
import com.example.exameninterfaces.ui.theme.PurpleGrey80
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun Foto(navController1: String, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val nombreImagen = navBackStackEntry?.arguments?.getString("nombreImagen") ?: ""
    val imageResId = when (nombreImagen) {
        "Image" -> R.drawable.image
        "Image 1" -> R.drawable.image1
        "Image 2" -> R.drawable.image2
        "Image 3" -> R.drawable.image3
        "Image 4" -> R.drawable.image4
        "Image 5" -> R.drawable.image5
        "Image 6" -> R.drawable.image6
        "Image 7" -> R.drawable.image7
        "Image 8" -> R.drawable.image8
        else -> R.drawable.image
    }

    Scaffold(topBar = {
        MyTopAppBar()
    }, content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding()
                )
        ) {
            Column (modifier = Modifier.fillMaxSize()){
                Row(Modifier.fillMaxWidth().background(Purple80).height(90.dp),horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = nombreImagen,
                        fontFamily = FontTittle,
                        fontSize = 82.sp,
                        color = Color.White,
                    )
                }
                Row (Modifier.fillMaxSize()){
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                }
            }
        }
        Box (Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd){
            FloatingActionButton(
                modifier = Modifier.padding(10.dp),
                containerColor = PurpleGrey80,
                onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
    )
}

