/*
 * Copyright (c) 2009 Piotr Piastucki
 * 
 * This file is part of Patchca CAPTCHA library.
 * 
 *  Patchca is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Patchca is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with Patchca. If not, see <http://www.gnu.org/licenses/>.
 */
package org.patchca.color;

import java.awt.*;
import java.util.Random;

public class Random2ColorFactory implements ColorFactory {

	private Color min;
	private Color max;

	public Random2ColorFactory() {
		min = new Color(0,0,0);
		max = new Color(255,255,255);
	}

	public Random2ColorFactory(Color min, Color max) {
		this.min = min;
		this.max = max;
	}

	public void setMin(Color min) {
		this.min = min;
	}

	public void setMax(Color max) {
		this.max = max;
	}

	public Color getColor(int index) {
		Random r = new Random();
		return new Color( min.getRed() + r.nextInt((max.getRed() - min.getRed())),
				min.getGreen() + r.nextInt((max.getGreen() - min.getGreen())),
				min.getBlue() + r.nextInt((max.getBlue() - min.getBlue())));
	}

}
