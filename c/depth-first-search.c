/// PROGRAM TO PRINT DFS TRAVERSAL FROM GIVEN SOURCE VERTEX

#include <stdio.h>
#include <stdlib.h>

/// We are going to define some global variables as it involves recursion
/// Variable to hold the number of vertices
int v = 5;

/// Variable to hold the graph as matrix
/// Variable to hold the graph as matrix
    int m[10][10] =
                    {
                        {0, 1, 1, 0, 0},
                        {1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 0}
                    };


/// Variable to hold source vertex
int source = 4;

/// Array to maintain the visited vertices
int visited[10];

/*
Funtion Name: dfs
Input Params: Graph input as matrix, number of vertices and source vertex
Return Type:  void
Description:  performs dfs traversal on the given graph
*/
void dfs(int m[10][10], int v, int source)
{
    /// Temporary variable
    int i;

    /// Mark the source vertex as visited
    visited[source] = 1;

    for(i=0; i<v; i++)
    {
        if(m[source][i] == 1 && visited[i] == 0)
        {
            printf("%d\t", i);
            dfs(m, v, i);
        }
    }
}

int main()
{
    /// Index variables
    int i;

    /// Set all the vertices to not visited
    for (i= 0; i < v; i ++)
        visited[i] = 0;

    /// Call the dfs traversal
    printf("The DFS Traversal is... \n");
    printf("%d\t", source);
    dfs(m, v, source);

    return 0;
}
