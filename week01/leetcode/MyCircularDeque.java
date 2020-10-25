package week01.leetcode;

public class MyCircularDeque {

    public static void main(String[] args) {

        MyCircularDeque circularDeque = new MyCircularDeque(9); // 设置容量大小为3
        circularDeque.insertFront(64);
        circularDeque.insertLast(19);
        circularDeque.insertFront(26);
        circularDeque.insertLast(57);
        circularDeque.foreach();//26 64 0 0 0 0 0 0 0 19 57

        circularDeque.deleteFront();
        circularDeque.foreach();//64 0 0 0 0 0 0 0 0 19 57
        circularDeque.insertLast(69);
        circularDeque.foreach();//64 0 0 0 0 0 0 0 19 57 69
        circularDeque.insertFront(82);
        circularDeque.insertFront(21);


        circularDeque.insertLast(23);
        circularDeque.insertFront(51);
        circularDeque.foreach();//51 21 82 64 0 0 0 19 57 69 23

        circularDeque.deleteLast();
        circularDeque.foreach();//51 21 82 0 0 0 0 19 19 57 69

//        circularDeque.deleteFront();
//        circularDeque.foreach();//21 82 0 0 0 0 0 19 19 57 69
//        circularDeque.insertFront(45);
//        circularDeque.foreach();//45 21 82 0 0 0 0 19 19 57 69
//        circularDeque.deleteLast();
//        circularDeque.foreach();//45 21 0 0 0 0 0 19 19 19 57
//        circularDeque.insertLast(20);
//        circularDeque.foreach();//45 21 0 0 0 0 0 19 19 57 20
//        circularDeque.deleteFront();
//        circularDeque.deleteFront();
//        circularDeque.foreach();//0 0 0 0 0 0 0 19 19 57 20
//        int front = circularDeque.getFront();
//        System.out.println(front);


//        circularDeque.deleteFront();
//        circularDeque.insertFront(6);
//        circularDeque.insertLast(5);
//        circularDeque.insertFront(9);
//        circularDeque.insertFront(6);







//        circularDeque.insertFront(9);
//        circularDeque.insertLast(9);
//        circularDeque.foreach();
//        circularDeque.insertLast(8);
//        circularDeque.foreach();
//
//        circularDeque.deleteLast();
//        circularDeque.foreach();
//        int front = circularDeque.getFront();
//        System.out.println(front);


//        int rear = circularDeque.getRear();
//        circularDeque.insertFront(9);
//        circularDeque.getRear();
//        circularDeque.insertLast(5);
//        circularDeque.getFront();
//        circularDeque.getRear();
//        circularDeque.getFront();
//        circularDeque.insertLast(8);
//        circularDeque.deleteLast();
//        circularDeque.getFront();


    }

    public void foreach(){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    /**
     * 双端队列存底层存储结构
     */
    int[] arr = null;


    /**
     * 双端队列中顺序实个数(下标+1)
     */
    private int countFront = 0;

    /**
     * 双端队列中倒序实下标(下标+1)
     */
    private int countLast = 0;

    /**
     * 双端队列总长度
     */
    private int size = 0;


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        if (k >= 0) {
            this.size = k;
            this.arr = new int[k];
        } else {
            throw new RuntimeException("the value of K must be nonnegative");
        }

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            System.arraycopy(arr, 0, arr, 1, countFront);
            arr[0] = value;
            countFront++;
            return true;
        }
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            System.arraycopy(arr, size - countLast, arr, size - countLast - 1, countLast);
            arr[size - 1] = value;
            countLast++;
            return true;
        }
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (countFront==0) {
            if(countLast==0){
                return false;
            }else{
                arr[size-countLast]=0;
                countLast--;
                return true;
            }
        } else {
            if (countFront == 1) {
                arr[0] = 0;
                countFront--;
                return true;
            } else {
                System.arraycopy(arr, 1, arr, 0, countFront - 1);
                arr[--countFront] = 0;
                return true;
            }
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (countLast==0 ) {
            if(countFront==0){
                return false;
            }else {
                arr[--countFront]=0;
                return true;
            }
        }else {
            if(countLast==1) {
                arr[size-1] = 0;
                countLast--;
                return true;
            }else{
//                System.out.println("aa"+countLast);
//                System.out.println("bb"+(size - countLast));
                System.arraycopy(arr, size - countLast, arr, size - countLast + 1, countLast - 1);
                arr[size - countLast] = 0;
                countLast--;
                return true;
            }
        }


    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
//        if(isEmpty()){
//            return -1;
//        }else{
//            if(countFront>0){
//                return arr[0];
//            }else {
//                return arr[size-countLast];
//            }
//
//        }

        if (countFront==0) {
            if(countLast==0){
                return -1;
            }else{
                return arr[size-countLast];
            }
        } else {
            return arr[0];
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
//        if(isEmpty()){
//            return -1;
//        }else{
//            if(countLast>0){
//                return arr[size-1];
//            }else {
//                return arr[countFront-1];
//            }
//        }

        if (countLast==0) {
            if(countFront==0){
                return -1;
            }else{
                return arr[countFront-1];
            }
        } else {
            return arr[size-1];
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return (countFront + countLast) == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (countFront + countLast) == size;
    }
}

