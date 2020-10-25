#include <GL/glut.h> 
#include <stdlib.h> 

void display(void) { 
	glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();
    glColor3f(1.0f, 1.0f, 1.0f);
    glutWireCube(2);
    glFlush();
    
}

void reshape (int w, int h) {
	glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-2.0, 2.0, -2.0, 2.0, -1.5, 1.5);
    
    glMatrixMode(GL_MODELVIEW);
}

int main(int argc, char** argv) { 
	glutInit(&argc, argv); 
	
	glutInitDisplayMode (GLUT_SINGLE | GLUT_RGB); 
	glutInitWindowSize (500, 500); 
	glutInitWindowPosition (100, 100); 
	glutCreateWindow ("cube - orthographic projection"); 
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glShadeModel(GL_FLAT);
	glutDisplayFunc(display); 
	glutReshapeFunc(reshape);   
	glutMainLoop(); 
	return 0; 
}

