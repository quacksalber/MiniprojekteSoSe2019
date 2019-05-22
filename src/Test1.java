import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{3,4,5},{2,3,4},{3,4,6}};
		System.out.println("Array hat: \n" + Arrays.deepToString(array));
		System.out.println("Ergebnis: \n" + Arrays.toString(summeA(array)));
	}
	
	
	public static int[] summeA(int[][] array) {
		int[] sum = new int[array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum[i] += array[i][j];
			}
		}

		return sum;
	}

}
