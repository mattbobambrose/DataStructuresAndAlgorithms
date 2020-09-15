class KotlinIntNode(var data: Int) {
    var next: KotlinIntNode? = null

    companion object {
        private fun countNodes(head: KotlinIntNode?): Int =
                if (head!!.next == null) 1 else (1 + countNodes(head.next))

        fun main() {
            // Code to make the first example list: 4 -> 2 -> null
            // Make the nodes
            val head1 = KotlinIntNode(4)
            val A = KotlinIntNode(2)
            // Make the connections
            head1.next = A

            // Code to make the second example list: 3 -> 10 -> 2 -> null
            // Make the nodes
            val head2 = KotlinIntNode(3)
            val X = KotlinIntNode(10)
            val Y = KotlinIntNode(2)
            // Make the connections
            head2.next = X
            X.next = Y

            // Test the countNodes function
            println(countNodes(head1)) // 2
            println(countNodes(head2)) // 3
        }
    }
}