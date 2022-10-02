#include<bits/stdc++.h>


using namespace std;

void printArray(int arr[], int size)  
{  
    int i;  
    for (i=0; i < size; i++)  
        cout << arr[i] << "   ";  
    cout << endl;  
}



int linearsearch(int arr[], int n, int x) 
{ 
    int i; 
    for (i = 0; i < n; i++) 
        if (arr[i] == x) 
            return i; 
    
    return -1; 
}



int binarysearch(int arr[], int l, int r, int x) 
{ 
    if (r >= l) { 
        int mid = l + (r - l) / 2; 
  
        if (arr[mid] == x) 
            return mid; 
  
        if (arr[mid] > x) 
            return binarysearch(arr, l, mid - 1, x); 
  
        return binarysearch(arr, mid + 1, r, x); 
    } 
  
    return -1; 
} 


void selectionSort(int arr[], int n)  
{  
    int i, j, min;  
  

    for (i = 0; i < n-1; i++)  
    {  
        
        min = i;  
        for (j = i+1; j < n; j++)  
        if (arr[j] < arr[min])  
            min = j;  
    
        swap(arr[min], arr[i]);  
    }  
}


void bubbleSort(int arr[], int n)  
{  
    int i, j;  
    for (i = 0; i < n-1; i++)      
      

    for (j = 0; j < n-i-1; j++)  
        if (arr[j] > arr[j+1])
		{
			swap(arr[j], arr[j+1]);
//			printArray(arr,8); 
		}  
             
}  




void merge(int arr[], int l, int m, int r) 
{ 
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 
  
    /* create temp arrays */
    int L[n1], R[n2]; 
  
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
  
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = l; // Initial index of merged subarray 
    while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            arr[k] = L[i]; 
            i++; 
        } 
        else
        { 
            arr[k] = R[j]; 
            j++; 
        } 
        k++; 
    } 
  
    /* Copy the remaining elements of L[], if there 
       are any */
    while (i < n1) 
    { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 
  
    /* Copy the remaining elements of R[], if there 
       are any */
    while (j < n2) 
    { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 
  
/* l is for left index and r is right index of the 
   sub-array of arr to be sorted */
void mergeSort(int arr[], int l, int r) 
{ 
    if (l < r) 
    { 
        // Same as (l+r)/2, but avoids overflow for 
        // large l and h 
        int m = l+(r-l)/2; 
  
        // Sort first and second halves 
        mergeSort(arr, l, m);

        mergeSort(arr, m+1, r);

  
        merge(arr, l, m, r);
//		printArray(arr,8); 
    } 
} 



int partition (int arr[], int low, int high)  
{  
    int pivot = arr[high]; // pivot  
    int i = (low - 1); // Index of smaller element  
  
    for (int j = low; j <= high - 1; j++)  
    {  
        // If current element is smaller than the pivot  
        if (arr[j] < pivot)  
        {  
            i++; // increment index of smaller element  
            swap(arr[i], arr[j]);  
        }  
    }  
    swap(arr[i + 1], arr[high]);  
    return (i + 1);  
}  
  
/* The main function that implements QuickSort  
arr[] --> Array to be sorted,  
low --> Starting index,  
high --> Ending index */
void quickSort(int arr[], int low, int high)  
{  
    if (low < high)  
    {  
        /* pi is partitioning index, arr[p] is now  
        at right place */
        int pi = partition(arr, low, high);  
  
        // Separately sort elements before  
        // partition and after partition  
        quickSort(arr, low, pi - 1);  
        quickSort(arr, pi + 1, high);  
    }  
} 





void heapify(int arr[], int n, int i) 
{ 
    int largest = i; // Initialize largest as root 
    int l = 2*i + 1; // left = 2*i + 1 
    int r = 2*i + 2; // right = 2*i + 2 
  
    // If left child is larger than root 
    if (l < n && arr[l] > arr[largest]) 
        largest = l; 
  
    // If right child is larger than largest so far 
    if (r < n && arr[r] > arr[largest]) 
        largest = r; 
  
    // If largest is not root 
    if (largest != i) 
    { 
        swap(arr[i], arr[largest]); 
  
        // Recursively heapify the affected sub-tree 
        heapify(arr, n, largest); 
    } 
} 
  
// main function to do heap sort 
void heapSort(int arr[], int n) 
{ 
    // Build heap (rearrange array) 
    for (int i = n / 2 - 1; i >= 0; i--) 
        heapify(arr, n, i); 
  
    // One by one extract an element from heap 
    for (int i=n-1; i>0; i--) 
    { 
        // Move current root to end 
        swap(arr[0], arr[i]); 
  
        // call max heapify on the reduced heap 
        heapify(arr, i, 0); 
    } 
} 




int main()
{
	int arr1[15]={1,3,4,6,9,10,16,20,22,26,30,50,51,55,60}; // binary search sorted array
	
	int arr2[8]={38,27,43,3,9,82,10};
	
	int arr3[6]={10, 7, 8, 9, 1, 5}; //quicksort
	int arr4[6]={12, 11, 13, 5, 6, 7};
//	cout<<linearsearch(arr1,15,10)<<endl;

	cout<<binarysearch(arr1,0,14,5)<<endl;
	
	
//	selectionSort(arr2, 8);
//	printArray(arr2,8);
	
//	bubbleSort(arr2, 8);
//	printArray(arr2,8);
	
//	mergeSort(arr2,0,7);
//	printArray(arr2,8);

//	quickSort(arr3,0,5);
//	printArray(arr3,6);
	
//	heapSort(arr4,6);
//	printArray(arr4,6);
	
	
	
	
	
	
}
