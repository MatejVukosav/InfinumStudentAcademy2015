package co.infinum.boatit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.infinum.boatit.R;
import co.infinum.boatit.helpers.MvpFactory;
import co.infinum.boatit.mvp.presenters.LoginPresenter;
import co.infinum.boatit.mvp.views.LoginView;

/**
 * Created by kjurkovic on 17/07/15.
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @Bind(R.id.username)
    EditText username;

    @Bind(R.id.password)
    EditText password;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        password.setTransformationMethod(new PasswordTransformationMethod());
        presenter = MvpFactory.getPresenter(this);
    }

    @OnClick(R.id.login)
    public void login() {
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailed() {
        showMessage(getString(R.string.login_failed));
    }

    @Override
    public void showProgress() {
        showLoader();
    }

    @Override
    public void hideProgress() {
        hideLoader();
    }

    @Override
    public void showError(@StringRes int error) {
        showMessage(getString(error));
    }
}
