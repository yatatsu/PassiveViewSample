package com.yatatsu.passiveviewsample.ui.input

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import butterknife.bindView
import com.yatatsu.passiveviewsample.PVSApplication
import com.yatatsu.passiveviewsample.R
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent
import com.yatatsu.passiveviewsample.ui.user.UserActivityAutoBundle
import javax.inject.Inject


class InputActivity : AppCompatActivity(), InputScreen {

  @Inject
  lateinit var controller: InputController

  val toolbar: Toolbar by bindView(R.id.toolbar)
  val editText: EditText by bindView(R.id.edit_text)
  val submitUsername: Button by bindView(R.id.submit_username)
  val inputLayout: TextInputLayout by bindView(R.id.input_layout)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_input)
    setSupportActionBar(toolbar)
    injectController().registerScreen(this)
    editText.setOnEditorActionListener { textView, i, keyEvent ->
      when(i) {
        EditorInfo.IME_ACTION_GO -> {
          controller.onSubmitEditText(textView.text.toString())
          return@setOnEditorActionListener true
        }
        else -> false
      }
    }
    submitUsername.setOnClickListener {
      controller.onSubmitEditText(editText.text.toString())
    }
  }

  fun injectController(): InputController {
    DaggerActivityInjectorComponent.builder().baseComponent(
        PVSApplication.baseComponent).build().inject(this)
    return controller
  }

  override fun navigateToUserScreen(username: String) {
    val intent = UserActivityAutoBundle.createIntentBuilder(username).build(this)
    startActivity(intent)
  }

  override fun showError(message: String) {
    inputLayout.error = message
  }

  override fun hideError() {
    inputLayout.error = null
  }
}
