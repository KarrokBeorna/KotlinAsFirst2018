package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun shoppingListCostTest() {
        val itemCosts = mapOf(
                "Хлеб" to 50.0,
                "Молоко" to 100.0
        )
        assertEquals(
                150.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко"),
                        itemCosts
                )
        )
        assertEquals(
                150.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко", "Кефир"),
                        itemCosts
                )
        )
        assertEquals(
                0.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко", "Кефир"),
                        mapOf()
                )
        )
    }

    @Test
    @Tag("Example")
    fun filterByCountryCode() {
        val phoneBook = mutableMapOf(
                "Quagmire" to "+1-800-555-0143",
                "Adam's Ribs" to "+82-000-555-2960",
                "Pharmakon Industries" to "+1-800-555-6321"
        )

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+999")
        assertEquals(0, phoneBook.size)
    }

    @Test
    @Tag("Example")
    fun removeFillerWords() {
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я как-то люблю Котлин".split(" "),
                        "как-то"
                )
        )
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я как-то люблю таки Котлин".split(" "),
                        "как-то",
                        "таки"
                )
        )
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я люблю Котлин".split(" "),
                        "как-то",
                        "таки"
                )
        )
    }

    @Test
    @Tag("Example")
    fun buildWordSet() {
        assertEquals(
                buildWordSet("Я люблю Котлин".split(" ")),
                mutableSetOf("Я", "люблю", "Котлин")
        )
        assertEquals(
                buildWordSet("Я люблю люблю Котлин".split(" ")),
                mutableSetOf("Котлин", "люблю", "Я")
        )
        assertEquals(
                buildWordSet(listOf()),
                mutableSetOf<String>()
        )
    }

    @Test
    @Tag("Normal")
    fun mergePhoneBooks() {
        assertEquals(
                mapOf("Emergency" to "112"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "112")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "112", "Police" to "02")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112, 911", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "911", "Police" to "02")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112, 911", "Fire department" to "01", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112", "Fire department" to "01"),
                        mapOf("Emergency" to "911", "Police" to "02")
                )
        )
    }

    @Test
    @Tag("Easy")
    fun buildGrades() {
        assertEquals(
                mapOf<Int, List<String>>(),
                buildGrades(mapOf())
        )
        // TODO: Sort the values here or let the students do it?
        assertEquals(
                mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат")),
                buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
        )
        assertEquals(
                mapOf(3 to listOf("Марат", "Семён", "Михаил")),
                buildGrades(mapOf("Марат" to 3, "Семён" to 3, "Михаил" to 3))
        )
    }

    @Test
    @Tag("Easy")
    fun containsIn() {
        assertTrue(containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")))
    }

    @Test
    @Tag("Normal")
    fun averageStockPrice() {
        assertEquals(
                mapOf<String, Double>(),
                averageStockPrice(listOf())
        )
        assertEquals(
                mapOf("MSFT" to 100.0, "NFLX" to 40.0),
                averageStockPrice(listOf("MSFT" to 100.0, "NFLX" to 40.0))
        )
        assertEquals(
                mapOf("MSFT" to 150.0, "NFLX" to 40.0),
                averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
        )
        assertEquals(
                mapOf("MSFT" to 150.0, "NFLX" to 45.0),
                averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0, "NFLX" to 50.0))
        )
    }

    @Test
    @Tag("Normal")
    fun findCheapestStuff() {
        assertNull(
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        "торт"
                )
        )
        assertEquals(
                "Мария",
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        "печенье"
                )
        )
    }

    @Test
    @Tag("Hard")
    fun propagateHandshakes() {
        assertEquals(
                mapOf(
                        "Marat" to setOf("Mikhail", "Sveta"),
                        "Sveta" to setOf("Mikhail"),
                        "Mikhail" to setOf()
                ),
                propagateHandshakes(
                        mapOf(
                                "Marat" to setOf("Sveta"),
                                "Sveta" to setOf("Mikhail")
                        )
                )
        )
        assertEquals(
                mapOf(
                        "Marat" to setOf("Mikhail", "Sveta"),
                        "Sveta" to setOf("Marat", "Mikhail"),
                        "Mikhail" to setOf("Sveta", "Marat")
                ),
                propagateHandshakes(
                        mapOf(
                                "Marat" to setOf("Mikhail", "Sveta"),
                                "Sveta" to setOf("Marat"),
                                "Mikhail" to setOf("Sveta")
                        )
                )
        )
        assertEquals(
                mapOf(
                        "bb" to setOf("26f", "2d", "0", "136", "37", "135", "283", "211", "1", "11f"),
                        "0" to setOf("bb", "135", "2d", "136", "211", "283", "26f", "11f", "1", "37"),
                        "26f" to setOf("0", "2d", "11f", "211", "1", "bb", "135", "136", "283", "37"),
                        "11f" to setOf("bb", "0", "135", "26f", "2d", "136", "37", "283", "211", "1"),
                        "37" to setOf("2d", "0", "bb", "135", "136", "211", "283", "26f", "11f", "1"),
                        "211" to setOf(),
                        "2d" to setOf("0", "bb", "135", "136", "211", "283", "26f", "11f", "1", "37"),
                        "136" to setOf(),
                        "283" to setOf("37", "26f", "0", "bb", "136", "135", "11f", "211", "1", "2d"),
                        "1" to setOf("0", "bb", "135", "2d", "136", "211", "283", "26f", "11f", "37"),
                        "135" to setOf("283", "bb", "11f", "1", "26f", "37", "0", "136", "2d", "211")
                ),
                propagateHandshakes(
                        mapOf(
                                "bb" to setOf("26f", "2d", "0", "136", "37", "135", "283", "211", "1", "11f"),
                                "0" to setOf("bb", "135", "2d", "136", "211", "283", "26f", "11f", "1"),
                                "26f" to setOf("0", "2d", "11f", "211", "1", "bb"),
                                "11f" to setOf("bb", "0", "135"),
                                "37" to setOf("2d"),
                                "211" to setOf(),
                                "2d" to setOf("0"),
                                "136" to setOf(),
                                "283" to setOf("37", "26f", "0", "bb", "136", "135", "11f", "211", "1", "2d"),
                                "1" to setOf("0"),
                                "135" to setOf("283", "bb", "11f", "1", "26f", "37", "0", "136", "2d", "211")
                        )
                )
        )
    }

    @Test
    @Tag("Easy")
    fun subtractOf() {
        val from = mutableMapOf("a" to "z", "b" to "c")

        subtractOf(from, mapOf())
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("b" to "z"))
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("a" to "z"))
        assertEquals(from, mapOf("b" to "c"))
    }

    @Test
    @Tag("Easy")
    fun whoAreInBoth() {
        assertEquals(
                emptyList<String>(),
                whoAreInBoth(emptyList(), emptyList())
        )
        assertEquals(
                listOf("Marat"),
                whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Marat", "Kirill"))
        )
        assertEquals(
                emptyList<String>(),
                whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Sveta", "Kirill"))
        )
    }

    @Test
    @Tag("Normal")
    fun canBuildFrom() {
        assertFalse(canBuildFrom(emptyList(), "foo"))
        assertTrue(canBuildFrom(listOf('a', 'b', 'o'), "baobab"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Marat"))
    }

    @Test
    @Tag("Normal")
    fun extractRepeats() {
        assertEquals(
                emptyMap<String, Int>(),
                extractRepeats(emptyList())
        )
        assertEquals(
                mapOf("a" to 2),
                extractRepeats(listOf("a", "b", "a"))
        )
        assertEquals(
                emptyMap<String, Int>(),
                extractRepeats(listOf("a", "b", "c"))
        )
    }

    @Test
    @Tag("Normal")
    fun hasAnagrams() {
        assertFalse(hasAnagrams(emptyList()))
        assertTrue(hasAnagrams(listOf("рот", "свет", "тор")))
        assertFalse(hasAnagrams(listOf("рот", "свет", "код", "дверь")))
    }

    @Test
    @Tag("Hard")
    fun findSumOfTwo() {
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(emptyList(), 1)
        )
        assertEquals(
                Pair(0, 2),
                findSumOfTwo(listOf(1, 2, 3), 4)
        )
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(listOf(1, 2, 3), 6)
        )
        assertEquals(
                Pair(0, 2),
                findSumOfTwo(listOf(4, 2, 9), 13)
        )
        assertEquals(
                Pair(2, 5),
                findSumOfTwo(listOf(1, 2, 15, 3, 9, 13, 5, 29), 28)
        )
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(listOf(1, 2, 11, 3, 9, 13, 5, 12), 28)
        )
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(listOf(15, 22, 31, 34, 19, 16, 25, 32), 28)
        )
        assertEquals(
                Pair(3, 6),
                findSumOfTwo(listOf(40699, 10698, 13020, 0, 13704, 24647, 1, 5195, 29036, 0, 40699), 1)
        )
    }

    @Test
    @Tag("Impossible")
    fun bagPacking() {
        assertEquals(
                setOf("Кубок"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                        850
                )
        )
        assertEquals(
                emptySet<String>(),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                        450
                )
        )
        assertEquals(
                setOf("Кубок", "Статуя"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000), "Статуя" to (750 to 3500)),
                        1250
                )
        )
        assertEquals(
                setOf("Статуя", "Меч"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000), "Статуя" to (750 to 3500), "Меч" to (750 to 3750)),
                        1500
                )
        )
        assertEquals(
                setOf("Кубок", "Статуя", "Меч"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000), "Статуя" to (750 to 3500), "Меч" to (750 to 3750)),
                        2000
                )
        )
    }

    // TODO: map task tests
}
