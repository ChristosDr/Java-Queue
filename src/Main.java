import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {

    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length ==0;
    }

    public void enqueue(int data){
        ListNode temp = new ListNode(data);
        if (isEmpty()){
            front = temp;
        }else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        length--;
        return result;
    }

    public String[] generateBinaryNumbers(int n){
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i=0; i<n; i++){
            result[i] = q.poll();
            String n1 = result[i] +"0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }

    public void print(){
        if (isEmpty()){
            return;
        }

        ListNode current = front;
        while (current != null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        Main sll = new Main();
        sll.enqueue(10);
        sll.enqueue(15);
        sll.enqueue(20);

        sll.dequeue();
        sll.print();
    }
}