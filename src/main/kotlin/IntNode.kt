class IntNode(var data: Int) {
    var next: IntNode? = null

    companion object {
        private fun countNodes(head: IntNode?): Int =
                if (head!!.next == null) 1 else (1 + countNodes(head.next))

        fun main(args: Array<String?>?) {
            // Code to make the first example list: 4 -> 2 -> null
            // Make the nodes
            val head1 = IntNode(4)
            val A = IntNode(2)
            // Make the connections
            head1.next = A

            // Code to make the second example list: 3 -> 10 -> 2 -> null
            // Make the nodes
            val head2 = IntNode(3)
            val X = IntNode(10)
            val Y = IntNode(2)
            // Make the connections
            head2.next = X
            X.next = Y

            // Test the countNodes function
            println(countNodes(head1)) // 2
            println(countNodes(head2)) // 3
        }
    }
}