package com.neosoft.lab7;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("deprecation")
public class FontClass extends java.applet.Applet{
	Font f;
	String m;
	public void init() {
		f = new Font("TimesRoman", Font.BOLD+Font.ITALIC, 12);
		m = "Hello World!";
		setFont(f);
	}
	
	public void paint(Graphics g) {
		Color c = new Color(0, 255, 0);
		g.setColor(c);
		g.drawString(m, 4, 20);
	}
}
