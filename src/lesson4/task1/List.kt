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
fun mean(list: List<Double>): Double {
    return if (list.isEmpty()) 0.0 else
        list.sum() / list.size
}

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
    for (element in list.indices) list[element] -= sred
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
        if (num <= 1) break
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
        result = (result + pow(base.toDouble(), (a - 1).toDouble()) * digits[i]).toInt()
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
    val list = mutableListOf<Int>()
    for (i in 0 until a) {
        var b = str[i].toInt()
        b -= if (b < 58) 48 else 87
        list.add(b)
        result = (result + pow(base.toDouble(), (a - 1).toDouble()) * list[i]).toInt()
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
    var count = 0
    var number = n
    while (number > 0) {
        number /= 10
        count++
    }
    var char = ""
    var result = ""
    for (i in 1..count) {
        val k = (n % pow(10.0, (count + 1 - i).toDouble()) / pow(10.0, (count - i).toDouble())).toInt() * (pow(10.0, (count - i).toDouble())).toInt()
        when (k) {
            0 -> char = ""
            1 -> char = "I"
            2 -> char = "II"
            3 -> char = "III"
            4 -> char = "IV"
            5 -> char = "V"
            6 -> char = "VI"
            7 -> char = "VII"
            8 -> char = "VIII"
            9 -> char = "IX"
            10 -> char = "X"
            20 -> char = "XX"
            30 -> char = "XXX"
            40 -> char = "XL"
            50 -> char = "L"
            60 -> char = "LX"
            70 -> char = "LXX"
            80 -> char = "LXXX"
            90 -> char = "XC"
            100 -> char = "C"
            200 -> char = "CC"
            300 -> char = "CCC"
            400 -> char = "CD"
            500 -> char = "D"
            600 -> char = "DC"
            700 -> char = "DCC"
            800 -> char = "DCCC"
            900 -> char = "CM"
            1000 -> char = "M"
            else -> {
                var c = k / 1000
                while (c > 0) {
                    char += "M"
                    c--
                }
            }
        }
        result += char
    }
    return result
}

fun russianNames(n: Int): String {
    return when {
        n / 1000 % 100 in 11..14 step 1000 -> " тысяч "
        n / 1000 % 10 == 1 -> ""
        n / 1000 % 10 in 2..4 step 1000 -> ""
        else -> when {
            n % 1000 == 0 -> "тысяч"
            n % 100000 / 1000 in 3..99 -> " тысяч "
            else -> "тысяч "
        }
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
    var count = 0
    var number = n
    while (number > 0) {
        number /= 10
        count++
    }
    var char = ""
    var result = ""
    var num = n
    for (i in 1..count) {
        val k = (num % pow(10.0, (count + 1 - i).toDouble()) / pow(10.0, (count - i).toDouble())).toInt() * (pow(10.0, (count - i).toDouble())).toInt()
        num %= if (n % 10000 in 1000..2999) 10000
        else 1000
        when {
            k >= 3000 -> char = if (n % 10000 in 1000..2999) russian(n / 10000 * 10) + russianNames(n)
            else russian(n / 1000) + russianNames(n)
            k == 0 -> char = ""
            k == 1 && num % 100 == 1 -> char = "один"
            k == 2 && num % 100 == 2 -> char = "два"
            k == 3 && (n % 100 != 13) -> char = "три"
            k == 4 && (n % 100 != 14) -> char = "четыре"
            k == 5 && (n % 100 != 15) -> char = "пять"
            k == 6 && (n % 100 != 16) -> char = "шесть"
            k == 7 && (n % 100 != 17) -> char = "семь"
            k == 8 && (n % 100 != 18) -> char = "восемь"
            k == 9 && (n % 100 != 19) -> char = "девять"
            k == 10 && (n % 100 == 11 || n / 1000 % 100 == 11) -> char = "одиннандцать"
            k == 10 && (n % 100 == 12 || n / 1000 % 100 == 12) -> char = "двенадцать"
            k == 10 && (n % 100 == 13 || n / 1000 % 100 == 13) -> char = "тринадцать"
            k == 10 && (n % 100 == 14 || n / 1000 % 100 == 14) -> char = "четырнадцать"
            k == 10 && (n % 100 == 15 || n / 1000 % 100 == 15) -> char = "пятнадцать"
            k == 10 && (n % 100 == 16 || n / 1000 % 100 == 16) -> char = "шестнадцать"
            k == 10 && (n % 100 == 17 || n / 1000 % 100 == 17) -> char = "семнадцать"
            k == 10 && (n % 100 == 18 || n / 1000 % 100 == 18) -> char = "восемнадцать"
            k == 10 && (n % 100 == 19 || n / 1000 % 100 == 19) -> char = "девятнадцать"
            k == 10 && (n % 100 == 10 || n / 1000 % 100 == 10) -> char = "десять"
            k == 20 -> char = "двадцать "
            k == 30 -> char = "тридцать "
            k == 40 -> char = "сорок "
            k == 50 -> char = "пятьдесят "
            k == 60 -> char = "шестьдесят "
            k == 70 -> char = "семьдесят "
            k == 80 -> char = "восемьдесят "
            k == 90 -> char = "девяносто "
            k == 100 -> char = "сто "
            k == 200 -> char = "двести "
            k == 300 -> char = "триста "
            k == 400 -> char = "четыреста "
            k == 500 -> char = "пятьсот "
            k == 600 -> char = "шестьсот "
            k == 700 -> char = "семьсот "
            k == 800 -> char = "восемьсот "
            k == 900 -> char = "девятьсот "
            k == 1000 -> char = "одна тысяча "
            k == 2000 -> char = "две тысячи "
            else -> char = ""
        }
        result += char
    }
    return result
}