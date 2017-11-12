package de.db.mbnz.breaches.Activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.R

class BreachDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breach_detail)
    }

    companion object {

        private val BREACH = "breach"

        fun newIntent(context: Context, breach: Breach): Intent {
            val intent = Intent(context, BreachDetailActivity::class.java)
            intent.putExtra(BREACH, breach)
            return intent
        }
    }
}
