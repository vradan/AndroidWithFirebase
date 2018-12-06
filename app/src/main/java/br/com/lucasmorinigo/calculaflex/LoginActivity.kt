package br.com.lucasmorinigo.calculaflex

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.lucasmorinigo.calculaflex.extensions.getValue
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btSignup.setOnClickListener {
            startActivityForResult(Intent(this, SignUpActivity::class.java), 1)
        }

        btLogin.setOnClickListener {
            FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                            inputLoginEmail.getValue(),
                            inputLoginPassword.getValue()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this@LoginActivity, FormActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity,
                                    it.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            inputLoginEmail.setText(data?.getStringExtra("email"))
        }
    }
}
