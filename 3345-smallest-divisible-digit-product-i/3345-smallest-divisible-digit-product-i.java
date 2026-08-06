class Solution {
    public int smallestNumber(int n, int t) {
        int i;
        for( i=n;i<=100;i++)
        {  
            int pro=pro(i);
            if(pro%t==0)
             break;
        }
         return i;
        
    }
    int pro(int i)
    {   int pro =1;
        while(i!=0)
            {
                int r=i%10;
                pro*=r;
                i=i/10;
            }
            return pro;
    }
}