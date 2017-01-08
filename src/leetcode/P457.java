package leetcode;

public class P457 {
  
  
    public boolean circularArrayLoop(int[] nums) {
       
       if(nums==null || nums.length==0)
            return false;
            
       while(true)
       {
           int startindex = FindIndex(nums, nums.length);
           if(startindex == -1)
              return false;
              
           if(HasLoop(nums, nums.length, startindex))
              return true;
       }
       
    }
    
    public boolean HasLoop(int[] nums, int len, int startindex)
    {
       int dir = 0; //1 forward, -1 backward, 0 no-direction yet
       int index = startindex;
           
       while(index >= 0 && index < len)
       {
           if(dir != 0 && startindex == index)
              return true;
              
            int ndir = nums[index] > 0 ? 1 : -1;
            int newindex = (index + nums[index]) % len;
            if(newindex < 0) //handle negative
                newindex += len;
            
            if(newindex == index)
            {
                nums[index] = 0; //mark visisted to prevent infite loop
                break;
            }
            else if(dir!=0 && dir!=ndir)
            {
                break;
            }
            else
            {
                nums[index] = 0; //mark visisted
                index = newindex;
                dir = ndir;
            }
       }
       
       return false;
    }
    
    public int FindIndex(int[] nums, int len)
    {
        for(int i=0; i<len; i++)
        {
            if(nums[i] != 0)
                return i;
        }
        return -1;
    }
}