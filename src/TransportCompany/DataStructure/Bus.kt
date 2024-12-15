package TransportCompany.DataStructure

//Bus (наследуется от Transport)
//Поля: максимальное количество пассажиров, текущее количество пассажиров.
//Метод: добавить пассажиров (не может превышать максимум).

data class Bus(
    override val name: String,
    override val transportNumber: String,
    val maxPassengersAmount: Int,
) : Transport() {

    var currentPassengersAmount: Int = 0

    fun addPassenger(passengerAmount: Int) : String {
        if (currentPassengersAmount > maxPassengersAmount) {
            throw IllegalStateException("Превышено количество пассажиров. Максимум: $maxPassengersAmount человек, сейчас $currentPassengersAmount человек")
        }
        currentPassengersAmount += passengerAmount
        return ("Пассажиры успешно добавлены. Текущее количество: $currentPassengersAmount человек")
    }

    override fun printTransportInfo() = ("$name (макс. вес: $maxPassengersAmount)")
}
