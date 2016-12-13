package codeforces;


public final class Test4 {
 
  private boolean flag = true;
  class Inner{
    void test(){
      if (Test4.this.flag){
        sample();
      }
    }
  }
  
  public void sample(){
    System.out.println("Sample");
  }
  public Test4(){
    (new Inner()).test();
  }
  
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    new Test4();
  }

}
