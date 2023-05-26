package utility

import entity.*
import exceptions.IsEmptyException
import exceptions.NotInLimitException
import exceptions.NotInTrueFormatException
import java.io.FileNotFoundException
import java.util.*

class BychaAsker(scan: Scanner, private var scriptMode: Boolean = false){

    private var scan: Scanner = scan
    private var id: Long = 1
    private var coordinates: Coordinates = Coordinates(0, 0)
    private var area: Int = 50
    private var numberOfRooms: Long = 0
    private var furnish: Furnish = Furnish.NONE
    private var view: View = View.NORMAL
    private var transport: Transport = Transport.NONE
    private var house: House = House("", 0, 1)
    private val minAreaCount = 0

    fun setScan(scan: Scanner) {
        this.scan = scan
    }

    fun getScan() : Scanner {
        return this.scan
    }

    fun setScriptNotInProgress() {
        this.scriptMode = false
    }

    fun setScriptInProgress() {
        this.scriptMode = true
    }

    fun askForFileName(): String{
        var fileName: String
        while(true){
            try {
                print("Введите название файла:\n>")
                fileName = scan.nextLine().trim()
                if(fileName == "") throw IsEmptyException()
                if(fileName.contains(Regex("[^a-z^A-Z0-9]"))) throw NotInTrueFormatException()
                fileName += ".json"
                break
            } catch (e: IsEmptyException) {
                println("Ошибка! Название не может быть пустым!")
            } catch (e: NotInTrueFormatException){
                println("Ошибка! Название должно содержать только буквы!")
            } catch (e: FileNotFoundException) {
                println("Ошибка! Файла с таким названием нету!")
            }
        }
        return fileName
    }

    fun askForCommandArguments(str1: String): String {
        if (str1 in listOf("add", "add_if_min", "update")) {
            return askNameOfFlat()+ " " + askArea() + " " + askCoordinates() + " " + askHouse() + " " + askFurnish() + " " + askView() + " " + askTransport() + " " + askNumberOfRooms()
        }
        if (str1 in listOf("remove_greater", "remove_lower")) {
            return askAreaCount().toString()
        }
        return ""
    }

    private fun askAreaCount(): Int{
        var areaStr: String
        var area: Int
        while (true) {
            try {
                if (!scriptMode) print("Введите площадь квартиры:\n>")
                areaStr = scan.nextLine().trim()
                if (areaStr == "") throw IsEmptyException()
                area = areaStr.toInt()
                if (area < minAreaCount) throw NotInLimitException()
                break
            } catch (e: IsEmptyException) {
                println("Ошибка! Количетво не может быть пустым!")
            } catch (e: NotInLimitException) {
                println("Ошибка! минимальное количество оскаров 1!")
            } catch (e: NumberFormatException) {
                println("Ошибка! Количество должно быть числом")
            }
        }
        return area
    }

    fun askYesOrNot(argument: String): Boolean {
        val question = "$argument (да/нет):\n>"
        var answer: String
        while (true) {
            try {
                print(question)
                answer = scan.nextLine().trim()
                if (answer != "да" && answer != "нет") throw NotInLimitException()
                break
            }catch (e: NotInLimitException) {
                println("Ошибка! Ответ должен быть либо да либо нет")
            }
        }
        return answer == "да"
    }

    fun askNameOfFlat(): String {
        var flatName: String
        while(true){
            try {
                if (!scriptMode) print("Введите название квартиры:\n>")
                flatName = scan.nextLine().trim()
                if(flatName == "") throw IsEmptyException()
                if(flatName.contains(Regex("[^a-z^A-Z]"))) throw NotInTrueFormatException()
                break
            } catch (e: IsEmptyException) {
                println("Ошибка! Название не может быть пустым!")
            } catch (e: NotInTrueFormatException){
                println("Ошибка! Название должно содержать только буквы!")
            }
        }
        return flatName
    }

    fun askCoordinates(): Coordinates {
        print("Выберите координаты: ")
        while (true) {
            print("введите координату x ")
            this.coordinates.setX(scan.nextLong())
            if (this.coordinates.getX() > 430) {
                println("Значение x вашей координаты не может быть больше 430!")
            } else break
        }
        while (true) {
            print("введите координату y ")
            this.coordinates.setY(scan.nextInt())
            if (this.coordinates.getY() == null) {
                println("Зачение y у координаты не может быть null!")
            } else break
        }
        return coordinates
    }

    fun askArea(): Int {
        while (true) {
            println("Введите площадь квартиры.")
            this.area = scan.nextInt()
            if (this.area > 556 || this.area <= 0) {
                println("Значение площади квартиры некорретно!")
            } else break
        }
        return this.area
    }

    fun askNumberOfRooms(): Long {
        while (true) {
            println("Укажите кол-во комнат.")
            this.numberOfRooms = scan.nextLong()
            if (this.numberOfRooms > 7 || this.numberOfRooms <= 0) {
                println("Значение кол-ва комнат квартиры некорректно!")
            } else break
        }
        return this.numberOfRooms
    }

    fun askHouse(): House {
        print("Выберите дом: ")
        println("введите название дома")
        this.house.setName(scan.next())
        while (true) {
            println("введите возраст дома")
            this.house.setYear((scan.nextInt()))
            if (this.house.getYear() <= 0 || this.house.getYear() > 974) {
                println("Некореткное значение возраста дома.")
            } else break
        }
        while (true) {
            println("введите кол-во лифтов в доме.")
            this.house.setNumberOfLifts(scan.nextInt())
            if (this.house.getNumberOfLifts() <= 0) {
                println("Некорректное значение кол-ва лифтов.")
            } else break
        }
        return this.house
    }

    fun askFurnish(): Furnish {
        while (true) {
            println("Выберите furnish из списка: DESIGNER, NONE, FINE, BAD.")
            when (scan.next()) {
                "DESIGNER" -> {
                    this.furnish = Furnish.DESIGNER
                    break
                }
                "NONE" -> {
                    this.furnish = Furnish.NONE
                    break
                }
                "FINE" -> {
                    this.furnish = Furnish.FINE
                    break
                }
                "BAD" -> {
                    this.furnish = Furnish.BAD
                    break
                }
                else -> println("Некорректное значение Furnish!")
            }
        }
        return this.furnish
    }

    fun askTransport(): Transport {
        while (true) {
            println("Выберите Transport из списка: FEW, NONE, NORMAL, ENOUGH")
            when (scan.next()) {
                "FEW" -> {
                    this.transport = Transport.FEW
                    break
                }
                "NONE" -> {
                    this.transport = Transport.NONE
                    break
                }
                "NORMAL" -> {
                    this.transport = Transport.NORMAL
                    break
                }
                "ENOUGH" -> {
                    this.transport = Transport.ENOUGH
                    break
                }
                else -> println("Некорректное значение Transport!")
            }
        }
        return this.transport
    }

    fun askView(): View {
        while (true) {
            println("Выберите View из списка: STREET, YARD, NORMAL, TERRIBLE")
            when (scan.next()) {
                "STREET" -> {
                    this.view = View.STREET
                    break
                }
                "YARD" -> {
                    this.view = View.YARD
                    break
                }
                "NORMAL" -> {
                    this.view = View.NORMAL
                    break
                }
                "TERRIBLE" -> {
                    this.view = View.TERRIBLE
                    break
                }
                else -> println("Некорректное значение View!")
            }
        }
        return this.view
    }
}