import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;

public class ArraySortTest {
	
	static ArrayList<int[]> holder = new ArrayList<int[]>();
	static Random random = new Random();
	static int randomElement;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for(int i = 0; i < 200; i++){
			int[] array = new int[random.nextInt(951) + 50]; //range is 50-1000
			for(int j = 0; j < array.length; j++){
				randomElement = random.nextInt(1000) + 1;//range is 1-1000
				array[j] = randomElement;
			}
			holder.add(array);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        holder.clear();
        System.gc();
	}

	@Test
	public void sizeTest() { //the unsorted array and the sorted array should have the same size
		boolean test = true;
		int[] array;
		int size;
		int sortSize;
		for(int i = 0; i < 50; i++){
			array = holder.get(i);
			size = array.length;
			Arrays.sort(array);
			sortSize = array.length;
			if (size != sortSize){
				test = false;
			}
		}
		assertTrue(test);
	}
	
	@Test
	public void increaseElementTest() { //nth element in the array should less than or equal to n+1th element
		boolean test = true;
		int[] array;
		int size;
		for(int i = 0; i < 50; i++){
			array = holder.get(i);
			size = array.length;
			Arrays.sort(array);
			for(int j = 0; j < size - 1; j++){
				if (array[j] > array[j+1]){
					test = false;
				}
			}
			
		}
		assertTrue(test);
	}
	
	@Test
	public void sameResultTest() { //sorting the array twice should produce the same results
		boolean test = true;
		int[] array;
		int[] array2;
		for(int i = 0; i < 50; i++){
			array = holder.get(i);
			array2 = holder.get(i);
			Arrays.sort(array);
			Arrays.sort(array2);
			if (!Arrays.equals(array, array2)){
				test = false;
			}
		}
		assertTrue(test);
	}

}
