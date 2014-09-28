/* This file is part of VoxelGale
 * 
 * Copyright (c) 2014 jacklin213
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tk.jacklin213.voxelgale.rendering;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/**
 *	Used for basic rendering
 */
public class BasicRenderer {

	private DisplayMode displayMode;
	
	public void start() {
		try {
			createWindow();
			initGL();
			run();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private void createWindow() throws LWJGLException {
		Display.setFullscreen(false);
		DisplayMode d[] = Display.getAvailableDisplayModes();
		for (int i = 0; i < d.length; i++) {
			if (d[i].getWidth() == 640 && d[i].getHeight() == 480 && d[i].getBitsPerPixel() == 32) {
				displayMode = d[i];
				break;
			}
		}
		Display.setDisplayMode(displayMode);
		Display.setTitle("VoxelGale - Made by jacklin213 using LWJGL");
		Display.create();
	}
	
	private void initGL() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glClearColor(0, 0, 0, 0);
		GL11.glClearDepth(1);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		
		GLU.gluPerspective(45, (float)displayMode.getWidth()/(float)displayMode.getHeight(), 0.1f, 100);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}
	
	private void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
		
		GL11.glTranslatef(-3f, 0.0f, -20f);
		GL11.glRotatef(45f, 0.4f, 1.0f, 0.1f);
		GL11.glColor3f(0.5f, 0.5f, 1.0f);
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				for (int z = 0; z < 3; z++) {
					renderCube();
					GL11.glTranslatef(0, 0, 2);
				}
				GL11.glTranslatef(0, 2, -6);
			}
			GL11.glTranslatef(2, -6, 0);
		}
	}
	
	private void renderCube() {
		// Cube GL11.glBegin(GL11.GL_QUADS);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		//Bellow code renders the quad
		//Render start
		GL11.glColor3f(1.0f, 1.0f, 0.0f);
		GL11.glVertex3f( 1.0f, 1.0f,-1.0f);        
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);        
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
        
        GL11.glColor3f(1.0f,0.5f,0.0f);            
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
        
        GL11.glColor3f(1.0f,0.0f,0.0f);
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
        
        GL11.glColor3f(1.0f,1.0f,0.0f);
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
        
        GL11.glColor3f(0.0f,0.0f,1.0f);
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
        
        GL11.glColor3f(1.0f,0.0f,1.0f);
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
		//Render end
		GL11.glEnd();
	}
	
	private void run() {
		while(!Display.isCloseRequested()) {
			render();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}

}
