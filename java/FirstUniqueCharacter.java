class FirstUniqueCharacter
{
    fun firstUniqChar(s: String): Int {
        var i = 0
        val hashMap: HashMap<Char, Int> = HashMap()
        //define empty hashmap
        for (c in s) {
            println(c)
            if (hashMap.containsKey(c)) hashMap.put(c, 9999)
            else hashMap.put(c, i)
            println(hashMap)
            i++
        }
        println(hashMap)
        val req = hashMap.filter { it.value != 9999 }.values.minOrNull()
        if (req != null) {
            return req.toInt()
        }
        return -1
    }

}
