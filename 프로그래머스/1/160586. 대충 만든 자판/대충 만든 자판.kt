class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val map = mutableMapOf<Char, Int>()

        for (key in keymap) {
            key.forEachIndexed { index, c ->
                val pressCount = index + 1
                map[c] = minOf(map.getOrDefault(c, Int.MAX_VALUE), pressCount)
            }
        }

        return targets.map { target ->
            var totalPress = 0
            for (c in target) {
                val press = map[c]
                if (press != null) {
                    totalPress += press
                } else {
                    totalPress = -1
                    break
                }
            }
            totalPress
        }.toIntArray()
    }
}