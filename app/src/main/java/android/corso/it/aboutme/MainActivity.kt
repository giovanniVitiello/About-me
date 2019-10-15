package android.corso.it.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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

//       findViewById<Button>(R.id.done_button).setOnClickListener{
//           addNickName(it)
//       }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            upDateNickName(it)
        }

        }

    }

    private fun addNickName(view : View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        //hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun upDateNickName(view: View){
        val nicknameEditText = findViewById<EditText>(R.id.nickname_edit)
        val button = findViewById<Button>(R.id.done_button)
        nicknameEditText.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        //nicknameEditText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nicknameEditText, 0)
    }

}
