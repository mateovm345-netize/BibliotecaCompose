package com.sena.bibliotecacompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.bibliotecacompose.DatosBiblioteca
import com.sena.bibliotecacompose.Libro

@Composable
fun CatalogoScreen(onVerDetalle: (Libro) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Catálogo de libros",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF174A7E)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Explora los libros disponibles en nuestra biblioteca.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(DatosBiblioteca.libros) { libro ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = libro.titulo,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF174A7E)
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(text = "Autor: ${libro.autor}")

                        Text(
                            text = "Categoría: ${libro.categoria}",
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = if (libro.disponible)
                                    Color(0xFFE0F2E5)
                                else
                                    Color(0xFFFFE4E4)
                            ) {
                                Text(
                                    text = if (libro.disponible)
                                        "Disponible"
                                    else
                                        "Prestado",
                                    modifier = Modifier.padding(
                                        horizontal = 12.dp,
                                        vertical = 6.dp
                                    ),
                                    color = if (libro.disponible)
                                        Color(0xFF18753A)
                                    else
                                        Color(0xFFB42318),
                                    fontWeight = FontWeight.Medium
                                )
                            }

                            Button(
                                onClick = { onVerDetalle(libro) },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text("Ver detalles")
                            }
                        }
                    }
                }
            }
        }
    }
}
