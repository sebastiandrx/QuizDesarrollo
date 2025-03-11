fun main() {
    val gestion = Gestionar_Productos()

    while (true) {
        println("MENÚ DE GESTIÓN DE PRODUCTOS ")
        println("1. Agregar producto")
        println("2. Eliminar producto")
        println("3. Buscar producto")
        println("4. Mostrar todos los productos")
        println("5. Realizar venta")
        println("6. Reponer stock")
        println("7. Aplicar descuento")
        println("8. Aumentar precio")
        println("9. Salir")
        print("Seleccione una opción: ")


        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Ingrese código del producto: ")
                val codigo = readLine() ?: ""
                print("Ingrese nombre del producto: ")
                val nombre = readLine() ?: ""
                print("Ingrese precio del producto: ")
                val precio = readLine()?.toDoubleOrNull() ?: 0.0
                print("Ingrese cantidad en stock: ")
                val cantidad = readLine()?.toIntOrNull() ?: 0
                gestion.crearProducto(codigo, nombre, precio, cantidad)
            }
            2 -> {
                print("Ingrese código del producto a eliminar: ")
                val codigo = readLine() ?: ""
                gestion.eliminarProducto(codigo)
            }
            3 -> {
                print("Ingrese código del producto a buscar: ")
                val codigo = readLine() ?: ""
                val producto = gestion.buscarProducto(codigo)
                producto?.mostrarInfo() ?: println("Producto no encontrado")
            }
            4 -> gestion.mostrarTodosLosProductos()
            5 -> {
                print("Ingrese código del producto a vender: ")
                val codigo = readLine() ?: ""
                val producto = gestion.buscarProducto(codigo)
                if (producto != null) {
                    print("Ingrese cantidad a vender: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                    producto.realizarVenta(cantidad)
                } else println("Producto no encontrado")
            }
            6 -> {
                print("Ingrese código del producto a reponer: ")
                val codigo = readLine() ?: ""
                val producto = gestion.buscarProducto(codigo)
                if (producto != null) {
                    print("Ingrese cantidad a reponer: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                    producto.reponerStock(cantidad)
                } else println("Producto no encontrado")
            }
            7 -> {
                print("Ingrese código del producto para aplicar descuento: ")
                val codigo = readLine() ?: ""
                val producto = gestion.buscarProducto(codigo)
                if (producto != null) {
                    print("Ingrese porcentaje de descuento: ")
                    val porcentaje = readLine()?.toDoubleOrNull() ?: 2.0
                    producto.aplicarDescuento(porcentaje)
                } else println("Producto no encontrado")
            }
            8 -> {
                print("Ingrese código del producto para aumentar precio: ")
                val codigo = readLine() ?: ""
                val producto = gestion.buscarProducto(codigo)
                if (producto != null) {
                    print("Ingrese porcentaje de aumento: ")
                    val porcentaje = readLine()?.toDoubleOrNull() ?: 6.0
                    producto.aumentarPrecio(porcentaje)
                } else println("Producto no encontrado")
            }
            9 -> println("Saliendo del sistema...")
            else -> println("Opción inválida, intente nuevamente.")
        }
    }
}
