package com.progark.pokemonmasters.util;

import android.util.Log;
import android.widget.ArrayAdapter;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Data {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://134.209.77.105/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    private ApiService apiService = retrofit.create(ApiService.class);

    private Single<PokemonList> pokeListSingle = apiService.getPokemon();
    private Single<Pokemon> pokeSingle;


    public void getPokeList(final ArrayAdapter<Pokemon> pokeAdapter) {
        pokeListSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PokemonList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }


                    @Override
                    public void onSuccess(PokemonList pokemonList) {
                        pokeAdapter.addAll(pokemonList.getPokemon());
                        Log.i("PokeNetwork", "Networking successful");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Network", "Skylder på Ragnar!!!", e);
                    }
                });
    }

    public void getPokemon(int pokeId, final Pokemon targetPokemon) {
        pokeSingle = apiService.getSinglePokemon(pokeId);
        pokeSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Pokemon>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Pokemon pokemon) {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Network", "Single poke trouble", e);
                    }
                });
    }

}
