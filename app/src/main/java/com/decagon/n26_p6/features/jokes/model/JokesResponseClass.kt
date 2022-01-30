package com.decagon.n26_p6.features.jokes.model

data class JokesResponseClass(
    val category: String,
    val error: Boolean,
    val flags: Flags,
    val id: Int,
    val joke: String,
    val lang: String,
    val safe: Boolean,
    val type: String
)


fun JokesResponseClass.toJokesString() : JokesString {
    return JokesString(
        joke = joke,
        type = type
    )
}