package com.dennis.myapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dennis.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    PoolImage(name="james",message = " lets hike")
                }
            }
        }
    }
}
@Composable
fun PoolImage(name: String,message:String){
    Card( border = BorderStroke(2.dp,Color.White),modifier = Modifier.padding(3.dp)) {

        val imageModifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Color.Yellow)

        Image(painter= painterResource(id = R.drawable.photo),contentDescription = "Image")
        Image(painter= painterResource(id = R.drawable.photo2),contentDescription = "Image",contentScale = ContentScale.Crop,modifier = Modifier.size(100.dp).clip(
            CircleShape))

        pool(name=name, message=message)
    }


}



@Composable
fun pool(name: String, message: String) {
    Row(modifier = Modifier
        .background(Color.Transparent)
        .padding(16.dp)
    ){
        Text(text = name,fontFamily = FontFamily.SansSerif, fontSize = 36.sp)
        Text(text = message, fontSize = 36.sp)

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        PoolImage(name="james",message = " lets hike")
    }
}