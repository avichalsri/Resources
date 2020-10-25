#include<GL/glut.h>

void display()
{
	glClear(GL_COLOR_BUFFER_BIT);
	
	    glColor3f(1.0f, 1.0f, 1.0f);
	glBegin(GL_LINES);
	    glVertex2f(100, 100);
	    glVertex2f(400, 400);
	glEnd();
	
	glFlush();
	glutSwapBuffers();
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA);
	glutInitWindowSize(640,640);
	glutCreateWindow("");
	glutDisplayFunc(display);
	gluOrtho2D(0,640,0,640);
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glutMainLoop();
	return 0;
}
