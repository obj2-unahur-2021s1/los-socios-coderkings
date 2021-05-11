package ar.edu.unahur.obj2.socios

import kotlin.math.min

abstract class Emocion {
    abstract fun calcularPropina(cliente: Cliente, importeIngresado: Int): Int
}

object Enojado : Emocion() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = 0
}
object  Feliz : Emocion() {
    override fun calcularPropina(cliente : Cliente, importeIngresado: Int) = importeIngresado / 4
}

object Indifirente : Emocion() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = cliente.bolsillo
}

object  Resfiado : Emocion() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = importeIngresado
}

abstract class Barrio {
    abstract fun calcularPropina(cliente: Cliente, importeIngresado: Int): Int
}

object LasRosas : Barrio() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = cliente.cuantaPropinaDariaSegunMiEstado(importeIngresado) + 50

}

object LasLauchas : Barrio() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = cliente.cuantaPropinaDariaSegunMiEstado(importeIngresado) / 2
}

object BarrioVerde : Barrio() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = min(cliente.cuantaPropinaDariaSegunMiEstado(importeIngresado), 200)
}

object LasTorres : Barrio() {
    override fun calcularPropina(cliente: Cliente, importeIngresado: Int) = cliente.cuantaPropinaDariaSegunMiEstado(importeIngresado)
}

class Cliente(var estado: Emocion, var bolsillo: Int, var vive: Barrio) {
    fun cuantaPropinaDariaSegunMiEstado(importeIngresado: Int) = estado.calcularPropina(this, importeIngresado)

    fun cuantaPropinaDariaSegunMiBarrio(importeIngresado: Int) = vive.calcularPropina(this, importeIngresado)
}







