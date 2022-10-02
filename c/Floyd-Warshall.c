// Program to implement Floyd-Warshall Algorithm in C
#include <stdio.h>
#include <stdlib.h>

// defining the number of vertices
void printMatrix(int matrix[20][20],int n);

// Implementing floyd warshall algorithm
void floydWarshall(int cost[20][20],int n) {
  int matrix[20][20], i, j, k;

  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      matrix[i][j] = cost[i][j];

  // Adding vertices individually
  for (k = 0; k < n; k++) {
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (matrix[i][k] + matrix[k][j] < matrix[i][j])
          matrix[i][j] = matrix[i][k] + matrix[k][j];
      }
    }
  }
  printMatrix(matrix,n);
}

void printMatrix(int matrix[20][20],int n) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (matrix[i][j] == 999)
        printf("%4s", "INF");
      else
        printf("%4d", matrix[i][j]);
    }
    printf("\n");
  }
}

int main() 
{
  int cost[20][20],i,j,n;
  printf("enter the number of vertices");
  scanf("%d",&n);
  printf("enter the matrix\n");
  for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
      {
      scanf("%d",&cost[i][j]);
      }
   }
  floydWarshall(cost,n);
}
