import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Tests {

    static ArrayList<Integer> createRandomArray(int size) {
        Random rand = new Random();

        ArrayList<Integer> array = new ArrayList<Integer>();
    
        for (int i = 0; i < size; i++) {
            array.add(rand.nextInt(9) + 1);
        }
    
        return array;
    }

    @Test
    public void selectionSort() {

        ArrayList<Integer> array = createRandomArray(10);

        ArrayList<Integer> actual = App.selectionSort(array);

        Collections.sort(array); //expected array

        Assert.assertEquals(array, actual);
    }

    @Test
    public void bubbleSort() {

        ArrayList<Integer> array = createRandomArray(10);

        ArrayList<Integer> actual = App.bubbleSort(array);

        Collections.sort(array); //expected array

        Assert.assertEquals(array, actual);
    }

    @Test
    public void insertionSort() {

        ArrayList<Integer> array = createRandomArray(10);

        ArrayList<Integer> actual = App.insertionSort(array);

        Collections.sort(array); //expected array

        Assert.assertEquals(array, actual);
    }

    @Test
    public void mergeSort() {

        ArrayList<Integer> array = createRandomArray(10);

        ArrayList<Integer> actual = App.mergeSort(array, 0, array.size() - 1);

        Collections.sort(array); //expected array

        Assert.assertEquals(array, actual);
    }

}
