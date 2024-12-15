package TransportCompany.DataStructure

//Truck (наследуется от Transport)
//Поля: максимальный вес груза, текущий вес груза.
//Метод: загрузить груз (увеличивает текущий вес, но не может превышать максимум).

data class Track(
    override val name: String,
    override val transportNumber: String,
    val maxWeightInTons: Int
) : Transport() {

    var currentWeight = 0

    fun loadWeight(weight: Int, track: Track): String {
        if (currentWeight + weight > maxWeightInTons) {
            throw IllegalStateException("Груз $weight т. не может быть загружено в ${track.name}, так как превышен максимальный вес в $maxWeightInTons тонн.")
        }
        currentWeight += weight
        return ("Груз $weight т. успешно загружено в ${track.name}. Текущий вес: $currentWeight тонн.")
    }

    override fun printTransportInfo() = "$name (макс. вес: $maxWeightInTons тонн)"
}