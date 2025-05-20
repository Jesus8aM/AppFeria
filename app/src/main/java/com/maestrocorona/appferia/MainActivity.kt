package com.maestrocorona.appferia

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrocorona.appferia.Activity2
import com.maestrocorona.appferia.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MainScreen(onNavigateToSecondActivity = {
                    startActivity(Intent(this, Activity2::class.java))
                })
            }
        }
    }
}

// Definimos los esquemas de colores
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6650A4),   // Color primario en modo claro
    background = Color(0xFFFFFFFF), // Fondo en modo claro
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,        // Color del texto en botones primarios
    onBackground = Color.Black      // Color del texto en fondo claro
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD0BCFF),   // Color primario en modo oscuro
    background = Color(0xFF121212), // Fondo en modo oscuro
    surface = Color(0xFF121212),
    onPrimary = Color.Black,        // Color del texto en botones primarios
    onBackground = Color.White      // Color del texto en fondo oscuro
)

// Función para aplicar el tema según el modo del sistema
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme

    // Definimos la tipografía con SansSerif
    val typography = Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.SansSerif
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily.SansSerif
        ),
        bodySmall = TextStyle(
            fontFamily = FontFamily.SansSerif
        )
    )

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}

// UI PRINCIPAL
@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
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
            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y Concierto")

            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Fechas importantes", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

// Tarjeta de negocio con colores dinámicos
@Composable
fun BusinessItem(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// PREVIEW para visualizar MainScreen
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewMainScreen() {
    AppTheme {
        MainScreen(onNavigateToSecondActivity = {})
    }
}

// PREVIEW para visualizar BusinessItem
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBusinessItem() {
    AppTheme {

    }
}
