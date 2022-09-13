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

  /**
   * Creates a ShadowedArrayList with the specified capacity.
   * @param initialCapacity The initial capacity.
   */
  public ShadowedArrayList(int initialCapacity) {
    smallArray = (T[])(new Object[initialCapacity]); // Empty array can be safely cast to T
    largeArray = (T[])(new Object[initialCapacity * 2]); // Empty array can be safely cast to T
  }

  /**
   * Creates a ShadowedArrayList with a default capacity of 10.
   */
  public ShadowedArrayList() {
    this(10);
  }

  /**
   * Adds a specified element to the end of this ShadowedArrayList
   * @param item The element to be added to this ShadowedArrayList
   */
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

  /**
   * Adds a specified element to this ShadowedArrayList at a specified index.
   * @param item The element to add
   * @param index The index at which to add item
   */
  public void add(T item, int index) {
    // TODO: Implement this
  }

  /**
   * Removes and returns the element at the specified index.
   * @param index The index of the element to be removed.
   * @return The element at the specified index
   */
  public T remove(int index) {
    // TODO: Implement this
    return null; // stub
  }

  /**
   * Sets the specified index to the provided element. Replaces the existing element if index is
   * not the end of the list.
   * @param index The index to set.
   * @param newItem The new element.
   */
  public void set(int index, T newItem) {
    // TODO: Implement this
  }

  /**
   * Returns the element at the provided index.
   * @param index The index of the element to retrieve.
   * @return The element at the provided index.
   */
  public T get(int index) {
    if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index is out of "
        + "bounds");
    return smallArray[index];
  }

  /**
   * Returns a String representation of this. The output contains both full arrays.
   * @return a String representation of this.
   */
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