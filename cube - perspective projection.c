#include <GL/glut.h> 
#include <stdlib.h> 
GLint faces[6][4] = { {0, 1, 2, 3}, {3, 2, 6, 7}, {7, 6, 5, 4}, {4, 5, 1, 0}, {5, 6, 2, 1}, {7, 4, 0, 3} }; 
GLfloat v[8][3];  

void init(void) { 
	glClearColor (0.0, 0.0, 0.0, 0.0);
	v[0][0] = v[1][0] = v[2][0] = v[3][0] = -1; 
	v[4][0] = v[5][0] = v[6][0] = v[7][0] = 1; 
	v[0][1] = v[1][1] = v[4][1] = v[5][1] = -1; 
	v[2][1] = v[3][1] = v[6][1] = v[7][1] = 1;
	v[0][2] = v[3][2] = v[4][2] = v[7][2] = -4; 
	v[1][2] = v[2][2] = v[5][2] = v[6][2] = -6;
}

void drawBox(void) { 
	int i; 
	for (i = 0; i < 6; i++) { 
		glBegin(GL_LINE_LOOP); 
			glVertex3fv(&v[faces[i][0]][0]); 
			glVertex3fv(&v[faces[i][1]][0]); 
			glVertex3fv(&v[faces[i][2]][0]); 
			glVertex3fv(&v[faces[i][3]][0]); 
		glEnd();
	}
} 

void display(void) { 
	glClear (GL_COLOR_BUFFER_BIT); 
	glColor3f (1.0, 1.0, 1.0); 
	drawBox(); 
	glFlush (); 
}

void reshape (int w, int h) {
	glViewport (0, 0, (GLsizei) w, (GLsizei) h); 
	glLoadIdentity (); 
	glMatrixMode (GL_PROJECTION); 
	gluPerspective(60.0,(GLfloat)w/(GLfloat)h, 1.0, 20.0); 
}

void keyboard(unsigned char key, int x, int y) { 
	switch (key) { 
		case 27: 
			exit(0); 
			break; 
	} 
}
int main(int argc, char** argv) { 
	glutInit(&argc, argv); 
	glutInitDisplayMode (GLUT_SINGLE | GLUT_RGB); 
	glutInitWindowSize (500, 500); 
	glutInitWindowPosition (100, 100); 
	glutCreateWindow ("cube - perspective projection"); 
	init (); 
	glutDisplayFunc(display); 
	glutReshapeFunc(reshape); 
	glutKeyboardFunc(keyboard); 
	glutMainLoop(); 
	return 0; 
}

