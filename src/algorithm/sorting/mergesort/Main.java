package algorithm.sorting.mergesort;


public class Main {
	public static void main(String[] args) {
		int[] arr = { 12, 34, 999, 32/*, 3, 45, 555, 333, 1, 6, 212 */};
		MergeSort mSort = new MergeSort();
		mSort.sort(arr);
		/*for (int i : arr) {
			System.out.print("\t" + i);
		}*/
	}

}
