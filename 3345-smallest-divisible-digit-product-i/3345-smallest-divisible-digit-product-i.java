class Solution {
    public int smallestNumber(int n, int t) {
        int i;
        for( i=n;i<=100;i++)
        {  
            int sum=sum(i);
            if(sum%t==0)
             break;
        }
         return i;
        
    }
    int sum(int i)
    {   int sum =1;
        while(i!=0)
            {
                int r=i%10;
                sum*=r;
                i=i/10;
            }
            return sum;
    }
}