package Pro_2;

import java.util.Scanner;

public class P16 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Number Of Students : ");
		int n = in.nextInt();
		int rating[] = new int[n];
		System.out.println("Enter The Students Rating : ");
		for (int i = 0; i < n; i++) {
			rating[i] = in.nextInt();
		}
		in.close();
		System.out.println("The Minimum Number Of Chocolates Required For Students Are : ");
		System.out.println(candies(rating));
	}

	public static int candies(int a[]) {
		int ar[] = new int[a.length];
		int tot[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			ar[i] = 1;
		}
		tot = candiesPutting(a, ar);
		int totalCandies = 0;
		for (int i = 0; i < tot.length; i++) {
			totalCandies += tot[i];
		}
		return totalCandies;
	}

	public static int[] candiesPutting(int a[], int ar[]) {
		while (!candiesChecker(a, ar)) {
			for (int i = 0; i < a.length; i++) {
				if (i == 0) {
					if (a[i] > a[i + 1]) {
						if (ar[i] <= ar[i]) {
							ar[i]++;
						}
					}
				} else if (i == a.length - 1) {
					if (a[i] > a[i - 1]) {
						if (ar[i] <= ar[i - 1]) {
							ar[i]++;
						}
					}
				} else {
					if (a[i] > a[i - 1]) {
						if (ar[i] <= ar[i - 1]) {
							ar[i]++;
						}
					}
					if (a[i] > a[i + 1]) {
						if (ar[i] <= ar[i + 1]) {
							ar[i]++;
						}
					}
				}
			}
		}
		return ar;
	}

	public static boolean candiesChecker(int a[], int ar[]) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (i == 0) {
				if (a[i + 1] < a[i]) {
					if (ar[i + 1] < ar[i]) {
						count++;
					}
				} else {
					count++;
				}
			} else if (i == ar.length - 1) {
				if (a[i] > a[i - 1]) {
					if (ar[i] > ar[i - 1]) {
						count++;
					}
				} else {
					count++;
				}
			} else {
				if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
					if (ar[i] > ar[i - 1] && ar[i] > ar[i + 1]) {
						count++;
					}

				} else {
					count++;
				}
			}
		}
		if (count == ar.length) {
			return true;
		} else {
			return false;
		}
	}
}