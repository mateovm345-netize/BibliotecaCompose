
package com.sena.bibliotecacompose.ui.screen

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.bibliotecacompose.DatosBiblioteca
import com.sena.bibliotecacompose.Libro
import com.sena.bibliotecacompose.R
import com.sena.bibliotecacompose.ui.composable.EstadoDisponibilidad
import com.sena.bibliotecacompose.ui.section.EncabezadoCatalogo

@Composable
fun CatalogoScreen(onVerDetalle: (Libro) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        EncabezadoCatalogo()

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(DatosBiblioteca.libros) { libro ->

                val portada = when (libro.titulo) {
                    "Clean Code" -> R.drawable.clean_code
                    "Kotlin para Android" -> R.drawable.kotlin_android
                    "Arquitectura de Software" -> R.drawable.arquitectura
                    "Jetpack Compose" -> R.drawable.jetpack_compose
                    else -> R.drawable.clean_code
                }

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

                        Image(
                            painter = painterResource(id = portada),
                            contentDescription = "Portada de ${libro.titulo}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(190.dp),
                            contentScale = ContentScale.Fit
                        )

                        Spacer(modifier = Modifier.height(12.dp))

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

                            EstadoDisponibilidad(
                                disponible = libro.disponible
                            )

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
