package com.example.exameninterfaces

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.exameninterfaces.ui.theme.Purple80
import com.example.exameninterfaces.ui.theme.PurpleGrey80
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun Portada(navController: NavHostController) {
    var badgeCount by remember { mutableStateOf(0) }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
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
            val cardDataList = getCardData()
            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
                content = {
                    items(cardDataList.size) { index ->
                        ItemCard(cardDataList[index], navController)
                    }
                }
            )
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                FloatingActionButton(
                    modifier = Modifier.padding(10.dp),
                    containerColor = PurpleGrey80,
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
    )
}


data class CardData(
    var name: String,
    @DrawableRes var photo: Int
)

fun getCardData(): List<CardData> {
    return listOf(
        CardData(
            "Image",
            R.drawable.image,
        ),
        CardData(
            "Image 1",
            R.drawable.image1,
        ),
        CardData(
            "Image 2",
            R.drawable.image2,
        ),
        CardData(
            "Image 3",

            R.drawable.image3,
        ),
        CardData(
            "Image 4",
            R.drawable.image4,
        ),
        CardData(
            "Image 5",
            R.drawable.image5,
        ),
        CardData(
            "Image 6",
            R.drawable.image6,
        ),
        CardData(
            "Image 7",
            R.drawable.image7,
        ),
        CardData(
            "Image 8",
            R.drawable.image8,
        ),
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemCard(cardData: CardData, navController: NavHostController) {
    Card(shape= RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                navController.navigate("Foto/${cardData.name}")
            },
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            Column(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = cardData.photo),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                color = Color(0, 0, 0, 128) // Fondo negro transparente
            ) {
                Text(textDecoration = TextDecoration.Underline,
                    text = cardData.name,
                    fontSize = 20.sp, //
                    color = Color.White, //
                    modifier = Modifier.fillMaxSize().padding(vertical = 8.dp, horizontal = 20.dp),
                    textAlign = TextAlign.Start //
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MyTopAppBar() {
    TopAppBar(colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Purple80),
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
                    Text(text = "PlacesInTheWorld", color = Color.White)
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