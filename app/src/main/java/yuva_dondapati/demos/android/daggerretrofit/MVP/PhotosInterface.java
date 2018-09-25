package yuva_dondapati.demos.android.daggerretrofit.MVP;

import java.util.List;

import io.reactivex.Observable;
import yuva_dondapati.demos.android.daggerretrofit.Model.Photos;

public interface PhotosInterface {

    void onCompleted();
    void onError(String message);
    void onPhotos(List<Photos> photosList);

    Observable<List<Photos>> getPhotos();
}
