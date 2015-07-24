package co.infinum.boatit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.boatit.BoatApplication;
import co.infinum.boatit.R;
import co.infinum.boatit.adapter.BoatsAdapter;
import co.infinum.boatit.helpers.MvpFactory;
import co.infinum.boatit.models.Boat;
import co.infinum.boatit.mvp.presenters.BoatsPresenter;
import co.infinum.boatit.mvp.views.BoatsView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity implements BoatsView, AdapterView.OnItemClickListener {

    BoatsPresenter presenter;

    @Bind(R.id.boat_list)
    ListView boatList;

    @Bind(R.id.empty_view)
    ImageView emptyView;

    private BoatsAdapter adapter;

    private AdapterView.OnItemClickListener onItemClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            presenter.onBoatClicked(adapter.getItem(position));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = MvpFactory.getPresenter(this);
        presenter.getBoats();
    }

    @Override
    public void onBoatListReceived(List<Boat> boats) {
        adapter = new BoatsAdapter(this, R.layout.list_item_boats, boats);
        boatList.setAdapter(adapter);
        boatList.setOnItemClickListener(this);
    }

    @Override
    public void onBoatListEmpty() {
        boatList.setEmptyView(emptyView);
    }

    @Override
    public void onTokenExpired() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BoatApplication.getApiService().getComments(adapter.getItem(position).getId(), 1, 100, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
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
