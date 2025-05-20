package com.maestrocorona.appferia


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Activity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FifthScreen(onBackPressed = { finish() })
        }
    }
}

@Composable
fun FifthScreen(onBackPressed: () -> Unit) {
    // Pantalla secundaria con lista de restaurantes
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            // Texto
            Text(
                text = "\n\uD83C\uDFA1ATRACCIÓN Y CONCIERTOS\n\n",
                modifier = Modifier.padding(horizontal = 8.dp),
                textAlign = TextAlign.Justify
            )
            // Imagen en la parte superior
            Image(
                painter = painterResource(id = R.drawable.conciertos),
                contentDescription = "Imagen representativa",
                modifier = Modifier.size(400.dp)
            )


            // Botón para volver
            Button(
                onClick = onBackPressed,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Regresar")
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewFifthScreen() {
    FifthScreen(onBackPressed = {})}