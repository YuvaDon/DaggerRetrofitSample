package yuva_dondapati.demos.android.daggerretrofit.DependencyInjection;

import dagger.Component;
import yuva_dondapati.demos.android.daggerretrofit.MainActivity;

//this component depends on retrofitcopoment as apimodule requires retrofit instance
//which was returned by retrofitcomponents
@CustomScope
@Component(modules = ApiModule.class, dependencies = RetrofitComponent.class)
public interface ApiComponent{
    void inject(MainActivity mainActivity);
}
