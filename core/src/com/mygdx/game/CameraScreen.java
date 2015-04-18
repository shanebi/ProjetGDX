package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class CameraScreen implements Screen{

	Texture background;
	SpriteBatch batch;
	MyGdxGame game;
	private OrthographicCamera camera;
	int width;
	int height;


	int x0,y0,x1,y1;  // position du premier et deuxi�me doigt

	int lastx0 ;      // pr�c�dente position du 1er doigt
	int lasty0 ;      // pr�c�dente position du 1er doigt

	int lastx1 ;      // pr�c�dente position du 2eme doigt pos� sur l'�cran
	int lasty1 ;      // pr�c�dente position du 2eme doigt pos� sur l'�cran
	public static float vitesse_zoom = 0.02f;
	public static float vitesse_deplacement_camera = 200;

	public static float max_zoom = 1f;    // maximum qu'on peut zoomer
	public static float min_zoom = 0.5f;  // minimum qu'on peut zoomer

	private int limite_image_maxHauteur ;  // limite d�placement camera
	private int limite_image_maxLargeur ;  // limite d�placement camera
	public static int limite_image_minHauteur = 0;    // limite d�placement camera
	public static int limite_image_minLargeur = 0 ;   // limite d�placement camera


	private int largeur_Ecran ;
	private int hauteur_Ecran ;

	public CameraScreen(MyGdxGame game){        
		this.game=game;
		this.width = Gdx.graphics.getWidth();
		this.height = Gdx.graphics.getHeight();
	}

	@Override
	public void show() {
		
		largeur_Ecran = Gdx.graphics.getWidth();
        hauteur_Ecran = Gdx.graphics.getHeight();
        
		background = new Texture(Gdx.files.internal("fond.jpg"));
		batch = new SpriteBatch();

		camera = new OrthographicCamera(largeur_Ecran,hauteur_Ecran);
		 camera.position.set(largeur_Ecran*0.5f, hauteur_Ecran*0.5f, 0);
         camera.update();
        
         limite_image_maxHauteur = background.getHeight() /2;
         limite_image_maxLargeur = background.getWidth() /2;
        
         limite_image_minHauteur = hauteur_Ecran/2;
         limite_image_minLargeur = largeur_Ecran/2;
	}
	@Override
	public void render(float delta) {

		/*** fond color� *****/
		/*Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    

		camera.update();

		batch.setProjectionMatrix(camera.combined);//permet d'activer les input
		batch.begin();
		batch.draw(background, 0,                 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.end();


		handleInput();*/
		
		
		GL20 gl = Gdx.graphics.getGL20(); 
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
  
        gl.glViewport(0,0,largeur_Ecran,hauteur_Ecran);
       // camera.apply(gl);
        camera.update();   
       
        manipulerCameraAndroid();
       
        batch.setProjectionMatrix(camera.combined);
     
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

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
	
	public void manipulerCameraAndroid(){
		  Gdx.input.setInputProcessor(new InputProcessor() {

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
		//camera.translate(screenX, screenY, pointer);

		// ************** Saisir les coordonn�es actuelles    ********************/
		if(pointer==1) // Pour le 2eme doigt
		{
			x1=screenX;
			y1=screenY;
		}
		if(pointer==0) // Pour le 1er doigt
		{
			x0=screenX;
			y0=screenY;
		}

		/*********** Op�ration : Zoom sur carte *******************************/

		if(Gdx.input.isTouched(1)){ // si deux doigt sont pos�s sur l'�cran                                   {
			// Comparer entre la distance actuelle (entre les 2 doigts) et la distance pr�c�dente
			if(Math.pow(x0-x1,2)+Math.pow(y0-y1,2)>Math.pow(lastx0-lastx1,2)+Math.pow(lasty0-lasty1,2))
			{
				if(camera.zoom>min_zoom)  // limite du zoom avant
					camera.zoom-=vitesse_zoom;
			}
			else
			{
				if(camera.zoom<max_zoom)  // limite du zoom arri�re
					camera.zoom+=vitesse_zoom;
			}
	}     

	/********** Operation : D�placer camera avec un doigt ******************/

	if(!Gdx.input.isTouched(1))             // si un seul doigt est pos� sur l'�cran
	{

		// les quatres directions principales :
		//-------------------------------------
		if(y0-lasty0>0 && x0-lastx0<5 &&  x0-lastx0>-5 )  // si drag vers haut avec tol�rance sur x
		{
			if(camera.position.y<limite_image_maxHauteur) // limite de la camera
			{
				camera.translate(0, vitesse_deplacement_camera);
			}
		}
		else
		{
			if(y0-lasty0<0 && x0-lastx0<5 &&  x0-lastx0>-5)   // Si drag vers bas
			{
				if(camera.position.y>limite_image_minHauteur) // Limite de la camera en bas
				{
					camera.translate(0, -vitesse_deplacement_camera);
				}
			}
		}
		if(x0-lastx0<0 && y0-lasty0>-5 && y0-lasty0<5)    // Si drag vers droite
		{
			if(camera.position.x<limite_image_maxLargeur) // Limite de la camera a droite
			{
				camera.translate(vitesse_deplacement_camera, 0);
			}
		}
		else
		{
			if(x0-lastx0>0 && y0-lasty0>-5 && y0-lasty0<5)     // Si drag vers gauche
			{
				if(camera.position.x>limite_image_minLargeur)  // Limite de la camera � gauche
				{
					camera.translate(-vitesse_deplacement_camera, 0);
				}
			}
		}
	}
	 if(pointer==1) //  2eme doigt
     {
           lastx1 = x1;
            lasty1 = y1;
     }
     if(pointer==0)//   1er doigt
     {
            lastx0 = x0;
            lasty0 = y0;
     }
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
});
		  }
}
