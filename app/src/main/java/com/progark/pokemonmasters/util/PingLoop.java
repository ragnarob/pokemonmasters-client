package com.progark.pokemonmasters.util;

public class PingLoop implements Runnable {

    private Data postData = new Data();
    private ApiPost apiPost = new ApiPost();
    private String gameToken;

    public PingLoop(String gameToken) {
        this.gameToken = gameToken;
    }

    @Override
    public void run() {
        while (true) {
            apiPost.setGameToken(gameToken);
            postData.getGameStatus(apiPost);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
