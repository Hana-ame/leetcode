public class AA2 {
  public static void main(String[] args) {
    System.out.println("A");
  }

  public void a(){
    System.out.println("AA.a");
    b();  
  }
  public void b(){
    System.out.println("AA.b");
  }
}