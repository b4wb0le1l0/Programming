package utility

import java.util.*

class AuthManager {
    private val tokenList = LinkedList<String>()

    private fun generateToken(username: String, password: String): String {
        val strings = listOf(username, password)
        val token = strings.flatMap { it.toList() + "."}.toList().reduce { pri, vet -> "$pri$vet" }.toString().dropLast(1)
        tokenList.add(token)
        return token
    }

    fun tokenExist(token: String?): Boolean {
        return if (token == null) {
            false
        } else tokenList.contains(token)
    }
}