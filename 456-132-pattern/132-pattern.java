// chetann broo this is crazy brain i have used ever
// tell me tell you the story behind this i was learning unique bst count
// wiki told us that it is equal to catayln number 
// then another applications are given then there is thing called stack sortable permutation from 1 to n is also equal to catalyn number 
// then i read little more about then it says some scientist researched that except 231 pattern all can be sorted by single stack then i got an idea i haved eariler solved 132 pattern cant we reverse thhe array and find 231 pattern 


class Solution {
    public boolean find132pattern(int[] nums) {
        reverseArray(nums);
        return !checkStackSortable(nums);
    }

    /// knuth algo to find stack sort 
    public static boolean checkStackSortable(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int prev = Integer.MIN_VALUE;

        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() < num) {
                if(stack.peek() < prev) return false;
                prev = stack.pop();
                
            }
            stack.push(num);
        }

        while(!stack.isEmpty()) {
            if(stack.peek() < prev) return false;
                prev = stack.pop();
        }

        return true;
    }


    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}