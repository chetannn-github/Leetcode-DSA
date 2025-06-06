// class MinStack {
//     Stack<Integer> st;
//     Stack<Integer> min;
//     Integer minVal = Integer.MAX_VALUE;
    
//     public MinStack() {
//         st = new Stack<>();
//         min = new Stack<>();
//     }
    
//     public void push(int val) {
//         st.push(val);
//         minVal = Math.min(val,minVal);
//         min.push(minVal);
//     }
    
//     public void pop() {
//         st.pop();
//         min.pop();
//         minVal = min.isEmpty() ? Integer.MAX_VALUE : min.peek();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         return min.peek();
//     }
// }



class Node {
    int val;
    int min;
    Node next;

    Node(int val,int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    } 
}

class MinStack {
    
    Node head;
    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val,val,null);
        }else {
            Node temp = new Node(val,Math.min(val,head.min), head);
            head = temp;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return  head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}



