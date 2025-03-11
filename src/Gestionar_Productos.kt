

class Gestionar_Productos: Producto ("Gestion", "Sistema de Gestion", 0.0,0) {
    private val listaProductos = mutableListOf<Producto>()

    override fun mostrarInfo() {
        println("GESTION DE PRODUCTOS")
        println("Total de productos $cantidadS")
        println("Valor total del inventario: $${String.format("%.2f", calcularValorTotalInventario())}")
    }

    fun crearProducto(codigo: String, nombre: String, precio: Double, cantidadStock: Int): Producto? {
        if (listaProductos.any { it.codigoProducto == codigo }) {
            println("Error: Ya existe un producto con el código $codigo")
            return null
        }

        val nuevoProducto = Producto(codigo, nombre, precio, cantidadStock)
        listaProductos.add(nuevoProducto)
        println("Producto creado exitosamente: ${nuevoProducto.nombre}")
        return nuevoProducto
    }

    fun eliminarProducto(codigo: String): Boolean {
        val producto = listaProductos.find { it.codigoProducto == codigo }
        if (producto != null) {
            listaProductos.remove(producto)
            println("Producto eliminado: ${producto.nombre}")
            return true
        }
        println("No se encontró un producto con el código $codigo")
        return false
    }

    fun buscarProducto(codigo: String): Producto? {
        return listaProductos.find { it.codigoProducto == codigo }
    }

    fun mostrarTodosLosProductos() {
        if (listaProductos.isEmpty()) {
            println("No hay productos registrados")
            return
        }

        println(" LISTA DE PRODUCTOS ")
        listaProductos.forEach {
            it.mostrarInfo()
            println("Valor total en inventario: $${String.format("%.2f", it.calcularValorTotal())}")
        }
    }
    fun calcularValorTotalInventario(): Double {
        return listaProductos.sumOf { it.calcularValorTotal() }
    }

    override fun calcularValorTotal(): Double {
        return calcularValorTotalInventario()
    }
}
