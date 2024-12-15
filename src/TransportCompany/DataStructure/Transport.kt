package TransportCompany.DataStructure

// Абстрактный класс (или sealed class) для всех видов транспорта.
//Поля: название, номер транспорта.
//Метод: вывод информации о транспорте.

abstract class Transport {
    abstract val name: String
    abstract val transportNumber: String

    open fun printTransportInfo() = "$name $transportNumber"
}