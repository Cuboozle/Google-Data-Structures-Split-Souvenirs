package week6;

import java.util.Arrays;
import java.util.Scanner;

public class SplitSouvenirs {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int ans = 0;
		int[] ray = new int[n];
		for (int i = 0; i < ray.length; i++) {
			ray[i] = kb.nextInt();
		}

		if (splitTo3(ray))
			ans = 1;

		System.out.println(ans);
		kb.close();
	}

	public static boolean subsetSum(int[] S, int n, int a, int b, int c) {
		boolean A = false, B = false, C = false;

		if (a == 0 && b == 0 && c == 0)
			return true;

		if (n < 0)
			return false;

		if (a - S[n] >= 0)
			A = subsetSum(S, n - 1, a - S[n], b, c);

		if (!A && (b - S[n] >= 0))
			B = subsetSum(S, n - 1, a, b - S[n], c);

		if ((!A && !B) && (c - S[n] >= 0))
			C = subsetSum(S, n - 1, a, b, c - S[n]);

		return A || B || C;
	}

	public static boolean splitTo3(int[] S) {
		if (S.length < 3)
			return false;

		int sum = Arrays.stream(S).sum();

		return (sum % 3) == 0 && subsetSum(S, S.length - 1, sum / 3, sum / 3, sum / 3);
	}
}
