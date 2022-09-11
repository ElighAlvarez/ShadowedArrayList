import java.util.ArrayList;

/**
 * Stores an unsorted list of items. Utilizes a shadow array to reduce worst-case time complexity
 * of adding an item.
 *
 * @param <T> The type of item to be stored in this ShadowedArrayList
 */
public class ShadowedArrayList<T> {
  ArrayList<Integer> intArray = new ArrayList<>();

  private T[] smallArray;
  private T[] largeArray;
  private int size;
  private int shadowIndex;

  public ShadowedArrayList(int initialCapacity) {
    smallArray = (T[])(new Object[initialCapacity]); // Empty array can be safely cast to T
    largeArray = (T[])(new Object[initialCapacity * 2]); // Empty array can be safely cast to T
  }

  public ShadowedArrayList() {
    this(10);
  }

  public void add(T item) {
    // If the small array is full we discard it, replace it with the large array, and make a new
    // larger array
    if (size == smallArray.length) {
      smallArray = largeArray;
      largeArray = (T[])(new Object[smallArray.length * 2]); // Empty array can be safely cast to T
      shadowIndex = 0;
    }

    smallArray[size] = item;
    largeArray[size] = item;
    largeArray[shadowIndex] = smallArray[shadowIndex];

    size++;
    shadowIndex++;
  }

  public T get(int index) {
    if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index is out of "
        + "bounds");
    return smallArray[index];
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    for (int i = 0; i < smallArray.length; i++) {
      if (smallArray[i] == null) builder.append("null");
      else builder.append(smallArray[i].toString());
      builder.append(", ");
    }

    builder.delete(builder.length() - 2, builder.length());
    builder.append("]\n[");

    for (int i = 0; i < largeArray.length; i++) {
      if (largeArray[i] == null) builder.append("null");
      else builder.append(largeArray[i].toString());
      builder.append(", ");
    }

    builder.delete(builder.length() - 2, builder.length());
    builder.append(']');

    return builder.toString();
  }
}