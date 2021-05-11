package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  describe("Un/a cliente que se calcula su propina segun su estado") {
    it ("Cliente Enojado. No da propina") {
      val cliente1 = Cliente(Enojado,14000, LasRosas)
      cliente1.cuantaPropinaDariaSegunMiEstado(4000).shouldBe(0)
//  Agregue los cambios de estado y la zona donde vive el cliente, para que vean que se puede hacer cambio
      cliente1.estado = Feliz
      cliente1.cuantaPropinaDariaSegunMiEstado(4000).shouldBe(1000)
      cliente1.vive = BarrioVerde
      cliente1.cuantaPropinaDariaSegunMiBarrio(4000).shouldBe(200)

    }
    it ("Cliente feliz, debe dar el 25% del precio de pedido que se ingreso") {
      val cliente2 = Cliente(Feliz,4000, LasLauchas)
      cliente2.cuantaPropinaDariaSegunMiEstado(10000).shouldBe(2500)
    }
    it ("Cliente indiferente, deja como propina lo que tenga en el bolsillo") {
      val cliente3 = Cliente(Indifirente, 8000, BarrioVerde)
      cliente3.cuantaPropinaDariaSegunMiEstado(4000).shouldBe(8000)
    }
    it ("Cliente resfriado, deja de propina el 100% de lo que salió el pedido.") {
      val cliente4 = Cliente(Resfiado, 3000, LasTorres)
      cliente4.cuantaPropinaDariaSegunMiEstado(300).shouldBe(300)
    }
  }
  describe("Un/a cliente que se calcula su propina segun su estado y su barrio donde vive") {
    it ("Cliente Enojado, y vive en las Rosas") {
      val cliente1 = Cliente(Enojado,14000, LasRosas)
      cliente1.cuantaPropinaDariaSegunMiBarrio(4000).shouldBe(50)
    }
    it ("Cliente feliz y vive en las lauchas") {
      val cliente2 = Cliente(Feliz,4000, LasLauchas)
      cliente2.cuantaPropinaDariaSegunMiBarrio(10000).shouldBe(1250)
    }
    it ("Cliente indiferente, vive en barrio verde") {
      val cliente3 = Cliente(Indifirente, 300, BarrioVerde)
      cliente3.cuantaPropinaDariaSegunMiBarrio(4000).shouldBe(200)
    }
    it ("Cliente resfriado, vive en LasTorres") {
      val cliente4 = Cliente(Resfiado, 3000, LasTorres)
      cliente4.cuantaPropinaDariaSegunMiBarrio(300).shouldBe(300)
    }
  }
})
