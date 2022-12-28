package io.github.parsergech

fun interface Parser<A> {
    fun parse(state: State): ParseResult<A>
}
