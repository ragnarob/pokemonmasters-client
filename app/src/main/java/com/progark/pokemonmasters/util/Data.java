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
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Data {


    private final OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://134.209.77.105/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
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

    public void createTeam(final ApiPost apiPost) {
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
                        updater();
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
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("getGameStatus", e.getMessage());
                    }
                });
    }

    public void addAction(final ApiPost apiPost) {
        apiService.addAction(apiPost).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Status>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Status status) {
                        Log.i("addActionSSS", status.getStatus() + status.getError());
                        if (status.getError() != null) {
                            Random r = new Random();
                            try {
                                Thread.sleep(r.nextInt(5000));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            addAction(apiPost);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("addActionEEE", e.getMessage());
                    }
                });
    }

    private void updater() {
        ApiPost apiPost = new ApiPost();
        apiPost.setGameToken(GameInstanceSingleton.getInstance().getGameInstance().getGameToken());
        Data data = new Data();
        data.getGameStatus(apiPost);
    }

    public void reliableAction(ApiPost apiPost) {
        addAction(apiPost);
    }

    private void updateGameInstance(GameInstance remoteInstance) {
        GameInstance localInstance = GameInstanceSingleton.getInstance().getGameInstance();
        if (!(remoteInstance == null)) {
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

}
