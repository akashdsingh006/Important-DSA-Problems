class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    int i=0,j=m-1;
	    while(i<n && j>=0)
	    {
	        if(matrix[i][j]==x)
	            return true;
	        else if(matrix[i][j]<x)
	            i++;
	        else
	            j--;
	    }
	    return false;
	} 
}
