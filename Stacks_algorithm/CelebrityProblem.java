

package Stacks_algorithm;

import java.util.Stack;

public class CelebrityProblem {

    // Returns index of the celebrity or -1 if none
    public static int findCelebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();

        // Push all persons onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Reduce candidates
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(M, a, b)) {
                // a knows b, so a can't be celebrity, b may be
                stack.push(b);
            } else {
                // a doesn't know b, so b can't be celebrity, a may be
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should not know i and i should know candidate
                if (knows(M, candidate, i) || !knows(M, i, candidate)) {
                    return -1; // No celebrity
                }
            }
        }

        return candidate;
    }

    // Helper function to check if person a knows person b
    public static boolean knows(int[][] M, int a, int b) {
        return M[a][b] == 1;
    }

    public static void main(String[] args) {
        int[][] M = {
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 1, 1, 0}
        };
        int n = M.length;

        int celeb = findCelebrity(M, n);
        if (celeb == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("Celebrity is person " + celeb);
        }
    }
}

