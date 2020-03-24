package com.alexey.minay.labs.lab05.rational

data class Rational(
        private var numeration: Int = 0,
        private var denominator: Int = 1
) : Number() {

    fun setNumeration(newNumeration: Int) {
        numeration = newNumeration
    }

    fun getNumeration() = numeration

    fun getDenominator() = denominator

    override fun toDouble() = (numeration / denominator).toDouble()

    override fun toString() = "$numeration/$denominator"

    override fun toByte() = (numeration / denominator).toByte()

    override fun toChar() = (numeration / denominator).toChar()

    override fun toFloat() = (numeration / denominator).toFloat()

    override fun toInt() = numeration / denominator

    override fun toLong() = (numeration / denominator).toLong()

    override fun toShort() = (numeration / denominator).toShort()

    override fun equals(other: Any?): Boolean {
        when(other){
            is Number -> return super.equals(Rational(other.toInt()))
        }
        return super.equals(other)
    }

}