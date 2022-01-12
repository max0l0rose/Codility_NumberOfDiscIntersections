import java.util.*;

public class Solution {

//	class P {
//		P(long x, byte begin) {
//			this.x = x;
//			this.begin = begin;
//		}
//		long x;
//		byte begin;
//	}

	public int solution(int[] A) {
		//Arrays.sort(A);

		long[] arr = new long[A.length*2];
		int[] begin = new int[A.length*2];

		//int p = 0;
		for (int i = 0; i<A.length; i++) {
			arr[i*2] = i - (long)A[i];
			begin[i*2] = 1;
			arr[i*2+1] = i + (long)A[i];
			begin[i*2+1] = 0;
		}

		Arrays.sort(arr,
			(a, b) -> {
				int c = Long.compare(a, b);
				if (c!=0)
					return c;
				c = Integer.compare(b.begin, a.begin);
				return c;
			}
		);

		int c = 0;
		int intersec = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i].begin == 1) {
				if ((intersec += c++) > 10_000_000)
					return -1;
			}
			else
				c--;

		return intersec;
	}

}
