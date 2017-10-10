package Pro_2;

import java.util.*;

public class P15 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter The Size of Array : ");
		int n = in.nextInt();
		int a[] = new int[n];
		System.out.println("Enter The Elements : ");
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		int s[] = descendingOrder(a);
		System.out.println("The Sorted Array : ");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}

	}

	public static int[] descendingOrder(int a[]) {
		int count[] = new int[a.length];
		String bin[] = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			String binary = "";
			int t = a[i];
			int c = 0;
			while (t != 0) {
				if (t % 2 == 1) {
					c++;
				}
				binary += t % 2;
				t /= 2;
			}
			count[i] = c;
			bin[i] = reversingString(binary);
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (count[i] < count[j]) {
					int t = count[i];
					count[i] = count[j];
					count[j] = t;
					t = a[i];
					a[i] = a[j];
					a[j] = t;
					String temp = bin[j];
					bin[j] = bin[i];
					bin[i] = temp;
				} else if (count[i] == count[j]) {
					String s1 = bin[i];
					String s2 = bin[j];
					if (s1.length() - s2.length() > 0) {
						int t = Math.abs(s1.length() - s2.length());
						String pre = "";
						for (int k = 0; k < t; k++) {
							pre += "0";
						}
						s2 = pre + s2;
					} else if (s1.length() - s2.length() < 0) {
						int t = Math.abs(s1.length() - s2.length());
						String pre = "";
						for (int k = 0; k < t; k++) {
							pre += "0";
						}
						s1 = pre + s1;
					}
					bin[i] = s1;
					bin[j] = s2;
					if (s1.compareTo(s2) < 0) {
						String temp = bin[j];
						bin[j] = bin[i];
						bin[i] = temp;
						int t = a[i];
						a[i] = a[j];
						a[j] = t;
						int t1 = count[i];
						count[i] = count[j];
						count[j] = t1;

					}
				}
			}
		}
		return a;

	}

	public static String reversingString(String s) {
		StringBuffer s1 = new StringBuffer(s);
		s = s1.reverse().toString();
		return s;

	}

}
