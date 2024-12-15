package TransportCompany

import TransportCompany.DataStructure.*
import TransportCompany.Management.TransportCompany

fun main() {
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val blue = "\u001B[34m"
    val reset = "\u001B[0m"

    //создание транспорта для автопарка
    val track1 = Track("Грузовик Volvo", "Л001ЛД", 10)
    val track2 = Track("Грузовик Mercedes", "Т356ДЖД", 30)
    val bus1 = Bus("Автобус Mercedes", "Г001ЛД", 40)
    val bus2 = Bus("Автобус SOLARIS", "Г888ТИ", 12)
    val bus3 = Bus("Автобус SOLARIS", "Г228ТИ", 25)

    //создание маршрутов для автопарка
    val routeForCargo = Route("1", mutableListOf(BusStops.Нарва, BusStops.Мурманск), RouteStatus.PLANNED)
    val routeForPassengers1 = Route("2", mutableListOf(BusStops.Зеленогорск, BusStops.Мурманск), RouteStatus.PLANNED)
    val routeForPassengers2 = Route("3", mutableListOf(BusStops.Мурманск, BusStops.Нарва), RouteStatus.PLANNED)

    //создание транспорной компанию, добавили туда наш транспорт
    val transportCompanySpb = TransportCompany()
    TransportCompanyHolder.transportCompanySpb = transportCompanySpb

    transportCompanySpb.addTransport(track1)
    transportCompanySpb.addTransport(track2)
    transportCompanySpb.addTransport(bus1)
    transportCompanySpb.addTransport(bus2)
    transportCompanySpb.addTransport(bus3)

// вариант инициализации транспортной компании через apply
//    val transportCompanySpb = TransportCompany().apply {
//        TransportCompanyHolder.transportCompanySpb = this
//        addTransport(
//            Track("Грузовик Volvo", "Л001ЛД", 10),
//            Track("Грузовик Mercedes", "Т356ДЖД", 30),
//            Bus("Автобус Mercedes", "Г001ЛД", 40),
//            Bus("Автобус SOLARIS", "Г888ТИ", 12),
//            Bus("Автобус SOLARIS", "Г228ТИ", 25)
//        )
//    }

    // добавили маршруты, по которым ездит транспорт в компании
    transportCompanySpb.addRoute(routeForCargo)
    transportCompanySpb.addRoute(routeForPassengers1)
    transportCompanySpb.addRoute(routeForPassengers2)

    //

    //получили первые заказы на перевозку
    val order1 = Order.CargoOrder("101", "Доставка 5 тонн груза", routeForCargo)
    val order2 = Order.CargoOrder("111", "Доставка 15 тонн груза", routeForCargo)
    val order3 = Order.PassengerOrder("102", "Перевозка 10 пассажиров", routeForPassengers1)
    val order4 = Order.PassengerOrder("104", "Перевозка 23 пассажиров", routeForPassengers2)

    //добавить каждый заказ в список
    transportCompanySpb.addOrder(order1)
    transportCompanySpb.addOrder(order2)
    transportCompanySpb.addOrder(order3)
    transportCompanySpb.addOrder(order4)

    //вывод информации о текущих маршрутах
    println("Маршруты:")
    for (i in transportCompanySpb.routeList) {
        println("${blue}${i.showRoute()}${reset}")
    }

    //загрузка груза и посадка пассажиров
    track1.loadWeight(2, track1)
    bus1.addPassenger(111)
    bus2.addPassenger(2)
    bus3.addPassenger(30)

    //нужно выбрать, какой транспорт поедет по заказу - привязка транспорта к заказу
    transportCompanySpb.addTransportToOrder(track1, order1)
    transportCompanySpb.addTransportToOrder(track2, order2)

    //вывод информации о текущем транспорте
    println("Транспорт:")
    for (i in transportCompanySpb.transportList) {
        println("${yellow}${i.printTransportInfo()} — ${transportCompanySpb.mapTrasnsportOrder[track1]}.${reset}")
    }

    //вывод информации обо всех заказах
    println("Заказы:")
    for (i in transportCompanySpb.orderList) {
        println("${green}${i.showOrderInfo()} на ${i.route}${reset}")
    }

    val filteredOrders = transportCompanySpb.filterOrders(transportCompanySpb.orderList) { it.route == routeForCargo }
    println("Заказы только по грузу:")
    filteredOrders.forEach {
        println("${blue}${it.id}: ${it.description} на ${it.route}${reset}")
    }

    println("Текущий вес: ${track1.currentWeight}")
    transportCompanySpb.clearTransportState(track1)
    println("Текущий вес: ${track1.currentWeight}")
}
