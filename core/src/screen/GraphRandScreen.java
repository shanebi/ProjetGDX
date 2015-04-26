package screen;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.MyGdxGame;

import fortunes_algo.FortunesAlgorithm;
import fortunes_algo.Site;

/**
 * Affiche un Graph avec des cercles à des positions aléatoire.
 * @author trynobass
 *
 */
public class GraphRandScreen implements Screen {

	private FortunesAlgorithm fa;
	private ShapeRenderer sr;
	private Label lbl;
	private LabelStyle lblStyle;
	private BitmapFont bFont;
	private Stage stage;

	private MyGdxGame game;
	private Random rand;

	private int nbRand;

	/**
	 * Constructeur de la classe
	 * @param game La variable du jeu
	 */
	public GraphRandScreen(MyGdxGame game) {
		this.game = game;
	}

	@Override
	public void show() {

		bFont = new BitmapFont(Gdx.files.internal("default.fnt"));
		lblStyle = new LabelStyle(bFont, Color.WHITE);

		Gdx.graphics.setDisplayMode(1000, 1000, false);

		// Create a new set of sites
		rand = new Random();
		stage = new Stage();
		lbl = new Label("1", lblStyle);
		sr = new ShapeRenderer();
		fa = new FortunesAlgorithm(0, 0, 1000, 1000, 20);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		for (Site s : fa.sites()) {

			sr.begin(ShapeRenderer.ShapeType.Filled);
			sr.setColor(Color.BLUE);
			sr.circle(s.location().x, s.location().y, 50);
			sr.end();
			
			lbl.setPosition(s.location().x - 10, s.location().y - 10);
			stage.addActor(lbl);
			stage.draw();
		}
		
		actionAndroid();

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

	/**
	 * Méthode qui affiche un nombre aléatoire dans les labels quand on appuie sur l'écran.
	 */
	public void actionAndroid(){
		  Gdx.input.setInputProcessor(new InputProcessor() {

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		nbRand = rand.nextInt(20 - 0 + 1) + 0;
		lbl.setText(String.valueOf(nbRand));
		return false;
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
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
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
		  });}
}
