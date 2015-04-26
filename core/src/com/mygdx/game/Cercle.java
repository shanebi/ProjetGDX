package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Classe qui se charge de créer un cercle
 * 
 * @author trynobass
 *
 */
public class Cercle extends Actor {

	private float x, y, radius;
	private ShapeRenderer sr;

	/**
	 * Constructeur de la classe
	 * 
	 * @param x
	 *            Coordonnée x du cercle
	 * @param y
	 *            Coordonnée y du cercle
	 * @param radius
	 *            Radius du cercle
	 */
	public Cercle(float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		sr = new ShapeRenderer();
	}

	/**
	 * Méthode qui affiche le cercle
	 * 
	 * @param batch
	 *            SpriteBatch du screen
	 * @param couleur
	 *            Couleur du cercle
	 */
	public void draw(SpriteBatch batch, Color couleur) {
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(couleur);
		sr.circle(x, y, radius);
		sr.end();
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	

}
