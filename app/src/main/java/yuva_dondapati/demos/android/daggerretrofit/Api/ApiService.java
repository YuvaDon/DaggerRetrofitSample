package yuva_dondapati.demos.android.daggerretrofit.Api;

import java.util.List;

import yuva_dondapati.demos.android.daggerretrofit.Model.Photos;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("photos")
    Observable<List<Photos>> getPhotos();
}
