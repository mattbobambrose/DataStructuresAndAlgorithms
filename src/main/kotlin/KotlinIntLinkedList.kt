class KotlinIntLinkedList {
    private var head: KotlinIntNode? = null

    // Returns the total number of nodes in the Linked List
    fun countNodes() =
            if (head == null) {
                0
            } else {
                var count = 1
                var current = head!!
                while (current.next != null) {
                    current = current.next!!
                    count += 1
                }
                count
            }

    // Inserts a new node at the front of the LinkedList (prepend)
    fun insertFirst(data: Int) {
        val newNode = KotlinIntNode(data)
        newNode.next = head
        head = newNode
    }

    // Inserts a new node at the back of the LinkedList (append)
    fun insertLast(data: Int) {
        val newNode = KotlinIntNode(data)
        if (head == null) {
            head = newNode
        } else {
            var current: KotlinIntNode = head!!
            while (current.next != null) {
                current = current.next!!
            }
            current.next = newNode
        }
    }

    // Returns true if val is present in the list, and false otherwise
    fun search(v: Int): Boolean {
        var current = head
        while (current!!.next != null) {
            if (current.data == v) {
                return true
            }
            current = current.next
        }
        return current.data == v
    }

    // Removes the first node from the LinkedList, and returns its data value
    fun removeFirst() = head?.data?.also { head = head!!.next } ?: -1

    // Removes the last node from the LinkedList, and returns its data value
    fun removeLast(): Int {
        var current = head
        head = null
        while (current?.next != null) {
            insertLast(current.data)
            current = current.next
        }
        return current!!.data
    }

    fun removeAll(`val`: Int) {
        var current = head
        head = null
        while (current?.next != null) {
            if (current.data != `val`)
                insertLast(current.data)
            current = current.next
        }
        if (current != null && current.data != `val`) insertLast(current.data)
    }

    fun reverse() {
        var current = head
        head = null
        while (current?.next != null) {
            insertFirst(current.data)
            current = current.next
        }
        if (current != null) insertFirst(current.data)
    }

    fun hasCycle(): Boolean {
        var current = head
        val result = mutableListOf<Int>()
        while (current?.next != null) {
            if (result.contains(current.data)) {
                return true
            }
            result.add(current.data)
            current = current.next
        }
        return false
    }

    // toString function that is called when LinkedList is printed
    override fun toString(): String {
        var str = ""
        var current = head
        while (current != null) {
            str = str + current.data + " -> "
            current = current.next
        }
        str += "null"
        return str
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Test 1: insertFirst method
            // We are going to make a list containing 4 -> 2 -> 3 -> null
            println("Test 1:")
            val list1 = KotlinIntLinkedList()
            list1.insertFirst(3)
            list1.insertFirst(2)
            list1.insertFirst(4)
            println(list1) // 4 -> 2 -> 3 -> null

            // Test 2: insertLast method
            // We are going to make a list containing 7 -> 2 -> 5 -> 10 -> null
            println("\nTest 2:")
            val list2 = KotlinIntLinkedList()
            list2.insertLast(7)
            list2.insertLast(2)
            list2.insertLast(5)
            list2.insertLast(10)
            println(list2) // 7 -> 2 -> 5 -> 10 -> null

            // Test 3: search method
            println("\nTest 3:")
            println(list2.search(7)) // true
            println(list2.search(2)) // true
            println(list2.search(5)) // true
            println(list2.search(10)) // true
            println(list2.search(13)) // false

            // Test 4: removeFirst method
            println("\nTest 4:")
            list1.removeFirst()
            println(list1) // 2 -> 3 -> null
            list2.removeFirst()
            println(list2) // 2 -> 5 -> 10 -> null
            list2.removeFirst()
            println(list2) // 5 -> 10 -> null

            // Test 5: removeLast method
            println("\nTest 5:")
            list1.removeLast()
            println(list1) // 2 -> null
            list1.removeLast()
            println(list1) // null
            list2.removeFirst()
            println(list2) // 10 -> null
            list2.removeFirst()
            println(list2) // null

            // Test 6: removeAll method
            println("\nTest 6:")
            KotlinIntLinkedList().apply {
                insertLast(1)
                insertLast(2)
                insertLast(6)
                insertLast(3)
                insertLast(4)
                insertLast(6)
                insertLast(5)
                insertLast(6)
                removeAll(6)
                println(this) // 1 -> 2 -> 3 -> 4 -> 5 -> null
            }
            KotlinIntLinkedList().apply {
                insertLast(6)
                insertLast(5)
                insertLast(3)
                insertLast(6)
                insertLast(1)
                insertLast(2)
                insertLast(6)
                insertLast(0)
                removeAll(6)
                println(this) // 5 -> 3 -> 1 -> 2 -> 0 -> null
            }
            KotlinIntLinkedList().apply {
                insertLast(6)
                insertLast(6)
                insertLast(6)
                insertLast(6)
                insertLast(6)
                removeAll(6)
                println(this) // null
            }

// Test 7: reverse
            println("\nTest 7:")
            KotlinIntLinkedList().apply {
                insertLast(3)
                insertLast(2)
                insertLast(4)
                reverse()
                println(this) // 4 -> 2 -> 3 -> null
            }

// Test8: hasCycle
            println("\nTest 8:")
            KotlinIntLinkedList().apply {
                insertLast(3)
                insertLast(2)
                insertLast(4)
                head!!.next!!.next!!.next = head
                println(hasCycle()) // true
            }
            KotlinIntLinkedList().apply {
                insertLast(3)
                insertLast(2)
                insertLast(4)
                insertLast(5)
                head!!.next!!.next!!.next!!.next = head!!.next
                println(hasCycle()) // true
            }
            KotlinIntLinkedList().apply {
                insertLast(3)
                insertLast(2)
                insertLast(4)
                insertLast(5)
                println(hasCycle()) // false*/
            }
        }
    }
}