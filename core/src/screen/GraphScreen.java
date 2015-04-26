package screen;

import shape.Cercle;
import shape.Ligne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

/**
 * Affiche des cercles à des positions prédéfini.
 * 
 * @author trynobass
 *
 */
public class GraphScreen implements Screen {

	private MyGdxGame game;
	private SpriteBatch batch;
	private Stage stage;
	
	private Cercle c1;
	private Cercle c2;
	private Cercle c3;
	private Ligne l1;
	private Ligne l2;
	private Ligne l3;
	

	/**
	 * Constructeur de la classe
	 * 
	 * @param game
	 *            La variable du jeu
	 */
	public GraphScreen(MyGdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		stage = new Stage();
		
		c1 = new Cercle(120, 500, 60);
		c2 = new Cercle(500,1200, 60);
		c3 = new Cercle(700, 700, 60);
		l1 = new Ligne();
		l2 = new Ligne();
		l3 = new Ligne();
		
		stage.addActor(c1);
		stage.addActor(c2);
		stage.addActor(c3);
		stage.draw();	
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		l1.draw(c1.getX(), c1.getY(), c2.getX(), c2.getY());
		//l2.draw(c2.getX(), c2.getY(), c3.getX(), c3.getY());
		//l3.draw(c1.getX(), c1.getY(), c3.getX(), c3.getY());
		c1.draw(batch, Color.RED, "2");
		c2.draw(batch, Color.GREEN, "6");
		c3.draw(batch, Color.ORANGE, "9");
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
		stage.dispose();
		batch.dispose();
	}



}
