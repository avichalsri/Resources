#include<iostream.h>
#include<conio.h>

void main()
{

   int arr[100],beg,mid,end,i,n,num;

   cout << "\n Enter the size of an array ";
   cin >> n;

   cout << "\n Enter the values in sorted order (asc or desc) \n";

   for(i = 0; i < n;i++)
   {   
       cin >> arr[i];
   }   

  
   /* Initialize beg and end value. */

   beg = 0;
   end = n-1;

   cout << "\n Enter a value to be searched in an array ";
   cin >> num;

   /* Run loop, while beg is less than end. */

   while( beg <= end)
   {   
       
      /* Calculate mid. */
        
      mid = (beg+end)/2;

     /* If value is found at mid index,
        the print the position and exit. */

      if(arr[mid] == num)
      {   
         cout << "\nItem found at position "<< (mid+1);
   
          exit(0);

      } else if(num > arr[mid]) {

         beg=mid+1;

      } else if (num < arr[mid]) {

         end=mid-1;
 
      }

   }

    cout << "Number does not found.";
 }