/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

//import java.util.Iterator;

import java.util.Iterator;

public class MyQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() { return N == 0; } //first is null
    public int size()        { return N; }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else          oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
    public Iterator<Item> iterator(){

        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() { }
    }


    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        for(int i = 10; i > 0; i--)
            q.enqueue(i);
        for(Integer i: q){
            System.out.println(q.dequeue());
        }

    }
}
