package yuva_dondapati.demos.android.daggerretrofit.DependencyInjection;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {

    //this component will retrn retrofit instance from module
    Retrofit retrofit();
}
