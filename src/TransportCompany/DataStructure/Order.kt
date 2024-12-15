package TransportCompany.DataStructure

import TransportCompany.Management.TransportCompany

sealed class Order(
    val id: String,
    val description: String,
    val route: Route,
) {
    init {
        if (!TransportCompanyHolder.transportCompanySpb.isRouteValid(route)) {
            throw IllegalArgumentException("Маршрут не зарегистрирован в компании")
        }
    }

    override fun toString(): String {
        return "Маршрут№${route.routeId}, заказ №$id"
    }

    class CargoOrder(
        id: String, description: String, route: Route,
    ) : Order(id, description, route) {

        override fun showOrderInfo() = "Заказ №${this.id}(Cargo): ${this.description}"
    }

    class PassengerOrder(
        id: String,
        description: String, route: Route,
    ) : Order(id, description, route) {

        override fun showOrderInfo() = "Заказ №${this.id}(Passenger): ${this.description}"
    }

    open fun showOrderInfo() = "Заказ №${this.id}: ${this.description}"
}

object TransportCompanyHolder {
    lateinit var transportCompanySpb: TransportCompany
}


