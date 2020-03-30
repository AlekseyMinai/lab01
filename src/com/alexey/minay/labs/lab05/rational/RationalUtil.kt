package com.alexey.minay.labs.lab05.rational

operator fun Rational.unaryMinus(): Rational {
    this.setNumeration(-this.getNumeration())
    return this
}

operator fun Rational.unaryPlus() = this

operator fun <T : Number> T.plus(value: T): Rational {
    return sumRational(this.toRational(), value.toRational())
}

operator fun <T : Number> T.minus(value: T): Rational {
    return sumRational(this.toRational(), -value.toRational())
}

operator fun <T : Number> T.times(value: T): Rational {
    return multiply(this.toRational(), value.toRational())
}

operator fun <T : Number> T.div(value: T): Rational {
    return multiply(this.toRational(), value.toRational().flipMembers())
}

operator fun <T : Number> T.compareTo(value: T): Int {
    return compare(this.toRational(), value.toRational())
}

private fun <T : Number> T.toRational() = when (this) {
    is Rational -> this
    else -> Rational(this.toInt())
}

private fun Rational.flipMembers(): Rational {
    return Rational(
            numeration = getDenominator(),
            denominator = getNumeration()
    )
}

private fun sumRational(rational1: Rational, rational2: Rational): Rational {
    val commonDenominator = rational1.getDenominator() * rational2.getDenominator()
    val numeration1 = rational1.getNumeration() * rational2.getDenominator()
    val numeration2 = rational2.getNumeration() * rational1.getDenominator()
    val sumNumeration = numeration1 + numeration2
    val maxCommonDivider = getMaxCommonDivider(sumNumeration, commonDenominator)
    return Rational(
            numeration = (sumNumeration / maxCommonDivider),
            denominator = (commonDenominator / maxCommonDivider)
    )
}

private fun multiply(rational1: Rational, rational2: Rational): Rational {
    val numeration = rational1.getNumeration() * rational2.getNumeration()
    val denominator = rational1.getDenominator() * rational2.getDenominator()
    val maxCommonDivider = getMaxCommonDivider(numeration, denominator)
    return Rational(
            numeration = numeration / maxCommonDivider,
            denominator = denominator / maxCommonDivider
    )
}

private fun compare(rational1: Rational, rational2: Rational): Int {
    return when {
        rational1.toDouble() > rational2.toDouble() -> 1
        rational1.toDouble() == rational2.toDouble() -> 0
        else -> -1
    }
}

private fun getMaxCommonDivider(fist: Int, second: Int): Int {
    var a = fist
    var b = second
    while (b != 0) {
        val temp = a % b
        a = b
        b = temp
    }
    return Math.abs(a)
}
