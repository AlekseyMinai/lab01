package com.alexey.minay.labs.lab05.rational

data class Rational(
        private var numeration: Int = 0,
        private var denominator: Int = 1
) : Number() {

    fun setNumeration(newNumeration: Int) {
        numeration = newNumeration
    }

    fun getNumeration() = if (numeration < 0 && denominator < 0) -numeration else numeration

    fun getDenominator() = if (numeration < 0 && denominator < 0) -denominator else denominator

    fun toCompoundFraction(): Pair<Int, Rational> {
        if (numeration < 0 && denominator < 0) {
            numeration = -numeration
            denominator = -denominator
        }
        val intNum = numeration / denominator
        numeration -= denominator * intNum
        if (intNum < 0) {
            if (numeration < 0) {
                numeration = -numeration
            }
            if (denominator < 0) {
                denominator = -denominator
            }
        }
        return intNum to this
    }

    override fun toDouble() = (numeration / denominator).toDouble()

    override fun toString() = "$numeration/$denominator"

    override fun toByte() = (numeration / denominator).toByte()

    override fun toChar() = (numeration / denominator).toChar()

    override fun toFloat() = (numeration / denominator).toFloat()

    override fun toInt() = numeration / denominator

    override fun toLong() = (numeration / denominator).toLong()

    override fun toShort() = (numeration / denominator).toShort()

}