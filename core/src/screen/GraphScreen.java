package screen;

import shape.Cercle;
import shape.Ligne;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

/**
 * Affiche des cercles à des positions prédéfini.
 * 
 * @author trynobass
 *
 */
public class GraphScreen implements Screen, InputProcessor {

	private MyGdxGame game;
	private boolean isTouching;
	private SpriteBatch batch;
	private Stage stage;
	
	private Cercle c1;
	private Cercle c2;
	private Cercle c3;
	private Ligne l1;
	private Ligne l2;

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
		c1 = new Cercle(100, 500, 60);
		c2 = new Cercle(500,1200, 60);
		c3 = new Cercle(700, 700, 60);
		l1 = new Ligne();
		l2 = new Ligne();
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		stage.addActor(c1);
		stage.addActor(c2);
		stage.addActor(c3);
		stage.draw();
		
		c1.addListener( new ClickListener() {              
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	System.out.println("On quitte l'application.");
		        Gdx.app.exit();
		    };
		});
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		l1.draw(c1.getX(), c1.getY(), c2.getX(), c2.getY());
		l2.draw(c2.getX(), c2.getY(), c3.getX(), c3.getY());
		c1.draw(batch, Color.RED, "2");
		c2.draw(batch, Color.GREEN, "6");
		c3.draw(batch, Color.ORANGE, "9");
	}

	
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
