package topcoderProblems;


public class RoboFactory
{
  public int reveal(int[] q, String[] ans)
  {
    int i=0;
    int c=0;
    if(q.length == 1) return 0;
    for(i=1;i<q.length;i++){
      if(q[i-1] %2 != 0){
        String rep=  "";
        if(q[i] %2 == 0)
          rep = "Even";
        else
          rep = "Odd";
        if(!rep.equals(ans[i])){
          return i;
        }
      }
      else{
        c++;
      }
      
    }
    if( c > 0 ) return -1;
    return 0;
    
  }
  
}
