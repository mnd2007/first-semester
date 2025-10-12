public class ArrayUtils {
    public static <T> int findFirst(T[] array, T element) {
        if (array == null) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (element == null) {
                if (array[i] == null) {
                    return i;
                }
            } else {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final String[] names = {"Alice", "Bob", "Charlie"};
        final int index = ArrayUtils.findFirst(names, "Bob");
        System.out.println("Index of 'Bob': " + index);
        final String[] withNull = {"Alice", null, "Charlie"};
        System.out.println("Index of null: " + ArrayUtils.findFirst(withNull, null));
        System.out.println("Search in null array: " + ArrayUtils.findFirst(null, "test"));
        System.out.println("Search null in array: " + ArrayUtils.findFirst(names, null));
    }
}