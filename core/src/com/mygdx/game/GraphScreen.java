package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import fortunes_algo.FortunesAlgorithm;
import fortunes_algo.Site;

public class GraphScreen implements Screen {

	
	private FortunesAlgorithm fa;
	SpriteBatch batch;
	ShapeRenderer sr;
	Texture img;
	
	MyGdxGame game;
	
	
	public GraphScreen(MyGdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {

		Gdx.graphics.setDisplayMode(1000, 1000, false);
		
		// Create a new set of sites
		sr = new ShapeRenderer();
		fa = new FortunesAlgorithm(0, 0, 1000, 1000, 20);
		batch = new SpriteBatch();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	    
		
		
		for(Site s : fa.sites()) {
			sr.begin(ShapeRenderer.ShapeType.Filled);
			sr.setColor(Color.BLUE);
            sr.circle(s.location().x, s.location().y, 50);
            sr.end();
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
