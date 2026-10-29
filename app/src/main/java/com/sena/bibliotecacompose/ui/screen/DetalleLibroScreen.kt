
package com.sena.bibliotecacompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.Libro

@Composable
fun DetalleLibroScreen(
    libro: Libro,
    onVolver: () -> Unit,
    onReservar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F6FA))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "DETALLE DEL LIBRO",
                    color = Color(0xFF174A7E),
                    style = MaterialTheme.typography.labelLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = libro.titulo,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Autor: ${libro.autor}")
                Text(text = "Categoría: ${libro.categoria}")

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = libro.descripcion,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (libro.disponible) {
                        "Estado: Disponible"
                    } else {
                        "Estado: No disponible"
                    },
                    color = if (libro.disponible) {
                        Color(0xFF218838)
                    } else {
                        Color(0xFFC62828)
                    },
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onReservar,
                    enabled = libro.disponible,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF218838)
                    )
                ) {
                    Text("Reservar libro")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = onVolver,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF174A7E)
                    )
                ) {
                    Text("Volver al catálogo")
                }
            }
        }
    }
}
