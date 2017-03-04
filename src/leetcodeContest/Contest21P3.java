package leetcodeContest;


public class Contest21P3 {
  
  public static boolean checkSubarraySum(int[] nums, int k) {
    int sum = 0;
    int i,j;
    int n = nums.length;
    if(n<2) return false;
    boolean flag = true;
    for(i=0;i<n;i++){
        sum = nums[i];
        for(j=i+1;j<n;j++){
           sum += nums[j];
           if(j-i+1 >= 2){
             if(sum ==0 && k==0) return true;
             else if( k !=0  && sum % k == 0 ) return true;
             }
        }
        
    }
    return false;
}
  
  public static void main(String[] args) {
    int[] nums = {18,373,97,499,525,170,133,376,77,279,257,168,319,335,237,36,236,41,360,131,172,279,405,236,296,377,348,411,135,411,273,230,103,274,211,427,101,243,31,485,282,40,28,81,6,318,502,521,140,110,467,248,404,107,108,129,113,113,333,83,242,194,112,446,463,102,145,107,73,47,53,455,301,150,314,13,180,119,234,509,199,503,69,224,228,427,309,497,342,329,518,35,425,343,417,509,85,234,426,334};
    int k = 250;
    System.out.println(checkSubarraySum(nums,k));
  }

}
