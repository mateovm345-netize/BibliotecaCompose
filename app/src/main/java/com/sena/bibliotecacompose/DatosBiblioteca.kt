package com.sena.bibliotecacompose

object DatosBiblioteca {

    val libros = listOf(
        Libro(
            id = 1,
            titulo = "Clean Code",
            autor = "Robert C. Martin",
            categoria = "Programación",
            disponible = true,
            descripcion = "Buenas prácticas para escribir código limpio y fácil de mantener."
        ),
        Libro(
            id = 2,
            titulo = "Kotlin para Android",
            autor = "Antonio Leiva",
            categoria = "Desarrollo móvil",
            disponible = true,
            descripcion = "Aprende Kotlin y sus herramientas para desarrollar aplicaciones Android."
        ),
        Libro(
            id = 3,
            titulo = "Arquitectura de Software",
            autor = "Len Bass",
            categoria = "Ingeniería de software",
            disponible = false,
            descripcion = "Principios para diseñar y comprender sistemas de software."
        ),
        Libro(
            id = 4,
            titulo = "Jetpack Compose",
            autor = "Manuel Vivo",
            categoria = "Desarrollo móvil",
            disponible = true,
            descripcion = "Aprende a crear interfaces modernas con Jetpack Compose."
        )
    )
}
