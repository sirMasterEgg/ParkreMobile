package acid.istts.parkremobile.utils

import java.text.NumberFormat
import java.util.*

object CurrencyUtils {

    fun Int.toRupiah():String{
        val numberFormat = NumberFormat.getCurrencyInstance(Locale("in","ID"))
        return numberFormat.format(this)
    }
}