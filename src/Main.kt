// La clase base llamada Food con propiedades name y price con la funcion abstracta llamada cook tal como solicita inciso 1
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Inciso 2. Subclase de food para hamburguesas que hace override a cook
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Asar la hamburguesa $name a la parrilla hasta que esté bien cocida por dentro y dorada por fuera."
    }
}

// Subclase de food para pizzas que hace override a cook
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Hornear la pizza $name en un horno precalentado a 220°C durante 12-15 minutos hasta que el queso esté burbujeante y la corteza dorada."
    }
}

class Pasta(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Cocinar la pasta."
    }
}

// Inciso 3. Interfaz llamada Dessert con función eat
interface Dessert {
    fun eat(): String
}

// Inciso 4. Subclase de food que implementa dessert, hace override de cook y eat
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfríar la mezcla de helado de $name en una máquina de helados hasta que esté suave y cremosa."
    }

    override fun eat(): String {
        return "Disfruta el helado de $name con tu cuchara y una sonrisa, tal vez incluso unos acompañamientos como maní o dulces."
    }
}

// Inciso 5. Clase abstracta llamada Drink que estiende la clase food y tiene la funcion pour
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Inciso 6. Subclase de drink llamada Juice que implementa la funcion pour y hace override a cook
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun pour(): String {
        return "Verter el jugo de $name en un vaso, asegurándote de mezclar bien antes de servir."
    }

    override fun cook(): String {
        return "Exprimir las frutas frescas para obtener el jugo de $name."
    }
}

// Inciso 7. Extension function de food para el porcentaje de descuento
fun Food.discountedPrice(discountPercentage: Double): Double {
    return price * (1 - discountPercentage / 100)
}

// Incisos 8 a 10. Las instancias de cada food, cook por artículo, icecream con eat, y la de burger con el discounted price
fun main() {
    // Los precios y nombres solo son ejemplos cualquier cosa se pueden cambiar (eso no los hace var, siguen siendo vals)
    val burger = Burger("Cheeseburger", 5.99)
    val pizza = Pizza("Margarita", 8.99)
    val iceCream = IceCream("Chocolate", 3.99)
    val juice = Juice("Arándano", 2.99)
    val pasta = Pasta("Alfredo", 6.99)

    // I8
    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())
    println(pasta.cook())
    println("")

    // I9
    println(iceCream.eat())
    println("")

    // I10
    println("El precio con descuento de la hamburguesa es: ${burger.discountedPrice(10.0)}")
    println("El precio con descuento de la pasta es: ${pasta.discountedPrice(40.0)}")
}