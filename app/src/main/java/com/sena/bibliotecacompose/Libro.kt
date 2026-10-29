package com.sena.bibliotecacompose

data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val disponible: Boolean,
    val descripcion: String
)