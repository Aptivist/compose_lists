package com.aptivist.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aptivist.compose.ui.theme.ComposeTheme
import com.aptivist.compose.ui.theme.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewmodel : MainViewModel = hiltViewModel()
            val animalList = viewmodel.animalListState
            ComposeTheme {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(modifier = Modifier.fillMaxWidth(), text = getString(R.string.animals_title), textAlign = TextAlign.Center, fontSize = 32.sp)

                    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(12.dp) ,content = {
                        items(animalList) { item ->
                            AnimalCard(name = item.name, id = item.id, type = item.animal_type, image = item.image_link)
                        }
                    })
                }

            }
        }
    }
}

@Composable
fun AnimalCard(name: String, id: Int, type: String, image: String) {
    Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text(modifier = Modifier.fillMaxWidth(), text = name, textAlign = TextAlign.Center)
            Text(modifier = Modifier.fillMaxWidth().background(if(id > 100) Color.Red else Color.Green), text = id.toString())
            Text(modifier = Modifier.fillMaxWidth(), text = type)
            AsyncImage(modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .requiredHeight(64.dp),model = ImageRequest.Builder(LocalContext.current).data(image).crossfade(true).build(), contentDescription = "", contentScale = ContentScale.Crop)
        }
    }
}