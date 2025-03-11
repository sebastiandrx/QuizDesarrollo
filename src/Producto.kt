open class Producto(
    val codigoProducto : String,
    var nombre : String,
    var precioProducto: Double,
    var cantidadS :Int
){
    open fun mostrarInfo(){
        println("Codigo: $codigoProducto")
        println("Nombre: $nombre")
        println("Precio: $${String.format("%.2f", precioProducto)}")
        println("Cantidad Disponible: $cantidadS")
    }
    open fun realizarVenta(cantidad: Int): Boolean{
    if (cantidad <= 0){
        println("La cantidad a vender debe ser mayor a cero")
        return false
    }
    if (cantidadS >= cantidad){
        cantidadS -= cantidad
        println("Venta realizada: $cantidad unidades de $nombre")
        return true
    }else {
        println("Stock insuficiente. Solo hay disponible $cantidadS unidades")
        return false
    }

    }
    open fun reponerStock(cantidad: Int){
        if (cantidad <= 0){
            println("La cantidad debe ser mayor que cero")
            return
        }
        cantidadS += cantidad
        println("Stock actualizado: Se añadieron $cantidad unidades de $nombre")
    }
    open fun aplicarDescuento(Porcentaje: Double = 2.0){
        if (Porcentaje <= 0 || Porcentaje >= 100){
            println("El porcentaje de descuento deber estar entre 0 y 100")
            return
        }
    val descuento = precioProducto * (Porcentaje / 100)
        precioProducto -= descuento
        println("Descuento aplicado: $Porcentaje%. Precio nuevo de: $${String.format("%.2f", precioProducto)}")
    }

    open fun aumentarPrecio(Porcentaje: Double = 6.0){
        if (Porcentaje <= 0 ){
            println("El porcentaje de aumento debe ser mayor que cero")
            return
        }
    val aumento = precioProducto * (Porcentaje / 100 )
        precioProducto += aumento
        println("Aumento aplicado: $Porcentaje%. Precio nuevo de: $${String.format("%2.f", precioProducto)}")
    }
    open fun calcularValorTotal(): Double{
        return precioProducto * cantidadS
    }
}