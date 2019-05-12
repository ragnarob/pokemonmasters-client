package com.progark.pokemonmasters.util;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.progark.pokemonmasters.model.GameInstance;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.Field;

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


    public void getPokeList(final PokemonList targetList) {
        pokeListSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PokemonList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }


                    @Override
                    public void onSuccess(PokemonList pokemonList) {
                        targetList.setPokemon(pokemonList);
                        Log.i("PokeNetwork", "Networking successful");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Network", "Skylder på Ragnar!!!", e);
                    }
                });
    }

    public void createGame(ApiPost apiPost) {
        apiService.createGame(apiPost).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GameInstance>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(GameInstance gameInstance) {
                        updateGameInstance(gameInstance);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("CreateGame", e.getMessage());
                    }
                });
    }

    private void updateGameInstance(GameInstance remoteInstance) {
        GameInstance localInstance = GameInstanceSingleton.getInstance().getGameInstance();
        localInstance.setGameCode(remoteInstance.getGameCode());
        localInstance.setGameToken(remoteInstance.getGameToken());

    }

}
