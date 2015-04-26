package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Classe qui se charge de créer une ligne entre deux points
 * 
 * @author trynobass
 *
 */
public class Ligne {

	
	private ShapeRenderer sr;

	public Ligne() {
		sr = new ShapeRenderer();
	}

	public void draw(float x1, float y1, float x2, float y2, int width,
			Color couleur) {
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(couleur);
		sr.rectLine(x1, y1, x2, y2, width);
		sr.end();
	}

}
