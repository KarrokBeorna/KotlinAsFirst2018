@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var sum = 0.0
    for (element in v) {
        sum += sqr(element)
    }
    return sqrt(sum)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = if (list.isEmpty()) 0.0 else list.sum() / list.size

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val sred = mean(list)
    for (i in list.indices) list[i] -= sred
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for (i in a.indices) c += a[i] * b[i]
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var result = 0.0
    var a = 1.0
    for (i in p.indices) {
        result += p[i] * a
        a *= x
    }
    return result
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var a = 0.0
    for (i in list.indices) {
        list[i] += a
        a = list[i]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var num = n
    var a = 1
    do {
        a++
        if (num % a == 0) {
            result.add(a)
            num /= a
            a = 1
        }
    } while (num > 1)
    return result
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var result = mutableListOf<Int>()
    var num = n
    if (n == 0) result = listOf(0).toMutableList()
    else
        while (num > 0) {
            result.add(num % base)
            num /= base
        }
    return result.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var result = ""
    var num = n
    if (n == 0) return "0"
    else
        while (num > 0) {
            val a = num % base
            result += if (a < 10) a.toString() else ('a' + (a - 10))
            num /= base
        }
    return result.reversed()
}


fun pow(base: Int, a: Int): Int {
    var result = 1
    for (i in 1..a)
        result *= base
    return result
}


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0
    var a = digits.size
    for (i in 0 until a) {
        result += pow(base, (a - 1)) * digits[i]
        a -= 1
    }
    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var result = 0
    var a = str.length
    for (i in 0 until a) {
        val b = str[i]
        val c = if (b <= '9') b - '0' else b - 'a' + 10
        result += pow(base, (a - 1)) * c
        a -= 1
    }
    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var char = ""
    var result = ""
    val a = if (n > 999) 3 else n.toString().length
    for (i in 1..a) {
        val k = n % pow((10), (a + 1 - i))
        when (k) {
            0 -> char = ""
            in 1..3 -> char = "I".repeat(k)
            4 -> char = "IV"
            in 5..8 -> char = "V" + "I".repeat(k - 5)
            9 -> char = "IX"
            in 10..30 -> char = "X".repeat(k / 10)
            in 40..49 -> char = "XL"
            in 50..89 -> char = "L" + "X".repeat((k - 50) / 10)
            in 90..99 -> char = "XC"
            in 100..399 -> char = "C".repeat(k / 100)
            in 400..499 -> char = "CD"
            in 500..800 -> char = "D" + "C".repeat((k - 500) / 100)
            in 900..999 -> char = "CM"
        }
        result += char
    }
    return "M".repeat(n / 1000) + result
}

val russianUnits = listOf("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
val russianTeens = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
        "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
val russianTens = listOf("двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
        "семьдесят", "восемьдесят", "девяносто")
val russianHundreds = listOf("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот",
        "семьсот", "восемьсот", "девятьсот")
val russianExceptions = listOf("одна", "две")

fun russianNames(n: Int): String {
    return when {
        n / 1000 % 100 in 10..19 && n % 1000 == 0 -> " тысяч"
        n / 1000 % 100 in 10..19 -> " тысяч "
        n / 1000 % 10 == 1 && n % 1000 == 0 -> " тысяча"
        n / 1000 % 10 == 1 -> " тысяча "
        n / 1000 % 10 in 2..4 && n % 1000 == 0 -> " тысячи"
        n / 1000 % 10 in 2..4 -> " тысячи "
        n % 1000 == 0 -> " тысяч"
        else -> " тысяч "
    }
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var c = 0
    var number = n
    while (number > 0) {
        number /= 10
        c++
    }
    var result = ""
    var num = n
    for (i in 1..c) {
        val k = num % pow((10), (c + 1 - i)) / pow((10), (c - i)) * pow((10), (c - i))
        num %= when {
            n % 100000 in 11000..19999 -> 1000
            n % 10000 in 1000..2999 -> 10000
            else -> 1000
        }
        val char = when {
            k >= 3000 -> when {
                n % 100000 in 11000..19999 -> russian(n / 1000) + russianNames(n)
                n % 10000 in 1000..2999 -> russian(n / 10000 * 10) + " "
                else -> russian(n / 1000) + russianNames(n)
            }
            k == 0 -> ""
            k in 1..9 && ((num % 100) !in 10..19) -> russianUnits[k - 1]
            k in 10..19 && num % 100 in 10..19 -> russianTeens[num % 100 - 10]
            k in 20..90 step 10 -> if (num % 100 in 20..90 step 10) russianTens[k / 10 - 2] else russianTens[k / 10 - 2] + " "
            k in 100..900 step 100 -> if (num % 1000 in 100..900 step 100) russianHundreds[k / 100 - 1] else russianHundreds[k / 100 - 1] + " "
            k in 1000..2000 step 1000 -> russianExceptions[k / 1000 - 1] + russianNames(n)
            else -> ""
        }
        result += char
    }
    return result
}