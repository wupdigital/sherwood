package digital.wup.firebasedatabasetree

import android.util.Log
import com.google.firebase.database.DatabaseReference
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class FirebaseDatabaseTree(private val databaseReference: DatabaseReference, private val deviceId: String) : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH)
        val formattedDate = dateFormatter.format(System.currentTimeMillis())
        val priorityMap = mapOf(
                Log.ASSERT to "ASSERT",
                Log.DEBUG to "DEBUG",
                Log.ERROR to "ERROR",
                Log.INFO to "INFO",
                Log.VERBOSE to "VERBOSE",
                Log.WARN to "WARN"

        ).withDefault { "null" }

        databaseReference.child("Device ID: ".plus(deviceId)).push().setValue(FirebaseDatabaseLogMessage(formattedDate, priorityMap.getValue(priority), tag.toString(), message))
    }
}