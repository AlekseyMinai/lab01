package car

interface Car {

    fun turnOnEngine(): Boolean
    fun turnOffEngine(): Boolean
    fun setGear(newGear: Int): Boolean
    fun setSpeed(newSpeed: Int): Boolean
    fun printInfo()

}