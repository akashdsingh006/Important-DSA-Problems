
class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        //Arrays.sort(A);
        int low=0;
        int high=0;
        if(M>N)return -1;
        for(int i:A)
        {
            high+=i;
        }
        int res=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(isAllocationPossibble(mid,A,M))
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
    public static boolean isAllocationPossibble(int mid,int[]arr,int students)
    {
        int page=0,allocatedStu=1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>mid)
                return false;
            if(arr[i]+page>mid)
            {
                allocatedStu+=1;
                page=arr[i];
            }
            else
                page+=arr[i];
        }
        if(allocatedStu>students)
            return false;
        
        return true;
    }
    }
