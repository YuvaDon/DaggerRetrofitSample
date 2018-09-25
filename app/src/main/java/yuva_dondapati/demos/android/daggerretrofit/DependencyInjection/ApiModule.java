package yuva_dondapati.demos.android.daggerretrofit.DependencyInjection;

import android.app.Application;

import yuva_dondapati.demos.android.daggerretrofit.Api.ApiService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    Application application;
    public ApiModule() {
    }

    @Provides
    @CustomScope
    ApiService getApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
