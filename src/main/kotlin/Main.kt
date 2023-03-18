// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {

    var board by remember { mutableStateOf("") }
    val space = 5.dp
    val operationColor = Color.Gray

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column (
                modifier = Modifier.background(Color.DarkGray, shape = RoundedCornerShape(10.dp)).padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Box{
                    OutlinedTextField (
                        value = board,
                        onValueChange = {},
                        placeholder = { Text("0", color = Color.Gray) },
                        modifier = Modifier.background(color = Color.LightGray, shape = RoundedCornerShape(space))
                    )


                }

                Spacer(Modifier.height(space))

                Row {
                    Button(onClick = {
                               board += "1"
                    },){
                        Text("1")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "2"
                    },){
                        Text("2")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "3"
                    }){
                        Text("3")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "/"
                    },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("/")
                    }
                }

                Row {
                    Button(onClick = {
                        board += "4"
                    }){
                        Text("4")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "5"
                    }){
                        Text("5")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "6"
                    }){
                        Text("6")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "*"
                    },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("*")
                    }
                }

                Row {
                    Button(onClick = {
                        board += "7"
                    }){
                        Text("7")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "8"
                    }){
                        Text("8")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "9"
                    }){
                        Text("9")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "+"
                    },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = operationColor,
                            contentColor = Color.White)){
                        Text("+")
                    }
                }

                Row {
                    Button(
                        onClick = {
                            board += "."
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray,
                            contentColor = Color.White)){
                        Text(".")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "0"
                    },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray,
                            contentColor = Color.White)){
                        Text("0")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                              board = DoubleCalculator.evaluate(board).toString()
                    },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray,
                            contentColor = Color.White)){
                        Text("=")
                    }

                    Spacer(Modifier.width(space))

                    Button(onClick = {
                        board += "-"
                    },
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
