package yuva_dondapati.demos.android.daggerretrofit.MVP;

import android.util.Log;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.ArrayCompositeSubscription;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import yuva_dondapati.demos.android.daggerretrofit.MainActivity;
import yuva_dondapati.demos.android.daggerretrofit.Model.Photos;

public class PhotosPresenter implements Presenter {

    private Disposable mCompositeDisposable;
    public PhotosInterface photosInterface;

    public PhotosPresenter(PhotosInterface photosInterface) {
        this.photosInterface = photosInterface;
    }


    @Override
    public void onCreate() {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    protected <T> void subscribe(Observable<T> observable, DisposableObserver<T> observer) {
        mCompositeDisposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);

    }
    private DisposableObserver<List<Photos>> getDisposableObserver() {

        return new DisposableObserver<List<Photos>>() {

            @Override
            public void onNext(List<Photos> response) {
                Log.d("TAGGGG", "onResponse response : " + response);
                photosInterface.onPhotos(response);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TAGGGG", "onError " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("TAGGGG", "onCompleted");
            }
        };
    }
    public void fetchPhotos() {
       Observable<List<Photos>> observable =  photosInterface.getPhotos();
        Log.d("Yuvaaa", "fetchPhotos()" + observable);
        unSubscribeAll();
        subscribe(photosInterface.getPhotos(), getDisposableObserver());
    }

}
