package io.github.parsergech

data class InputLine(
    val line: Int,
    val column: Int,
    val content: String
) {
    companion object {
        private const val LS = "\n"

        fun from(state: State): InputLine {
            val lines = state.input.splitToSequence(LS)
            var consumed = 0
            for ((idx, line) in lines.withIndex()) {
                if (consumed <= state.offset && consumed + line.length + LS.length > state.offset) {
                    return InputLine(
                        line = idx,
                        column = state.offset - consumed,
                        content = line
                    )
                }
                consumed += line.length + LS.length
            }
            //should never be reached
            throw IllegalStateException("line detection algorithm error: consumed=$consumed, state=$state")
        }
    }
}