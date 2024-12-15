package TransportCompany.Management

import TransportCompany.DataStructure.*

class TransportCompany() {
    var routeList: MutableList<Route> = mutableListOf()
    var transportList: MutableList<Transport> = mutableListOf()
    var orderList: MutableList<Order> = mutableListOf()
    var mapTrasnsportOrder: MutableMap<Transport, Order> = mutableMapOf()

    fun isRouteValid(route: Route): Boolean {
        return routeList.contains(route)
    }

//    fun addTransport(transport: Transport) {
//        if (transportList.contains(transport)) {
//            throw IllegalStateException("Транспорт уже был добавлен")
//        }
//        transportList.add(transport)
//    }

    fun addTransport(vararg transports: Transport) {
        transports.forEach { transport ->
            if (transportList.contains(transport)) {
                throw IllegalStateException("Транспорт уже был добавлен")
            }
            transportList.add(transport)
        }
    }

    fun addRoute(route: Route) {
        if (routeList.contains(route)) {
            throw IllegalStateException("Маршрут уже был добавлен")
        }
        routeList.add(route)
    }

    fun addOrder(order: Order) {
        if (orderList.contains(order)) {
            throw IllegalStateException("Заказ уже был добавлен")
        }
        orderList.add(order)
    }

    fun addTransportToOrder(transport: Transport, order: Order): MutableMap<Transport, Order> {
        if (mapTrasnsportOrder.contains(transport)) {
            throw IllegalStateException("К транспорту уже прикреплен заказ.Выберите другой транспорт")
        }
        mapTrasnsportOrder[transport] = order
        return mapTrasnsportOrder
    }

    // Функция высшего порядка для фильтрации заказов
    fun filterOrders(orders: MutableList<Order>, criteria: (Order) -> Boolean): List<Order> {
        return orders.filter(criteria)
    }

    fun clearTransportState(transport: Transport): Boolean {
        when (transport) {
            is Track -> transport.currentWeight = 0
            is Bus -> transport.currentPassengersAmount = 0
            else -> false
        }
        return true
    }
}


