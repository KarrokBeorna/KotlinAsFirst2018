package lesson6.task1

import lesson6.task1.seriesLength
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, timeStrToSeconds("10:00:00"))
        assertEquals(41685, timeStrToSeconds("11:34:45"))
        assertEquals(86399, timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", twoDigitStr(0))
        assertEquals("09", twoDigitStr(9))
        assertEquals("10", twoDigitStr(10))
        assertEquals("99", twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", timeSecondsToStr(36000))
        assertEquals("11:34:45", timeSecondsToStr(41685))
        assertEquals("23:59:59", timeSecondsToStr(86399))
    }

    @Test
    @Tag("Normal")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", dateStrToDigit("15 июля 2016"))
        assertEquals("", dateStrToDigit("3 мартобря 1918"))
        assertEquals("18.11.2018", dateStrToDigit("18 ноября 2018"))
        assertEquals("", dateStrToDigit("23"))
        assertEquals("03.04.2011", dateStrToDigit("3 апреля 2011"))
        assertEquals("", dateStrToDigit("32 сентября 2011"))
        assertEquals("", dateStrToDigit("29 февраля 1993"))
    }

    @Test
    @Tag("Normal")
    fun dateDigitToStr() {
        assertEquals("15 июля 2016", dateDigitToStr("15.07.2016"))
        assertEquals("", dateDigitToStr("01.02.20.19"))
        assertEquals("", dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", dateDigitToStr("03.04.2011"))
        assertEquals("", dateDigitToStr("ab.cd.ef"))
        assertEquals("", dateStrToDigit("32.09.2011"))
        assertEquals("", dateStrToDigit("29.02.1993"))
    }

    @Test
    @Tag("Normal")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("", flattenPhoneNumber("ab-123"))
        assertEquals("+12345", flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", flattenPhoneNumber("134_+874"))
    }

    @Test
    @Tag("Normal")
    fun bestLongJump() {
        assertEquals(717, bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, bestLongJump("% - - % -"))
        assertEquals(754, bestLongJump("700 717 707 % 754"))
        assertEquals(-1, bestLongJump("700 + 700"))
        assertEquals(2147483647, bestLongJump("2147483647 1326483642 1023896170 - -   %  -    %  % -  0     486031766 -       0 - - 1993793046  0 - 1 0 - 1 - - %  - 0  1078798891 1 2147483647  - - 0  %  -  - -    -   %  1085412328 - 685691957 2147483647    0 2147483647 0  -  - 576443147 - -    -    % 1759024422 547888128 1175333958 1  278478857 1 -    1852947830   -   - 1198196544  - -  2147483647 -   1867453775 - - 2147483647  -   2107186552 1493957945 2147483647  - - % %  0 1388966037 - 1   %  % 2147483647 2147483647 -  - % -  - 2026013749  - %  - -  - 0 - - -  -  1 - 2147483647 2147483647  % 0 - - 1967860188 916764958 %  429884259 - 2147483647 -  2147483647  0   %  180847582 -  %  - - - 1962542725 - - - 1 1  -  -  -   % -  1  2147483647 1655120124   2140344852 605222331    1096791632 - -  % 181794802 -  -  %  - 1 - % - 176815525  - 2147483647 2147483647 0  - 2147483647 % 580744880 - - % % %  2147483647 -  -   -  2147483647 1426161723 -    400119623   2147483647 % 0    - - 1   -   807804406  - % - 296646071  % 1824756897 -    1  - 291134864 -  % - - 0 2147483647 -  % % %   -  - 1  %   -  % % 402270270 1  1750682349 2020301662  237454586   329827452 1 -  -  - - 1 - % 616340324  -  %  -  1459595323 2147483647 1156088108 - - %  % - % 2147483647 2147483647 %  -   % - 1910676357 -   % %   % 2147483647 2147483647 - -  745012327  % % -"))


    }

    @Test
    @Tag("Hard")
    fun bestHighJump() {
        assertEquals(226, bestHighJump("226 +"))
        assertEquals(-1, bestHighJump("???"))
        assertEquals(230, bestHighJump("220 + 224 %+ 228 %- 230 + 232 %%- 234 %"))
        assertEquals(984451441, bestHighJump("761815374 %+ 798367136 %%- 147483647 %- 231557470 + 0 %+ 47635251 %- 855669123 %+ 546967043 %+ 147483648 %+ 147483648 %%- 960725544 %%- 146733922 %%- 0 %%+ 15923730 %%- 809603692 %%- 0 %%+ 292984135 %%- 0 %%- 133018257 %%- 0 %- 957759024 + 0 %- 0 %%- 1 %%+ 1 %%+ 0 + 1 + 147483648 %%- 1 %+ 0 %- 962251545 %%- 42971685 + 0 %- 113473973 %- 0 %+ 147483648 %- 0 + 147483647 %%- 1 + 0 %%- 142022436 %+ 147483648 %+ 147483648 %- 526905743 %%+ 250981787 %%- 1 %- 1 + 300046886 %%+ 147483648 %%- 147483647 %%+ 859051756 %- 915254604 %+ 147483648 %- 820511888 %- 802197736 %%+ 147483647 %+ 737293835 %+ 147483647 %%- 182124866 %+ 313023635 %- 364928107 %- 976218533 %- 984451441 %%+ 986986183 %%- 207707552 + 147483647 %%+ 1 %- 489100195 %%- 147483648 %%- 781377121 %%+ 197497103 %- 0 %%- 755468374 %%+ 147483648 %- 592000742 %- 147483647 + 788584282 + 296234825 %%- 113876837 %- 763246737 %+ 87360655 %+ 487695961 %%+ 370976945 %+ 147483648 %+ 951839250 %- 135078164 %+ 147483648 %%+ 1 %+ 0 %%+ 0 %%+ 719752405 %- 147483647 %+ 212217438 %+ 1 %+ 147483647 %%- 416419120 %+ 598184377 %+ 501792553 %+ 566048477 %- 1 %+ 0 %- 692608942 %%- 541278296 + 1 + 0 %%+ 0 %- 147483648 + 147483647 %%- 889945021 %+ 241231808 %%+ 866066113 %%- 989965176 %- 88077629 %+ 147483648 %%- 0 %%- 147483647 + 502303469 %+ 147483647 %%- 341356701 %+ 0 %%- 147483647 %+ 0 + 0 + 1 + 614411206 %%+ 89402213 %+ 1 %%+ 147483647 + 896247115 %+ 0 %+ 139147085 %+ 602542550 %- 0 %%- 147483648 %- 813432847 %- 948958267 + 1 %- 910699225 %- 1 %- 11802358 %+ 438415729 %- 1 %+ 0 %%- 1 %+"))

    }

    @Test
    @Tag("Hard")
    fun plusMinus() {
        assertEquals(0, plusMinus("0"))
        assertEquals(4, plusMinus("2 + 2"))
        assertEquals(6, plusMinus("2 + 31 - 40 + 13"))
        assertEquals(-1, plusMinus("0 - 1"))
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+ 4") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - + 12") }
    }

    @Test
    @Tag("Hard")
    fun firstDuplicateIndex() {
        assertEquals(-1, firstDuplicateIndex("Привет"))
        assertEquals(9, firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
        assertEquals(9, firstDuplicateIndex("Мы пошли Прямо прямо располагался магазин"))
        assertEquals(0, firstDuplicateIndex("Он он пошёл в школу"))
    }

    @Test
    @Tag("Hard")
    fun mostExpensive() {
        assertEquals("", mostExpensive(""))
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", mostExpensive("Вино 255.0"))
        assertEquals("Конфеты", mostExpensive("Хлеб 255.0; Молоко 255.0; Курица 255.0; Конфеты 255.0"))
    }

    @Test
    @Tag("Hard")
    fun fromRoman() {
        assertEquals(1, fromRoman("I"))
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))
    }

    @Test
    @Tag("Impossible")
    fun computeDeviceCells() {
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 10000))
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000))

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256))
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "===", 3) }
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "+>+>[+>", 3) }
        assertThrows(IllegalStateException::class.java) { computeDeviceCells(20, ">>>>>>>>>>>>>", 12) }
    }

    @Test
    fun seriesLength() {
        assertEquals("a3bab2cb3", seriesLength("aaababbcbbb"))
        assertEquals("", seriesLength(""))
        assertEquals("fpq4jb2c", seriesLength("fpqqqqjbbc"))
        assertEquals("fpq4jkprf", seriesLength("fpqqqqjkprf"))
    }

    @Test
    fun runners() {
        assertEquals(listOf("Найк 12:48", "Пума 12:51", "Адидас 12:53"), runners("Пума 12:51, Адидас 12:53, Найк 12:48"))
        assertEquals(emptyList<String>(), runners(""))
        assertEquals(listOf("Найк 12:48", "Пума 12:51", "Адидас 12:53", "Китайка 12:55"), runners("Пума 12:51, Китайка 12:55, Адидас 12:53, Найк 12:48"))
        assertEquals(listOf("Найк 12:48", "Пума 12:51", "Адидас 12:53"), runners("Пума 12:51, Китайка 12:60, Адидас 12:53, Найк 12:48"))
    }

    @Test
    fun phones() {
        assertEquals(listOf("+790947564"), phones("Вася +790947564, Петя 7282235723, Коля 857634638453", "Вася"))
        assertEquals(emptyList<String>(), phones("", "Вася"))
        assertEquals(listOf("+790947564", "73457347534"), phones("Вася +790947564, Петя 7282235723, Коля 857634638453, Вася прррррарапрапрар, Вася 73457347534", "Вася"))
        assertEquals(emptyList<String>(), phones("Дима +790947564, Петя 7282235723, Коля 857634638453", "Вася"))
    }
}

