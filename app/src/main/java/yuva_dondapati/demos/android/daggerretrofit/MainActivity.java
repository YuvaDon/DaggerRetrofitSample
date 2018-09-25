package yuva_dondapati.demos.android.daggerretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import yuva_dondapati.demos.android.daggerretrofit.Api.ApiService;
import yuva_dondapati.demos.android.daggerretrofit.Application.PhotosApplication;
import yuva_dondapati.demos.android.daggerretrofit.MVP.PhotosInterface;
import yuva_dondapati.demos.android.daggerretrofit.MVP.PhotosPresenter;
import yuva_dondapati.demos.android.daggerretrofit.Model.PhotoAdapter;
import yuva_dondapati.demos.android.daggerretrofit.Model.Photos;

public class MainActivity extends AppCompatActivity implements PhotosInterface {

    @Inject
    ApiService apiService;

    RecyclerView recyclerView;

    PhotosPresenter photosPresenter;
    PhotoAdapter adapter;

    Observable<List<Photos>> observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((PhotosApplication) getApplication()).getApiComponent().inject(MainActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.rv1);
        setViews();
        photosPresenter = new PhotosPresenter(MainActivity.this);
        photosPresenter.onCreate();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        adapter = new PhotoAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        photosPresenter.onResume();
        photosPresenter.fetchPhotos();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {
        Log.d("Yuvaaa", "onError()");
    }

    @Override
    public void onPhotos(List<Photos> photosList) {
        adapter.setPhotosData(photosList);
    }

    @Override
    public Observable<List<Photos>> getPhotos() {
        return apiService.getPhotos();
    }
}
