public class ShadowedArrayTester {
  public static void main(String[] args) {
    runAllTests();
  }

  public static void runAllTests() {
    testAdd();
  }

  public static void testAdd() {
    ShadowedArrayList<Integer> shadow = new ShadowedArrayList<>(1);
    for (int i = 0; i < 10; i++) {
      shadow.add(i);
      System.out.println(shadow + "\n");
    }
  }
}