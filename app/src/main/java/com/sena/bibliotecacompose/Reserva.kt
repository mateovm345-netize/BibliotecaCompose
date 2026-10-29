package com.sena.bibliotecacompose

data class Reserva(
    val id: Int,
    val libro: Libro,
    val fecha: String,
    val activa: Boolean = true
)

object DatosReservas {
    val reservas = mutableListOf<Reserva>()

    private var siguienteId = 1

    fun reservarLibro(libro: Libro): Boolean {
        if (!libro.disponible) return false

        val yaReservado = reservas.any {
            it.libro.id == libro.id && it.activa
        }

        if (yaReservado) return false

        reservas.add(
            Reserva(
                id = siguienteId++,
                libro = libro,
                fecha = "29/10/2026"
            )
        )

        return true
    }

    fun cancelarReserva(id: Int) {
        val indice = reservas.indexOfFirst { it.id == id }

        if (indice != -1) {
            reservas[indice] = reservas[indice].copy(activa = false)
        }
    }

    fun obtenerReservasActivas(): List<Reserva> {
        return reservas.filter { it.activa }
    }
}