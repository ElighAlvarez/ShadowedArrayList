public class ShadowedArrayTester {
  public static void main(String[] args) {
    runAllTests();
  }

  public static void runAllTests() {
    testAdd();
  }

  public static void testAdd() {
    ShadowedArrayList<Integer> shadow = new ShadowedArrayList<>(1);
    shadow.add(1);
    shadow.add(2);
    shadow.add(3);
    shadow.add(4);
    System.out.print(shadow);
  }
}