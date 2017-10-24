package venkat;

import java.util.Scanner;

public class Pro19_SubMatrixWithAllOnes {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number of Rows : ");
		int r = in.nextInt();
		System.out.println("Enter Number of Columns : ");
		int c = in.nextInt();
		int a[][] = new int[r][c];
		int result[][] = null;

		System.out.println("Enter The Elements : ");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = in.nextInt();
			}
		}

		in.close();
		int k = a.length;

		OUTER: while (k > 1) {
			int l = 0;
			while (l <= a[0].length - k) { // moving towards right
				int p = 0;
				while (p <= a.length - k) { // moving towards bottom
					int m = 0;
					int temp[][] = new int[k][k];
					int l1 = 0;

					for (int i = p; i < k + p; i++) {
						int l2 = 0;
						for (int j = l; j < k + l; j++) {
							temp[l1][l2] = a[i][j];
							m += a[i][j];
							l2++;
						}
						l1++;
					}
					if (m == k * k) {
						result = temp; // array copying
						break OUTER;
					}
					p++;
				}
				l++;
			}
			k--;
		}
		System.out.println("The Maximum Sub Matrix : ");

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

}