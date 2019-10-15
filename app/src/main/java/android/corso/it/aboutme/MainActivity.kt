package android.corso.it.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*collego id_button ad una variabile e dopo col setOnClickLis gli dico cosa fare al momento del touch
        * ovvero gli passo la funzione addNickName*/

        val button = findViewById<Button>(R.id.done_button)
        button.setOnClickListener{
            addNickName(it)
            /*oppure in una singola riga di codice, come sotto, senza creare una variabile*/

//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickName(it)
        }
    }

    private fun addNickName(view : View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
    }
    
}
