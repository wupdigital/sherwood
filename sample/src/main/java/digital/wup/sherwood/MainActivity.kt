package digital.wup.sherwood

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
import digital.wup.firebasedatabasetree.FirebaseDatabaseTree
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree(), FirebaseDatabaseTree(FirebaseDatabase.getInstance().reference, 101.toString()))

        val buttonLog = findViewById<Button>(R.id.buttonLog)

        buttonLog.setOnClickListener {
            Timber.d("this is a debug log message")
            Timber.v("this is a verbose log message")
            Timber.i("this is an info log message")
            Timber.e("this is an error log message")
            Timber.wtf("what the fck is happening")
            Timber.e(Exception("this is a huge exception E"))
        }
    }
}
