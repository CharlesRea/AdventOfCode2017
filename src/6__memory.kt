val initialMemory = intArrayOf(5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6)

fun reallocateMemory(memory: IntArray): IntArray {
    val maxValue = memory.max()
    if (maxValue == 0 || maxValue == null) return memory
    val indexOfMax = memory.indexOf(maxValue);
    val result = memory.copyOf()
    result[indexOfMax] = 0
    for (i in 1..maxValue) {
        result[(i + indexOfMax) % result.size] += 1
    }
    return result
}

fun findDuplicateIndex(memory: IntArray, memoryHistory: List<IntArray>): Int {
    return memoryHistory.indexOfFirst { it.contentEquals(memory) }
}

fun main(args: Array<String>) {
    val memoryHistory = mutableListOf<IntArray>()
    var currentMemory = initialMemory
    while (findDuplicateIndex(currentMemory, memoryHistory) == -1) {
        memoryHistory.add(currentMemory)
        currentMemory = reallocateMemory(currentMemory)
    }
    println(memoryHistory.size)
    println(memoryHistory.size - findDuplicateIndex(currentMemory, memoryHistory))
}