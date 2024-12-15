package TransportCompany.DataStructure

//Поля: идентификатор маршрута, список остановок.
//Метод: добавить остановку, удалить остановку, вывести весь маршрут.

class Route(
    val routeId: String,
    var stopsList: MutableList<BusStops> = mutableListOf(),
    var status: RouteStatus = RouteStatus.PLANNED
) {

    override fun toString(): String {
        return "${stopsList.joinToString(" -> ")}."
    }

    fun addStop(newStop: String): Boolean {
        val stop = try {
            BusStops.valueOf(newStop)
        } catch (e: Exception) {
            throw IllegalArgumentException("Остановки $newStop не существует в списке возможных остановок")
        }
        if (stopsList.contains(stop)) {
            throw IllegalArgumentException("Остановка $stop уже существует в маршруте")
        }
        stopsList.add(stop)
        return true
    }

    fun deleteStop(stopToDelete: String) : Boolean {
        val stop = BusStops.valueOf(stopToDelete)
        if (stopsList.contains(stop)) {
            stopsList.remove(stop)
            return true
        }
        else {
            return false
        }
    }

    fun showRoute() = ("Маршрут №$routeId (статус: $status): ${stopsList.joinToString(" -> ")}.")
}
