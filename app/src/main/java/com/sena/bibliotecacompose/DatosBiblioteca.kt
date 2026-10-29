
package com.sena.bibliotecacompose

object DatosBiblioteca {

    val libros = listOf(
        Libro(
            1,
            "Clean Code",
            "Robert C. Martin",
            "Programación",
            true,
            "Buenas prácticas para escribir código limpio y fácil de mantener."
        ),
        Libro(
            2,
            "Kotlin para Android",
            "Antonio Leiva",
            "Desarrollo móvil",
            true,
            "Aprende Kotlin y sus herramientas para desarrollar aplicaciones Android."
        ),
        Libro(
            3,
            "Arquitectura de Software",
            "Len Bass",
            "Ingeniería de software",
            false,
            "Principios para diseñar y comprender sistemas de software."
        ),
        Libro(
            4,
            "Jetpack Compose",
            "Manuel Vivo",
            "Desarrollo móvil",
            true,
            "Aprende a crear interfaces modernas con Jetpack Compose."
        )
    )
}
