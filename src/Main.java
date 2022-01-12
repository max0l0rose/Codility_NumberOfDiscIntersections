public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[] {1, 2_147_483_647, 0}));

        //        System.out.println(solution.solution(new int[] {1,1,1}));
//        System.out.println(solution.solution(new int[] {1,0,1}));
//        System.out.println(solution.solution(new int[] {1,0,0}));
//        System.out.println(solution.solution(new int[] {0,0,0}));

//        System.out.println(solution.solution(new int[] {2,1,0}));
//        System.out.println(solution.solution(new int[] {1,5,2,1,4,0}));
    }
}


/**
 *
 * https://app.codility.com/programmers/task/number_of_disc_intersections/
 *
 * Given an array A of N integers, we draw N discs in a 2D plane such that the I-th disc is centered on (0,I) and has a radius of A[I].
 * We say that the J-th disc and K-th disc intersect if J != K and J-th and K-th discs have at least one common point.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A describing N discs as explained above, returns the number of pairs of intersecting discs. For example, given N=6 and:
 * A[0] = 1  A[1] = 5  A[2] = 2
 * A[3] = 1  A[4] = 4  A[5] = 0
 * intersecting discs appear in eleven pairs of elements:
 * 0 and 1,
 * 0 and 2,
 * 0 and 4,
 * 1 and 2,
 * 1 and 3,
 * 1 and 4,
 * 1 and 5,
 * 2 and 3,
 * 2 and 4,
 * 3 and 4,
 * 4 and 5.
 * so the function should return 11.
 * The function should return -1 if the number of intersecting pairs exceeds 10,000,000.
 * Assume that:
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * Complexity:
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */

 /*1. Simple solution, treat it as a math problem. The only situation that two disks don't intersect is : right-A[right]>i+A[i]
    However, n(n-1)/2 may cause arithmetic overflow of integer and the O(n*n)performance is bad. Use long instead.*/

