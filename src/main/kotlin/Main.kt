// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun App() {

    var board by remember { mutableStateOf("0") }
    val space = 5.dp
    val operationColor = Color.Gray

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {

                Text(
                    board,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                )

                Spacer(Modifier.height(space))

                Row {
                    Button(onClick = {
                               board = "1"
                    },){
                        Text("1")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},){
                        Text("2")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},){
                        Text("3")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("/")
                    }
                }

                Row {
                    Button(onClick = {},){
                        Text("4")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},){
                        Text("5")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},){
                        Text("6")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("*")
                    }
                }

                Row {
                    Button(onClick = {},){
                        Text("7")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},){
                        Text("8")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},){
                        Text("9")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("+")
                    }
                }

                Row {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray,
                            contentColor = Color.White)){
                        Text(".")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray,
                            contentColor = Color.White)){
                        Text("0")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray,
                            contentColor = Color.White)){
                        Text("=")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("-")
                    }
                }

            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
    title = "Compose Calculator") {
        App()
    }
}
