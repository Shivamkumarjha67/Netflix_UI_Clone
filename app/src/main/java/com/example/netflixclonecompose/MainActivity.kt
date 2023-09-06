package com.example.netflixclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppSection()
                NetflixContentOptions()
                FeaturedMovieSection()
                SectionType(MovieType = "Watch It Again")
                SectionType(MovieType = "Drama Movie")
                SectionType(MovieType = "Action Movie")
                SectionType(MovieType = "New Releases")
                SectionType(MovieType = "Watch It Again")
                SectionType(MovieType = "Drama Movie")
                SectionType(MovieType = "Action Movie")
                SectionType(MovieType = "New Releases")
            }
        }
    }
}

@Composable
fun TopAppSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.img_2), contentDescription = "icon", Modifier.size(60.dp))
        Row() {
            Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = "icon",
                Modifier
                    .padding(12.dp)
                    .size(32.dp))
            Image(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "icon",
                Modifier
                    .padding(6.dp)
                    .size(32.dp))
        }
    }
}

@Composable
fun NetflixContentOptions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 30.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) { 
        Text(text = "TV Show", color = Color.LightGray, fontSize = 20.sp)
        Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)
        Row() {
            Text(text = "Categories", color = Color.LightGray, fontSize = 20.sp)
            Image(painter = painterResource(id = R.drawable.ic_drop_down), contentDescription = "drop")
        }
    }
}

@Composable
fun FeaturedMovieSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "movie",
        modifier = Modifier.size(300.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 40.dp, end = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "Romance", color = Color.White)
            Text(text = "Adventure", color = Color.White)
            Text(text = "Thriller", color = Color.White)
            Text(text = "Drama", color = Color.White)
        }

        Row(
            Modifier
                .padding(top = 20.dp, start = 40.dp, end = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add")
                Text(text = "My List", color = Color.White)
            }
            
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "PLAY", color = Color.Black, fontSize = 20.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_info), contentDescription = "add")
                Text(text = "info", color = Color.White)
            }
        }
    }
}

@Composable
fun SectionType(MovieType : String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Text(text = MovieType,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.LightGray,
        modifier = Modifier.padding(top = 5.dp, start = 8.dp))
        
        LazyRow {
            itemsIndexed(getListOfMovies()) { index, item ->
                MovieItemUIModel(imageRes = item.image)
            }
        }
    }
}

fun getListOfMovies(): List<MovieItemModel> {
    val listOfMovies = mutableListOf<MovieItemModel>()

    listOfMovies.add(MovieItemModel(R.drawable.img_1))
    listOfMovies.add(MovieItemModel(R.drawable.img_3))
    listOfMovies.add(MovieItemModel(R.drawable.img_4))
    listOfMovies.add(MovieItemModel(R.drawable.img_5))
    listOfMovies.add(MovieItemModel(R.drawable.img_6))
    listOfMovies.add(MovieItemModel(R.drawable.img_7))
    listOfMovies.add(MovieItemModel(R.drawable.img_8))
    listOfMovies.add(MovieItemModel(R.drawable.img_9))

    listOfMovies.shuffle()

    return listOfMovies
}

@Composable
fun MovieItemUIModel(
    imageRes : Int
) {
    Image(painter = painterResource(id = imageRes),
        contentDescription = "",
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .background(Color.Black)
    )
}

data class MovieItemModel (
    val image : Int
)