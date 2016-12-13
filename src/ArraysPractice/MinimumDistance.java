package ArraysPractice;

import java.util.Stack;



class Food {
  
  public void serveFood(){
    System.out.println("I am serving Food");
  }
}

class FastFood extends Food{
  @Override 
  public void serveFood(){
    System.out.println("I am serving FastFood");
  }
}


class Fruit extends Food{
  
  @Override 
  public void serveFood(){
    System.out.println("I am serving Fruit");
  }
}
class FoodFactory extends Food {
 
     public Food getFood(String foodType){
           if(foodType.equalsIgnoreCase("FastFood")){
             return new FastFood();
           }
           if(foodType.equalsIgnoreCase("Fruit")){
             return new Fruit();
           }
           return null;
     }
}

//{}[]()
public class MinimumDistance
{
  
  static String[] braces(String[] values) {
    String[] ans= new String[values.length];
     int i;
     for(i=0;i<values.length;i++){
         String s1 = values[i];
         Stack<Character> s = new Stack<Character>();
         for(int j=0;j<s1.length();j++){
            if(s.isEmpty()){
              s.push(s1.charAt(j));
            }else{
                char ch  = s.peek();
                if( (ch == '(' && s1.charAt(j) == ')')  || (ch == '{' && s1.charAt(j) == '}') || (ch == '[' && s1.charAt(j)== ']') ){
                   s.pop();
                }else{
                  s.push(s1.charAt(j));
                }
            }
         }
         if(s.isEmpty()) {
             ans[i]  = "YES";  
         }else{
           ans[i] = "NO";
         }
     }
     return ans;

 }

    int minDist(int arr[], int n, int x, int y) 
    {
      
      Stack<Character> s = new Stack<Character>();
      
      
        int ans = 9999;
        int i = -1;//for x
        int j= -1 ; //for y
        for(int k=0;k<n;k++){
          if(arr[k] == x){
            i = k;
          }
          if(arr[k] == y){
            j = k;
          }
          if(i != -1 && j != -1){
            ans = Math.min(Math.abs(j-i), ans);
          }
        }
        return ans;
    }
 
    /* Driver program to test above functions */
    public static void main(String[] args) {
        MinimumDistance min = new MinimumDistance();
        System.out.println(min.getClass().getName());
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;
 
        System.out.println("Minimum distance between " + x + " and " + y
                + " is " + min.minDist(arr, n, x, y));
    }
}
