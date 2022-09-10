public class ShadowedArrayTester {
  public static void main(String[] args) {
    runAllTests();
  }

  public static void runAllTests() {
    testAdd();
  }

  public static void testAdd() {
    shadow = new ShadowedArrayList<Integer>();
  }
}