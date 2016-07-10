package com.yatatsu.passiveviewsample.ui.repos


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import butterknife.bindView
import com.yatatsu.autobundle.AutoBundle
import com.yatatsu.autobundle.AutoBundleField
import com.yatatsu.passiveviewsample.PVSApplication
import com.yatatsu.passiveviewsample.R
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent
import com.yatatsu.passiveviewsample.data.model.Repository
import com.yatatsu.passiveviewsample.ui.adapter.ReposAdapter
import timber.log.Timber
import javax.inject.Inject

class ReposActivity : AppCompatActivity(), ReposScreen {

  @Inject
  lateinit var controller: ReposController

  val toolbar: Toolbar by bindView(R.id.toolbar)
  val recyclerView: RecyclerView by bindView(R.id.recycler_view)

  @AutoBundleField
  var username: String? = null

  private var reposAdapter: ReposAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_repos)
    setSupportActionBar(toolbar)
    AutoBundle.bind(this)
    injectController().registerScreen(this)
    controller.onCreateScreen(username)

    recyclerView.layoutManager = LinearLayoutManager(this)
    reposAdapter = ReposAdapter(this, View.OnClickListener { view ->
      val position = recyclerView.getChildAdapterPosition(view)
      controller.onItemClick(reposAdapter!!.getItem(position))
    })
    recyclerView.adapter = reposAdapter
  }

  override fun onStart() {
    super.onStart()
    controller.onStartScreen()
  }

  override fun onStop() {
    super.onStop()
    controller.onStopScreen()
  }

  fun injectController(): ReposController {
    DaggerActivityInjectorComponent.builder().baseComponent(
        PVSApplication.baseComponent).build().inject(this)
    return controller
  }

  override fun showRepositories(repositories: List<Repository>) {
    reposAdapter!!.setRepos(repositories)
  }

  override fun showError(message: String) {
    AlertDialog.Builder(this).setTitle("Error").setMessage(message).create().show()
  }

  override fun openUrl(url: String) {
    try {
      startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    } catch (e: ActivityNotFoundException) {
      Timber.e(e, "cannot open %s", url)
    }

  }
}
