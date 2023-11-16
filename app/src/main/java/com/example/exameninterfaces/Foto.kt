package com.example.exameninterfaces

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.exameninterfaces.ui.theme.Claro
import com.example.exameninterfaces.ui.theme.FontTittle
import com.example.exameninterfaces.ui.theme.Medio
import com.example.exameninterfaces.ui.theme.Oscuro
import com.example.exameninterfaces.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
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
    val brush = Brush.verticalGradient(listOf(Oscuro, Medio, Claro))
    var selectionRotacion by remember { mutableStateOf(0f) }
    var selectionScale by remember { mutableStateOf(1f) }
    var selectionEfectoAlfa by remember { mutableStateOf(1f) }
    var selectionDesenfoque by remember { mutableStateOf(0f) }
    val rangeRotacion = 0f..360f
    val rangeScale = 0.5f..3f
    val rangeEfectoAlfa = 0f..1f
    val rangeDesenfoque = 0f..20f


    Scaffold(topBar = {
        MyTopAppBar()
    }, content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding()
                )
                .background(brush)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(90.dp), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = nombreImagen,
                        fontFamily = FontTittle,
                        fontSize = 82.sp,
                        color = Color.White,
                    )
                }
                Row {

                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(400.dp)
                            .width(270.dp)
                            .blur(radiusX = selectionDesenfoque.toInt().dp, radiusY = selectionDesenfoque.toInt().dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                            .graphicsLayer {
                                this.rotationY = selectionRotacion
                                this.scaleX = selectionScale
                                this.scaleY = selectionScale
                                this.alpha = selectionEfectoAlfa
                            }
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Rotacion", modifier = Modifier.padding(end = 10.dp))
                    Slider(
                        value = selectionRotacion,
                        valueRange = rangeRotacion,
                        onValueChange = { selectionRotacion = it },
                        modifier = Modifier.width(180.dp),
                        steps = 180,
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Yellow, // Color del pulgar
                            activeTrackColor = Color.Yellow, // Color de la línea activa (donde se encuentra el pulgar)
                            inactiveTrackColor = Color.Blue, // Color de la línea inactiva
                            activeTickColor = Color.Yellow, // Color de las marcas en la línea activa
                            inactiveTickColor = Color.Black, // Color de las marcas en la línea inactiva
                        ),
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 20.dp)
                        ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Escalado", modifier = Modifier.padding(end = 10.dp))
                    Slider(
                        value = selectionScale,
                        valueRange = rangeScale,
                        onValueChange = { selectionScale = it },
                        modifier = Modifier.width(180.dp),
                        steps = 100,
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Yellow, // Color del pulgar
                            activeTrackColor = Color.Yellow, // Color de la línea activa (donde se encuentra el pulgar)
                            inactiveTrackColor = Color.Blue, // Color de la línea inactiva
                            activeTickColor = Color.Yellow, // Color de las marcas en la línea activa
                            inactiveTickColor = Color.Black, // Color de las marcas en la línea inactiva
                        ),
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 20.dp)
                        ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Efecto Alfa", modifier = Modifier.padding(end = 10.dp))
                    Slider(
                        value = selectionEfectoAlfa,
                        valueRange = rangeEfectoAlfa,
                        onValueChange = { selectionEfectoAlfa = it },
                        modifier = Modifier.width(180.dp),
                        steps = 10,
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Yellow, // Color del pulgar
                            activeTrackColor = Color.Yellow, // Color de la línea activa (donde se encuentra el pulgar)
                            inactiveTrackColor = Color.Blue, // Color de la línea inactiva
                            activeTickColor = Color.Yellow, // Color de las marcas en la línea activa
                            inactiveTickColor = Color.Black, // Color de las marcas en la línea inactiva
                        ),
                    )
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 20.dp)
                        ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Desenfoque", modifier = Modifier.padding(end = 10.dp))
                    Slider(
                        value = selectionDesenfoque,
                        valueRange = rangeDesenfoque,
                        onValueChange = { selectionDesenfoque = it },
                        modifier = Modifier.width(180.dp),
                        steps = 20,
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Yellow, // Color del pulgar
                            activeTrackColor = Color.Yellow, // Color de la línea activa (donde se encuentra el pulgar)
                            inactiveTrackColor = Color.Blue, // Color de la línea inactiva
                            activeTickColor = Color.Yellow, // Color de las marcas en la línea activa
                            inactiveTickColor = Color.Black, // Color de las marcas en la línea inactiva
                        ),
                    )
                }
            }
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                FloatingActionButton(
                    modifier = Modifier.padding(10.dp),
                    containerColor = PurpleGrey80,
                    onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }

    }
    )
}

