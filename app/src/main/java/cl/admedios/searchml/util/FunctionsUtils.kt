package cl.admedios.searchml.util



import java.text.NumberFormat
import java.util.*


class FunctionsUtils {

    companion object {

        fun numberFormatLong(number: Long): String? {
            return NumberFormat.getIntegerInstance(Locale.GERMANY).format(number)
        }

    }
}