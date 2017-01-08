package com.magicians.reflectorcrazy.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.magicians.reflectorcrazy.Reflector;

/**
 * Created by karan on 2017-01-03.
 */




public class StartScreen implements Screen {

    SpriteBatch batch;
    private Reflector app;
    private Texture appLogo;
    private int gameState=0;

    private Stage stage;
    private Skin skin;
    private TextButton startButton, scoresButton, creditsButton;
    private BitmapFont fontButton;

    public StartScreen(Reflector app){
        this.app=app;
        this.stage= new Stage(new StretchViewport(app.viewportWidth, app.viewportHeight, app.camera));
        this.fontButton=new BitmapFont();

    }

    @Override
    public void show() {

        System.out.println("Game Screen");

        appLogo = app.assets.get("sunset.jpg", Texture.class);

        this.skin=new Skin();
        this.skin.addRegions(app.assets.get("UI/uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font", fontButton);
        this.skin.load(Gdx.files.internal("UI/uiskin.json"));

        initButton();

        Gdx.input.setInputProcessor(stage);
    }


    private void initButton(){
        fontButton.getData().setScale(7.5f,7.5f);

        startButton = new TextButton("Start", skin, "default");
        startButton.setPosition(app.viewportWidth/4, app.viewportHeight*1/2);
        startButton.setSize(app.viewportWidth/2, app.viewportHeight/10);
        startButton.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {
                stage.clear();
                app.setScreen(app.gameScreen);

            }
        });


        stage.addActor(startButton);

        scoresButton = new TextButton("High\nScores", skin, "default");
        scoresButton.setPosition(app.viewportWidth/4, app.viewportHeight/3);
        scoresButton.setSize(app.viewportWidth/2, app.viewportHeight/7);
        scoresButton.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                app.setScreen(app.gameScreen); //CHANGE THIS TO HIGHSCORES SCREEN

            }
        });

        stage.addActor(scoresButton);

        creditsButton = new TextButton("Credits", skin, "default");
        creditsButton.setPosition(app.viewportWidth/4, app.viewportHeight/5);
        creditsButton.setSize(app.viewportWidth/2, app.viewportHeight/10);
        creditsButton.addListener(new ClickListener() {

            @Override

            public void clicked(InputEvent event, float x, float y) {

                app.setScreen(app.gameScreen);

            }
        });

        stage.addActor(creditsButton);

    }

    @Override
    public void render(float delta) {

        app.batch.begin();


        app.batch.draw(appLogo, Gdx.graphics.getWidth() - appLogo.getWidth(), (Gdx.graphics.getHeight()
                - appLogo.getHeight()) * 4 / 5, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 5);//places the centre of the
            // logo 4/5 of the way up, with a certain width and height

        Gdx.gl.glClearColor(1f,1f,1f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();

        app.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        fontButton.dispose();
    }
}