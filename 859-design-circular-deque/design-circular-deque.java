class MyCircularDeque {
    int[] queue;
    int front;
    int back;
    int size;
    int length = 0;
    public MyCircularDeque(int k) {
        queue = new int[k]; 
        size = k;
        front = 0;
        back = -1;
        length = 0;
    }
    
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if(isEmpty()) {
            insertLast(value);
            front = back;
            return true;
        }
        front = (front - 1 + size) % size;
        queue[front] = value;
        length++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        back = (back + 1) % size;
        queue[back] = value;
        length++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        length--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        back = (back - 1 + size) % size;
        length--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return queue[front];
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return queue[back];
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public boolean isFull() {
        return length == size;
    }
}

