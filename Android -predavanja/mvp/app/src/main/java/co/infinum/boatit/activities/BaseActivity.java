package co.infinum.boatit.activities;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import co.infinum.boatit.R;

/**
 * Created by kjurkovic on 17/07/15.
 */
public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    protected void showMessage(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    protected void showLoader() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = ProgressDialog.show(this, getString(R.string.app_name), getString(R.string.please_wait), true, false);
        }
    }

    protected void hideLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        hideLoader();
    }
}
