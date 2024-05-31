public class ArrayAccessExample {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };
        int index = 10; 

        try {
            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Invalid index. The array does not have an element at index " + index);
        }
    }
}
