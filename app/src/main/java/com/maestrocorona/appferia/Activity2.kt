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

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen(onBackPressed = { finish() })
        }
    }
}
@Composable
fun SecondScreen(onBackPressed: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Texto
            Text(
                text = "\n\uD83C\uDF33NAVE 1 GUAYACÁN\n\n" +
                        "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"\n" +
                        "\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n" +
                        "________________________________________\n" +
                        "What is Lorem Ipsum?\n" +
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                modifier = Modifier.padding(horizontal = 8.dp),
                textAlign = TextAlign.Justify
            )
        // Imagen en la parte superior
            Image(
                painter = painterResource(id = R.drawable.logo_nave1),
                contentDescription = "Imagen representativa",
                modifier = Modifier.size(300.dp)
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
fun PreviewSecondScreen() {
    SecondScreen(onBackPressed = {})
}



