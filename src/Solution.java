import java.util.*;

public class Solution {

	class P {
		P(long x, byte begin) {
			this.x = x;
			this.begin = begin;
		}
		long x;
		byte begin;
	}

	public int solution(int[] A) {
		//Arrays.sort(A);

		P[] arr = new P[A.length*2];

		//int p = 0;
		for (int i = 0; i<A.length; i++) {
			arr[i*2] = new P(i - (long)A[i], (byte)1);
			arr[i*2+1] = new P(i + (long)A[i], (byte)0);
		}

		Arrays.sort(arr,
			(a, b) -> {
				int c = Long.compare(a.x, b.x);
				if (c!=0)
					return c;
				c = Byte.compare(b.begin, a.begin);
				return c;
			}
		);

		int c = 0;
		int intersec = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i].begin == 1)
				if ((intersec += c++) > 10_000_000)
					return -1;
			else
				c--;

		return intersec;
	}

}
