import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers=generate(1,100,10000);
        mergesort(numbers,0,99);
        display(numbers);
    }

    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(high - low + 1) + low;
        }
        return result;
    }

    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (i = 0; i < temp.length; i++) {
            a[low + i] = temp[i];
        }
    }

    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        if (a.length % 10 != 0) {
            System.out.println();
        }
    }
}