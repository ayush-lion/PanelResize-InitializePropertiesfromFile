package com.app.instruction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import com.app.instruction.panel.InstructionPanel;

public class InstructionTutor {

	// class for instruction structure
	private int count = 0;
	private String ins_text;
	private String ins_shape;
	private InstructionPanel panel;
	private Image image;
	private int posX;
	private int posY;
	private int width;
	private boolean switchable;

	private void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	/** draw_think of tutor*/
	
	public void draw_think(Graphics g)
	{
		if (isSwitchable()) {
			String sb = null;
			String str = getIns_text();
			String[] strArray = str.split(" ");
			StringBuffer sbuf = new StringBuffer();

			for (int i = 0; i < strArray.length; i++) {
				if (i != 0 && i % 6 == 0) {
					sbuf.append("\n");
					count = i;
				}
				sbuf.append(strArray[i]).append(" ");
			}
			sb = sbuf.toString();
			g.setFont(g.getFont().deriveFont(12f));
			g.setColor(Color.BLACK);
			if(count<=6) 
			{
			g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/4);    
			}
			else if(count>=12)
			{
			g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/2);    
			}
			else if(count>=18)
			{
		    g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/2);   
			}
			else 
			{
			g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/1); 	
			}
			drawString(g, sb, getPosX() + 5, getPosY()+60);
		} else {
			//g.setColor(Color.TRANSLUCENT);
			g.setColor(Color.WHITE);
			g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());
		}
		
	}
	
	/** draw_instruction of tutor*/
	
	public void draw_instruction(Graphics g)

	{
		if (isSwitchable()) {
			String sb = null;
			String str = getIns_text();
			String[] strArray = str.split(" ");
			StringBuffer sbuf = new StringBuffer();

			for (int i = 0; i < strArray.length; i++) {
				if (i != 0 && i % 6 == 0) {
					sbuf.append("\n");
					count = i;
				}
				sbuf.append(strArray[i]).append(" ");
			}
			sb = sbuf.toString();
			g.setFont(g.getFont().deriveFont(12f));
			g.setColor(Color.BLACK);
			if(count<=6) 
			{
			g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/5);    
			}
			else if(count>6)
			{
			g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/4);    
			}
			else if(count>=18)
			{
		    g.drawRect(getPosX(), getPosY()+60, getWidth(), getHeight()/3);   
			}
			else 
			{
			g.drawRect(getPosX(), getPosY()+50, getWidth(), getHeight()/2); 	
			}
			drawString(g, sb, getPosX() + 5, getPosY()+50);
		} else {
			//g.setColor(Color.TRANSLUCENT);
			g.setColor(Color.WHITE);
			g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());
		}
	}

	private ArrayList<String> fragmentText(String text, int maxWidth) {
		ArrayList<String> lines = new ArrayList<String>();
		String line = "";
		if (text.length() < maxWidth) {
			lines.add(text);
			return lines;
		}

		String[] words = text.split(" ");
		boolean isAdded = false;
		for (String word : words) {
			String txt = line + word + " ";
			int len = txt.length();
			if (len >= maxWidth) {
				isAdded = true;
				lines.add(line);
				line = word + " ";
				txt = "";
			} else {
				isAdded = false;
				line = txt;
			}
		}

		if (!isAdded) {
			lines.add(line);
		}

		return lines;
	}

	/**
	 * @return the switchable
	 */
	public boolean isSwitchable() {
		return switchable;
	}

	/**
	 * @param switchable
	 *            the switchable to set
	 */
	public void setSwitchable(boolean switchable) {
		this.switchable = switchable;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	private int height;
	private boolean isthinking;

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX
	 *            the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY
	 *            the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the isthinking
	 */
	public boolean isIsthinking() {
		return isthinking;
	}

	/**
	 * @param isthinking
	 *            the isthinking to set
	 */
	public void setIsthinking(boolean isthinking) {
		this.isthinking = isthinking;
	}

	public InstructionTutor() {
		// default constructor

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getIns_shape() {
		return this.ins_shape;
	}

	public String getIns_text() {
		return this.ins_text;
	}

	public void setIns_shape(String ins_shape) {
		this.ins_shape = ins_shape;
	}

	public void setIns_text(String ins_text) {
		this.ins_text = ins_text;
	}

	public static void main(String[] args) {
		InstructionTutor obj = new InstructionTutor();
		obj.getCount();
	}
}
