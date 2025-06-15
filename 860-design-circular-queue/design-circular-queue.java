class MyCircularQueue {
    int[] queue;
    int front;
    int back;
    int size;
    int length = 0;

    public MyCircularQueue(int k) {
        queue = new int[k]; 
        size = k;
        front = 0;
        back = -1;
        length = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        back = (back + 1) % size;
        queue[back] = value;
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        length--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int Rear() {
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