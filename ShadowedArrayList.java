/**
 * Stores an unsorted lit of items. Utilizes a shadow array to reduce worst-case time complexity
 * of adding an item.
 *
 * @param <T> The type of item to be stored in this ShadowedArrayList
 */
public class ShadowedArrayList<T> {

  private T[] smallArray;
  private T[] largeArray;
  private int size;
  private int shadowIndex;

  public ShadowedArrayList<T>(int initialCapacity) {
    smallArray = new T[initialCapacity];
    largeArray = new T[initialCapacity * 2];
  }

  public ShadowedArrayList<T>() {
    this(10);
  }

  public void add(T item) {
    // If the small array is full we discard it, replace it with the large array, and make a new
    // larger array
    if (size == smallArray.length) {
      smallArray = largeArray;
      largeArray = new T[smallArray.length * 2];
      shadowIndex = 0;
    }

    smallArray[size] = T;
    largeArray[size] = T;
    largeArray[shadowIndex] = smallArray[shadowIndex];

    size++;
    shadowIndex++;
  }

  public T get(int index) {
    if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index is out of "
        + "bounds");
    return smallArray[index];
  }
}