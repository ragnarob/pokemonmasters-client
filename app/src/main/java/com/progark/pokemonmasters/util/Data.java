package com.progark.pokemonmasters.util;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.progark.pokemonmasters.JoinGameActivity;
import com.progark.pokemonmasters.model.GameInstance;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;
import com.progark.pokemonmasters.model.Status;

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

    public void joinGame(ApiPost apiPost, final JoinGameActivity activity) {
        apiService.joinGame(apiPost).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GameInstance>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(GameInstance gameInstance) {
                        updateGameInstance(gameInstance);
                        activity.createTeam();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("JoinGame", e.getMessage());
                    }
                });
    }

    public void createTeam(ApiPost apiPost) {
        apiService.createTeam(apiPost).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Status>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Status status) {
                        Log.i("createTeamSSS", status.getStatus() + status.getError());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("createTeamEEE", e.getMessage());
                    }
                });
    }

    public void getGameStatus(ApiPost apiPost) {
        apiService.getGameStatus(apiPost).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Status>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Status status) {
                        updateGameInstance(status.getGameInstance());
                        Log.i("getGameStatus", "Hope");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("getGameStatus", e.getMessage());
                    }
                });
    }

    private void updateGameInstance(GameInstance remoteInstance) {
        GameInstance localInstance = GameInstanceSingleton.getInstance().getGameInstance();
        if (!(remoteInstance.getGameCode() == null)){
            localInstance.setGameCode(remoteInstance.getGameCode());
        }
        if (!(remoteInstance.getGameToken() == null)){
            localInstance.setGameToken(remoteInstance.getGameToken());
        }
        if (!(remoteInstance.getPlayerNames() == null)){
            localInstance.setPlayerNames(remoteInstance.getPlayerNames());
        }
        if (!(remoteInstance.getState() == null)){
            localInstance.setState(remoteInstance.getState());
        }
        if (!(remoteInstance.getId() == null)){
            localInstance.setId(remoteInstance.getId());
        }
        if (!(remoteInstance.getGameStage() == null)){
            localInstance.setGameStage(remoteInstance.getGameStage());
        }
        if (!(remoteInstance.getV() == null)){
            localInstance.setV(remoteInstance.getV());
        }

    }

}
