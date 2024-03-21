package com.example.ej1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ej1.ui.theme.EJ1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EJ1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Ej1()
                }
            }
        }
    }
}

@Preview
@Composable
fun Ej1(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    )  {
        val (boxCyan, boxRed, boxLime, boxMagenta) = createRefs()

        Box(modifier = Modifier
            .fillMaxHeight(0.333f)
            .fillMaxWidth()
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(boxRed.top)
            }
        ){
            Text(text = "Ejemplo 1",
                modifier = Modifier.align(Alignment.Center))
        }

        Box(modifier = Modifier
            .fillMaxHeight(0.333f)
            .fillMaxWidth(0.5f)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxCyan.bottom)
                start.linkTo(parent.start)
                end.linkTo(boxLime.start)
                bottom.linkTo(boxMagenta.top)
            }
        ){
            Text(text = "Ejemplo 2",
                modifier = Modifier.align(Alignment.Center))
        }

        Box(modifier = Modifier
            .fillMaxHeight(0.333f)
            .fillMaxWidth(0.5f)
            .background(Color.Green)
            .constrainAs(boxLime) {
                top.linkTo(boxCyan.bottom)
                start.linkTo(boxRed.end)
                end.linkTo(parent.end)
                bottom.linkTo(boxMagenta.top)
            }
        ){
            Text(text = "Ejemplo 3",
                modifier = Modifier.align(Alignment.Center))
        }

        Box(modifier = Modifier
            .fillMaxHeight(0.333f)
            .fillMaxWidth()
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxRed.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        ){
            Text(text = "Ejemplo 4",
                modifier = Modifier.align(Alignment.Center))
        }
    }
}
