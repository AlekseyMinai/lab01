import com.alexey.minay.lab01.task2.validator.ArgsValidator
import com.alexey.minay.lab01.task2.validator.ValidateStatus

class ArgsValidatorImpl : ArgsValidator {

    override fun validate(oldRadix: Int, newRadix: Int, value: String, numbers: List<Char>): ValidateStatus {
        if (oldRadix !in 2..numbers.size) {
            return ValidateStatus.INCORRECT_OLD_RADIX
        }
        if (newRadix !in 2..numbers.size) {
            return ValidateStatus.INCORRECT_NEW_RADIX
        }
        value.forEachIndexed { index, char ->
            if (char == '-' && index != 0) {
                return ValidateStatus.INCORRECT_VALUE
            }
            val v = numbers.indexOf(char)
            if (v >= oldRadix) {
                return ValidateStatus.INCORRECT_VALUE
            }
        }
        return ValidateStatus.VALID
    }
}