public class A2 extends AA2 {
  public static void main(String[] args) {
    System.out.println("A");
    A2 a = new A2();
    a.a();
  }
  public void b() {
    System.out.println("A.b");
    // b();  
  }
}