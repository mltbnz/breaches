package de.db.mbnz.breaches.Activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import de.db.mbnz.breaches.Models.Breach
import de.db.mbnz.breaches.R
import de.db.mbnz.breaches.ViewModels.DetailViewModel
import kotlinx.android.synthetic.main.activity_breach_detail.*

class BreachDetailActivity : AppCompatActivity() {

    var viewModel: DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breach_detail)

        this.viewModel = intent.getSerializableExtra(VIEWMODEL) as? DetailViewModel
    }

    override fun onStart() {
        super.onStart()
        webView.loadData(viewModel?.descriptionHtml, "text/html; charset=utf-8", "UTF-8")
    }

    companion object {

        private val VIEWMODEL = "detailViewModel"

        fun newIntent(context: Context, viewModel: DetailViewModel): Intent {
            val intent = Intent(context, BreachDetailActivity::class.java)
            intent.putExtra(VIEWMODEL, viewModel)
            return intent
        }
    }
}
