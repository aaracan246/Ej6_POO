/*Ejercicio 4.6¶
Realizar el ejercicio 1 de Conjuntos de los "Ejercicios básicos con Kotlin" (Ejercicio 3.3.1) orientado a objetos.

Ejercicio 3.3.1¶
Suponer una lista con datos de las compras hechas por clientes de una empresa a lo largo de un mes, la cual contiene tuplas con información de cada venta: (cliente, día del mes, monto, domicilio del cliente). Ejemplo:

[("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"), ("Jorge Russo", 7, 699, "Mirasol 218"), ("Nuria Costa", 7, 532.90, "Calle Las Flores 355"), ("Julián Rodriguez", 12, 5715.99, "La Mancha 761"), ("Jorge Russo", 15, 958, "Mirasol 218")]
Escribir una función que reciba como parámetro una lista con el formato mencionado anteriormente y retorne los domicilios de cada cliente al cual se le debe enviar una factura de compra. Notar que cada cliente puede haber hecho más de una compra en el mes, por lo que la función debe retornar una estructura que contenga cada domicilio una sola vez.
 */

/*(-----------------------------------------------------------------------------)*/

/*
Te proporciono algunas pistas de una posible solución:

/**
* Clase Compra
* @param cliente cliente que realizo la compra
* @param dia dia de la compra
* @param monto monto de la compra
* @constructor Crea una compra con cliente, dia y monto
*/
/*
 * Clase Cliente
 * @param nombre nombre del cliente
 * @param domicilio domicilio del cliente
 * @constructor Crea un cliente con nombre y domicilio
 */
 ```
/** * Clase Domicilio * @param calle calle del domicilio * @param numero numero del domicilio * @constructor Crea un domicilio con calle y numero */ ```
La clase Domicilio tendrá un método llamado dirCompleta()que retornará el domicilio completo con la calle y el número.

Las clases Compra, Cliente y Domicilio se establecerán como data class, es decir, delante de class incluirán el modificador data en la declaración de dichas clases.

Para entender mejor que es una data class, visualizar el siguiente enlace: Data classes

/**
 * Clase RepositorioCompras
 * @constructor Crea un repositorio de compras
 */
La clase RepositorioCompras tendrá un método para agregar una compra al repositorio y un método domicilios para retornar los domicilios de cada cliente al cual se le debe enviar una factura de compra. Esta función retorna una estructura que contenga cada domicilio una sola vez.*/

data class Compra(var cliente: Cliente, var dia: Int, var monto: Double) // {} <- no hacen falta en data class

data class Domicilio(var calle: String, var numero: Int){
    fun dirCompleta(): String{
        return "La dirección de facturación es: $calle, $numero."
    }
}
data class Cliente(var nombre: String, var domicilio: Domicilio) //{} <- no hacen falta en data class
class RepositorioCompras(){
    private val compras: MutableList<Compra> = mutableListOf()
    fun addCompra(compra: Compra){
        compras.add(compra)
    }

    /**La clase RepositorioCompras() tendrá un método para agregar una compra al repositorio y un método domicilios() para retornar los domicilios de cada cliente al cual se le debe enviar una factura de compra. Esta función retorna una estructura que contenga cada domicilio una sola vez.
     * @return un set de un map.*/
    fun domicilios(): Set<String>{
        return compras.map { it.cliente.domicilio.dirCompleta() }.toSet()
    }
}
//("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"), ("Jorge Russo", 7, 699, "Mirasol 218"), ("Nuria Costa", 7, 532.90, "Calle Las Flores 355"), ("Julián Rodriguez", 12, 5715.99, "La Mancha 761"), ("Jorge Russo", 15, 958, "Mirasol 218")
fun main() {
    val repoCompras = RepositorioCompras()


    //Pasar las clases como parámetros para formar los distintos objetos:

    repoCompras.addCompra(Compra(Cliente("Nuria Costa", Domicilio("Calle las Flores", 355)), 5, 12780.78))
    repoCompras.addCompra(Compra(Cliente("Jorge Russo", Domicilio("Mirasol", 218)), 7, 699.0))
    repoCompras.addCompra(Compra(Cliente("Nuria Costa", Domicilio("Calle las Flores", 355)), 7, 532.90))
    repoCompras.addCompra(Compra(Cliente("Julian Rodríguez", Domicilio("La Mancha", 761)), 12, 5715.99))
    repoCompras.addCompra(Compra(Cliente("Jorge Riusso", Domicilio("Mirasol", 218)), 15, 958.0))

    val domiciliosNoRep = repoCompras.domicilios()

    domiciliosNoRep.forEach{ println(it) }

}