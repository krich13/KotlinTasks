**Задача: "Управление транспортной компанией"**

Описание:
Транспортная компания занимается перевозкой грузов и пассажиров. Необходимо создать систему управления, которая позволяет отслеживать транспорт, маршруты и заказы.

Требования
Классы и структуры данных
Transport
 Абстрактный класс (или sealed class) для всех видов транспорта.
Поля: название, номер транспорта.
Метод: вывод информации о транспорте.
Truck (наследуется от Transport)
Поля: максимальный вес груза, текущий вес груза.
Метод: загрузить груз (увеличивает текущий вес, но не может превышать максимум).
Bus (наследуется от Transport)


Поля: максимальное количество пассажиров, текущее количество пассажиров.
Метод: добавить пассажиров (не может превышать максимум).
Route


Поля: идентификатор маршрута, список остановок.
Метод: добавить остановку, удалить остановку, вывести весь маршрут.
Order


Поля: идентификатор заказа, тип заказа (Cargo или Passenger), описание заказа.
Метод: вывести информацию о заказе.

Система управления
TransportCompany
Поля: список транспорта, список маршрутов, список заказов.
Методы:
Добавить транспорт.
Назначить маршрут транспорту.
Привязать заказ к транспорту.
Вывести текущую информацию о всех заказах.
Использовать mutableMapOf для связи транспорта с маршрутами и заказами.

Принципы проектирования
Использовать композицию, чтобы Route мог содержать список объектов остановок (data class Stop(val name: String, val location: String)).
Для типа заказа использовать sealed class OrderType, с подтипами Cargo (груз) и Passenger (пассажиры).
Задать фиксированные статусы маршрута через enum

Работа с системой Создать тестовые данные:
Транспорт: 2 грузовика и 3 автобуса.
Маршруты: 3 маршрута (например, для грузов и для пассажиров).
Заказы: 4 заказа (2 груза и 2 для пассажиров).

 Продемонстрировать:
Назначение маршрутов.
Загрузку груза и посадку пассажиров.
Вывод информации о текущих заказах, маршрутах и транспорте.

Пример вывода программы:
Транспорт:  
1. Грузовик Volvo (макс. вес: 10 тонн) — Маршрут №1, заказ №101.  
2. Автобус Mercedes (макс. пассажиров: 40) — Маршрут №2, заказ №102.  

Маршруты:  
Маршрут №1 (статус: IN_PROGRESS): Остановка1 -> Остановка2 -> Остановка3.  
Маршрут №2 (статус: PLANNED): Остановка4 -> Остановка5.  

Заказы:  
1. Заказ №101 (Cargo): Доставка 5 тонн груза на Остановка2.  
2. Заказ №102 (Passenger): Перевозка 30 пассажиров на Остановка5.  


Дополнительно:
1) В классе TransportCompany добавить метод filterOrders, который принимает лямбда-выражение и возвращает список заказов, соответствующих критериям.
2) Добавить в TransportCompany метод clearTransportState, который обновляет состояние транспорта (например, сбрасывает в ноль кол-во пассажиров, текущий груз и т.п.) в зависимости от его типа. Обновить нужно состояния всех текущих единиц транспорта. Использовать when с проверкой типа и присваиванием значений.
