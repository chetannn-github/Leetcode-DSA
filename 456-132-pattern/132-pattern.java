class Solution {
    public boolean find132pattern(int[] nums) {
        reverseArray(nums);
        return !checkStackSortable(nums);
    }


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