import java.util.*;

public class Solution {

	// super

	//	public int solution(int[] A) {
//
////		int[] B = A.clone();
////		Arrays.sort(B);
//
//		int n = A.length;
//		// From N + 1, no circle can begin, because the center of the last
//		// circle is in N.
//		// Need 2 arrays for the event of beginning & end, because a circle can
//		// start & terminate in the same time when the radius is 0. So, if it's in the same
//		// array, when calculate the number of the intersection, we can't see this circle.
//		int[] starts = new int[n + 1];
//		int[] ends = new int[n + 1];
//
//		for (int i = 0; i < n; i++) {
//			int discRadius = A[i]; // Math.Abs
//			// To tag the beginning of the circle
//			long iBeginning = (long) i - (long) discRadius;
//			starts[(int) (iBeginning < 0 ? 0 : iBeginning)]++;
//
//			// To tag the end of the circle
//			long iEnd = (long) i + (long) discRadius;
//			ends[(int) (iEnd > n ? n : iEnd)]++;
//		}
//
//		int intersects = 0;
//		int activeCircles = 0;
//		for (int i = 0; i < n + 1; i++) {
//			int newCircles = starts[i];
//			if (newCircles > 0) {
//				intersects += activeCircles * newCircles
//						              + (newCircles - 1) * newCircles / 2; ///////// !!!!!!!!!!!!!!! Число пересечений в точке
//				activeCircles += newCircles;
//				if (intersects > 10000000) {
//					return -1;
//				}
//			}
//			if (ends[i] > 0) {
//				activeCircles -= ends[i];
//			}
//		}
//		return intersects;
//	}


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
