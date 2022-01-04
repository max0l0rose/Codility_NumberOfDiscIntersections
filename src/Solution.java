import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

	public int solution(int[] A) {
		//Arrays.sort(A);

		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();

		for (int i = 0; i <A.length ; i++)
			list.add(new AbstractMap.SimpleImmutableEntry (i-A[i], A[i]));

		list.sort(Comparator.comparingInt(Map.Entry::getKey));

		ArrayList<AtomicInteger> arr = new ArrayList<>();

		int c = 0;
		int idxOld = list.get(0).getKey();
		for (int i = 0; i < list.size(); i++) {
			c += arr.size();
			int dx = list.get(i).getKey() - idxOld;
			idxOld = list.get(i).getKey();
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j).addAndGet(-dx)<=0)
					arr.remove(j--);
			}
			//if (A[i] > 0)
			arr.add(new AtomicInteger(list.get(i).getValue()));
		}


		return c;
	}

}
