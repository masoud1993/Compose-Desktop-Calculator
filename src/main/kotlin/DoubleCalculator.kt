import java.util.*

object DoubleCalculator {
    private var lastTokenIsOperator = false
    fun evaluate(expression: String): Double {
        return try {
            val tokens = expression.toCharArray()

            // Stack for numbers: 'values'
            val values = Stack<Double>()

            // Stack for Operators: 'ops'
            val ops = Stack<Char>()
            var i = 0
            while (i < tokens.size) {

                // Current token is a whitespace, skip it
                if (tokens[i] == ' ') {
                    i++
                    continue
                }
                if (i == 0 && tokens[i] == '-') {
                    val sb = StringBuilder()
                    sb.append(tokens[i])
                    // There may be more than one digits in number
                    while (i + 1 < tokens.size && (tokens[i + 1] in '0'..'9' || tokens[i + 1] == '.')) {
                        sb.append(tokens[++i])
                    }
                    values.push(sb.toString().toDouble())
                    lastTokenIsOperator = false
                } else if (tokens[i] == '-' && lastTokenIsOperator) {
                    val sb = StringBuilder()
                    sb.append(tokens[i])
                    // There may be more than one digits in number
                    while (i + 1 < tokens.size && (tokens[i + 1] in '0'..'9' || tokens[i + 1] == '.')) {
                        sb.append(tokens[++i])
                    }
                    values.push(sb.toString().toDouble())
                    lastTokenIsOperator = false
                } else if (tokens[i] in '0'..'9') {
                    val sb = StringBuilder()
                    sb.append(tokens[i])
                    // There may be more than one digits in number
                    while (i + 1 < tokens.size && (tokens[i + 1] in '0'..'9' || tokens[i + 1] == '.')) {
                        sb.append(tokens[++i])
                    }
                    values.push(sb.toString().toDouble())
                    lastTokenIsOperator = false
                } else if (tokens[i] == '(') ops.push(tokens[i]) else if (tokens[i] == ')') {
                    while (ops.peek() != '(') values.push(applyOp(ops.pop(), values.pop(), values.pop()))
                    ops.pop()
                } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                    // While top of 'ops' has same or greater precedence to current
                    // token, which is an operator. Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() && hasPrecedence(ops.peek(), tokens[i])) values.push(
                        applyOp(
                            ops.pop(),
                            values.pop(),
                            values.pop()
                        )
                    )

                    // Push current token to 'ops'.
                    ops.push(tokens[i])
                    lastTokenIsOperator = true
                }
                i++
            }

            // Entire expression has been parsed at this point, apply remaining
            // ops to remaining values
            while (!ops.empty()) values.push(applyOp(ops.pop(), values.pop(), values.pop()))

            // Top of 'values' contains result, return it
            if (values.size > 0) values.pop() else throw UnsupportedOperationException("Invalid input!")
        } catch (e: Exception) {
            throw UnsupportedOperationException("Invalid input!")
        }
    }

    private fun hasPrecedence(peek: Char, currentOp: Char): Boolean {
        if (peek == '(' || peek == ')') return false
        return !((peek == '+' || peek == '-') && (currentOp == '*' || currentOp == '/'))
    }

    private fun applyOp(op: Char, b: Double, a: Double): Double {
        when (op) {
            '+' -> return a + b
            '-' -> return a - b
            '*' -> return a * b
            '/' -> {
                if (b == 0.0) throw UnsupportedOperationException("Divide by zero!")
                return a / b
            }
        }
        return 0.toDouble()
    }


}