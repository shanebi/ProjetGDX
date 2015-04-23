package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Classe qui gère l'interface avec deux boutons.
 * @author licencepronti
 *
 */
public class InterfaceScreen implements Screen {
	
	Skin skin;
	Stage stage ;
	
	CameraScreen maCamera ;
	GraphScreen monGraph ;
	
	MyGdxGame game ;
	Texture background ;
	
	public InterfaceScreen(MyGdxGame game){
		this.game = game;
	}
	
	
	@Override
	public void show() {
		maCamera = new CameraScreen(game);
		monGraph = new GraphScreen(game);
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
        createBasicSkin();
        
        TextButton btnCarte = new TextButton("Afficher carte", skin); // Use the initialized skin
        btnCarte.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , 800);
        stage.addActor(btnCarte);

        TextButton btnGraph = new TextButton("Afficher graph", skin); // Use the initialized skin
        btnGraph.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , 500);
        stage.addActor(btnGraph);
        
        TextButton btnQuit = new TextButton("Quitter", skin); // Use the initialized skin
        btnQuit.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , 200);
        stage.addActor(btnQuit);
		
		
		
		btnQuit.addListener( new ClickListener() {              
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	System.out.println("On quitte l'application.");
		        Gdx.app.exit();
		    };
		});
		
		btnCarte.addListener( new ClickListener() {              
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	game.setScreen(maCamera);
		    	
		    };
		});
		
		btnGraph.addListener( new ClickListener() {              
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	game.setScreen(monGraph);
		    	
		    };
		});

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		//stage.act(Gdx.graphics.getDeltaTime());
        stage.draw(); 
        //Table.drawDebug(stage);
	}

	
	@Override
	public void resize (int width, int height) {
		//stage.setViewport(width, height, false);
	}

	@Override
	public void dispose () {
		stage.dispose();
		skin.dispose();
	}

	@Override
	public void hide() {
		stage.clear();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
	
	
	private void createBasicSkin(){
		  //Create a font
		  BitmapFont font = new BitmapFont();
		  font.scale(1f);
		  skin = new Skin();
		  skin.add("default", font);

		  //Create a texture
		  Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
		  pixmap.setColor(Color.RED);
		  pixmap.fill();
		  skin.add("background",new Texture(pixmap));

		  //Create a button style
		  TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		  textButtonStyle.up = skin.newDrawable("background", Color.PINK);
		  textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
		  textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
		  textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
		  textButtonStyle.font = skin.getFont("default");
		  skin.add("default", textButtonStyle);

		}
	
	
}
