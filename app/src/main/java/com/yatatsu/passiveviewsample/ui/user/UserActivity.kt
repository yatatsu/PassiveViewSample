package com.yatatsu.passiveviewsample.ui.user


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import butterknife.bindView
import com.squareup.picasso.Picasso
import com.yatatsu.autobundle.AutoBundle
import com.yatatsu.autobundle.AutoBundleField
import com.yatatsu.passiveviewsample.PVSApplication
import com.yatatsu.passiveviewsample.R
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent
import com.yatatsu.passiveviewsample.ui.repos.ReposActivityAutoBundle
import javax.inject.Inject

class UserActivity : AppCompatActivity(), UserScreen {

  @Inject
  lateinit var controller: UserController
  @Inject
  lateinit var picasso: Picasso

  val toolbar: Toolbar by bindView(R.id.toolbar)
  val userNameView: TextView by bindView(R.id.text_user_name)
  val userImageView: ImageView by bindView(R.id.user_image)
  val fabShowRepos: FloatingActionButton by bindView(R.id.fab_show_repos)

  @AutoBundleField
  var username: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_user)
    setSupportActionBar(toolbar)
    AutoBundle.bind(this)
    injectController()?.registerScreen(this)
    title = username
    fabShowRepos.setOnClickListener {
      controller.onClickReposButton()
    }
    controller.onCreateScreen(username)
  }

  override fun onDestroy() {
    super.onDestroy()
    controller.onDestroyScreen()
  }

  fun injectController(): UserController? {
    DaggerActivityInjectorComponent.builder().baseComponent(
        PVSApplication.baseComponent).build().inject(this)
    return controller
  }

  override fun showUserImage(avatarUrl: String) {
    picasso.load(avatarUrl)?.fit()?.into(userImageView)
  }

  override fun showUserName(fullName: String) {
    userNameView.text = fullName
  }

  override fun showErrorDialog(message: String) {
    AlertDialog.Builder(this).setTitle("Error").setMessage(message).create().show()
  }

  override fun navigateToReposScreen(username: String) {
    val intent = ReposActivityAutoBundle.createIntentBuilder(username).build(this)
    startActivity(intent)
  }
}
