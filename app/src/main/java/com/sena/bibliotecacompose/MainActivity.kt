

package com.sena.bibliotecacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.ui.screen.CatalogoScreen
import com.sena.bibliotecacompose.ui.screen.DetalleLibroScreen
import com.sena.bibliotecacompose.ui.screen.ReservasScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                BibliotecaApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BibliotecaApp() {
    var libroSeleccionado by remember { mutableStateOf<Libro?>(null) }
    var mostrarReservas by remember { mutableStateOf(false) }
    var mensaje by remember { mutableStateOf("") }
    var actualizarReservas by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mi Biblioteca",
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    TextButton(
                        onClick = {
                            libroSeleccionado = null
                            mostrarReservas = true
                            mensaje = ""
                        }
                    ) {
                        Text("Mis reservas")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3F6FA))
                .padding(padding)
        ) {
            if (mostrarReservas) {
                key(actualizarReservas) {
                    ReservasScreen(
                        reservas = DatosReservas.obtenerReservasActivas(),
                        onCancelarReserva = { id ->
                            DatosReservas.cancelarReserva(id)
                            actualizarReservas++
                            mensaje = "Reserva cancelada"
                        },
                        onVolver = {
                            mostrarReservas = false
                            libroSeleccionado = null
                            mensaje = ""
                        }
                    )
                }
            } else if (libroSeleccionado == null) {
                CatalogoScreen(
                    onVerDetalle = { libro ->
                        libroSeleccionado = libro
                        mensaje = ""
                    }
                )
            } else {
                DetalleLibroScreen(
                    libro = libroSeleccionado!!,
                    onVolver = {
                        libroSeleccionado = null
                        mensaje = ""
                    },
                    onReservar = {
                        val resultado =
                            DatosReservas.reservarLibro(libroSeleccionado!!)

                        mensaje = if (resultado) {
                            actualizarReservas++
                            "¡Libro reservado correctamente!"
                        } else {
                            "Este libro no está disponible o ya está reservado."
                        }
                    }
                )

                if (mensaje.isNotBlank()) {
                    Text(
                        text = mensaje,
                        modifier = Modifier.padding(16.dp),
                        color = Color(0xFF174A7E),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
