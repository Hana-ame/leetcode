public class Bb {
  static class SBb {
    public static void main(String[] args) {
      System.out.println("SB");
    }
  }
  class BBb {
    public void main(){
      System.out.println("BB");
    }
  }
  public static void main(String[] args) {
    Bb b = new Bb();
    System.out.println("B");
    SBb.main(args);
    BBb bb = b.new BBb();
    bb.main();
  }
}