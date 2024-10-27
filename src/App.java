import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class App {

    Scanner input;
    int userOption, arraySize;
    boolean runProgram;

    public App() {
        arraySize = 10;
        runProgram = true;
        input = new Scanner(System.in); 
    }
    public static void main(String[] args) throws Exception {

        App object = new App();

        System.out.println("Sorting Algorithm Visualizer");
        System.out.println("--------------------------------------------");

        ArrayList<Integer> array = createRandomArray(object.arraySize);

        printHistogram(array);

        while (object.runProgram) {

            System.out.println("Select an option:");
            System.out.println("[1] Randomize array");
            System.out.println("[2] Resize array");
            System.out.println("[3] Selection sort");
            System.out.println("[4] Bubble sort");
            System.out.println("[5] Insertion sort");
            System.out.println("[6] Merge sort");
            System.out.println("[7] Exit program");
    
            object.userOption = object.input.nextInt();
    
            switch(object.userOption) {
                case 1:
                    array = createRandomArray(object.arraySize);
                    printHistogram(array);
                    break;
    
                case 2:
                    System.out.print("Array size: ");
                    object.arraySize = object.input.nextInt();
    
                    array = createRandomArray(object.arraySize);
                    
                    printHistogram(array);
                    break;
    
                case 3:
                    array = selectionSort(array);
                    break;
    
                case 4:
                    bubbleSort(array);
                    break;
    
                case 5:
                    insertionSort(array);
                    break;
    
                case 6:
                    mergeSort(array, 0, object.arraySize - 1);
                    break;
    
                case 7:
                    object.runProgram = false;
                    break;
    
            }
        }

        System.out.println("Exiting");
        object.input.close();
    }

    static boolean isSorted(ArrayList<Integer> array) {
        ArrayList<Integer> sortedArray = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            sortedArray.add(array.get(i));
        }

        Collections.sort(sortedArray);

        if (array.equals(sortedArray)) {
            return true;
        }

        return false;

    }

    static void printArray(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
        }
    }

    static void printHistogram(ArrayList<Integer> array) {

        try {
            Thread.sleep(500);
        } catch (Exception ignore) {}

        int maxIndex = 0;
        for (int i = 1; i < array.size(); i++) {

            if (array.get(i) > array.get(maxIndex)) {
                maxIndex = i;
            }

        }
    
        int biggestNum = array.get(maxIndex);

        System.out.print("\n");
    
        for (int i = biggestNum; i > 0; i--) {

            for (int j = 0; j < array.size(); j++) {

                if (array.get(j) >= i) {
                    
                    System.out.print("O ");
                    
                }
                
                else {
                    System.out.print("  ");
                }
                
            }
            System.out.print("\n");
        }

        for (int i = 0; i < array.size(); i++) {
            System.out.print("--");
        }

        System.out.print("\n");
    }

    static ArrayList<Integer> selectionSort(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int minIndex = i;
    
            for (int j = i + 1; j < array.size(); j++) {
    
                if (array.get(j) < array.get(minIndex)) {
                    minIndex = j;
                }
    
            }
            if (i != minIndex) {

                Collections.swap(array, i, minIndex);
            }
            
            printHistogram(array);

            if (isSorted(array)) {
                return array;
            }
        }

        return array;
    }

    static ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {

            for (int j = 0; j < array.size() - 1; j++) {

                if (array.get(j) > array.get(j + 1)) {
                    Collections.swap(array, j, j + 1);

                }

                printHistogram(array);

                if (isSorted(array)) {
                    return array;
                }
            }
        }

        return array;
    }

    static ArrayList<Integer> insertionSort(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;
    
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, key);

            printHistogram(array);

            if (isSorted(array)) {
                return array;
            }
        }

        return array;
    }

    static void merge(ArrayList<Integer> array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
    
        ArrayList<Integer> L = new ArrayList<>(n1);
        ArrayList<Integer> R = new ArrayList<>(n2);

    
        for (int i = 0; i < n1; i++) {
            L.add(array.get(left + i));
        }
    
        for (int i = 0; i < n2; i++) {
            R.add(array.get(middle + 1 + i));
        }
    
        int i = 0, j = 0, k = left;
    
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                array.set(k, L.get(i));
                i++;
            } else {
                array.set(k, R.get(j));
                j++;
            }
            k++;
        }
    
        while (i < n1) {
            array.set(k, L.get(i));
            i++;
            k++;
        }
    
        while (j < n2) {
            array.set(k, R.get(j));
            j++;
            k++;
        }
    }

    static ArrayList<Integer> mergeSort(ArrayList<Integer> array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            printHistogram(array);

            merge(array, left, middle, right);
    
            printHistogram(array);

        }

        return array;
    }


    static ArrayList<Integer> createRandomArray(int size) {
        Random rand = new Random();

        ArrayList<Integer> array = new ArrayList<Integer>();
    
        for (int i = 0; i < size; i++) {
            array.add(rand.nextInt(9) + 1);
        }
    
        return array;
    }
}
