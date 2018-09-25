package yuva_dondapati.demos.android.daggerretrofit.Application;

import android.app.Application;

import yuva_dondapati.demos.android.daggerretrofit.DependencyInjection.ApiComponent;
import yuva_dondapati.demos.android.daggerretrofit.DependencyInjection.DaggerApiComponent;
import yuva_dondapati.demos.android.daggerretrofit.DependencyInjection.DaggerRetrofitComponent;
import yuva_dondapati.demos.android.daggerretrofit.DependencyInjection.RetrofitComponent;
import yuva_dondapati.demos.android.daggerretrofit.DependencyInjection.RetrofitModule;

public class PhotosApplication extends Application {

    public static final String BASE_URL ="https://jsonplaceholder.typicode.com/";
    private ApiComponent apiComponent;
    @Override
    public void onCreate() {
        SetUpDependecies();
        super.onCreate();
    }

    private void SetUpDependecies() {
        apiComponent = DaggerApiComponent.builder().
                                    retrofitComponent(getRetrofitComponent()).build();

    }
    public RetrofitComponent getRetrofitComponent(){

        RetrofitComponent retrofitComponent = DaggerRetrofitComponent.builder().
                                                retrofitModule(new RetrofitModule(BASE_URL)).build();
        return retrofitComponent;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
