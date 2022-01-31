package com.lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int numberOfItems;

    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    //Реализация итератора
    private class DequeIterator implements Iterator<T> {
        private Node current;

        public DequeIterator() {
            this.current = first;
        }

        public boolean hasNext() { return current != null;                      }
        public void remove()     { throw new UnsupportedOperationException();   }

        public T next() {
            if (!this.hasNext()) { throw new NoSuchElementException();          }
            else {
                Node node = current;
                current = current.next;
                return node.item;
            }
        }
    }

    public Deque() {
        this.first = null;
        this.last = null;
        this.numberOfItems = 0;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.numberOfItems;
    }

    public void addFirst(T item) {
        if (item == null) { throw new NullPointerException();   }

        if (this.isEmpty()) {
            this.first = new Node(item);
            this.last = first;
        } else {
            Node node = new Node(item);
            node.next = this.first;
            this.first.prev = node;
            this.first = node;
        }
        this.numberOfItems++;
    }

    public void addLast(T item) {
        if (item == null) { throw new NullPointerException();   }

        if (this.isEmpty()) {
            this.last = new Node(item);
            this.first = last;
        } else {
            Node node = new Node(item);
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
        this.numberOfItems++;
    }


    public T removeFirst() {
        if (this.isEmpty()) { throw new NoSuchElementException(); }

        Node node = this.first;
        if (this.size() == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first.next.prev = null;
            this.first = this.first.next;
        }
        this.numberOfItems--;
        node.next = null;
        return node.item;
    }

    public T removeLast() {
        if (this.isEmpty()) { throw new NoSuchElementException(); }

        Node node = this.last;
        if (this.size() == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.last.prev.next = null;
            //this.last.prev = null;
            this.last = this.last.prev;
        }
        this.numberOfItems--;
        node.next = null;
        return node.item;
    }

    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {

        Deque<Integer> deq1 = new Deque<>();

        System.out.println("Дека: " + deq1);
        System.out.println("Размер: " + deq1.size());

        deq1.addFirst(1);
        deq1.addFirst(2);
        deq1.addFirst(3);
        deq1.addFirst(4);
        deq1.addFirst(5);
        deq1.addFirst(6);


        System.out.println("Дека: " + deq1);

        deq1.removeLast();
        System.out.println("Дека: " + deq1);

        deq1.removeFirst();
        System.out.println("Дека: " + deq1);
        System.out.println("Размер: " + deq1.size());

        deq1.addFirst(1);
        deq1.addLast(2);
        System.out.println("Дека: " + deq1);

        deq1.addFirst(3);
        deq1.addLast(4);
        System.out.println("Дека: " + deq1);

        System.out.println("Размер: " + deq1.size());

        Iterator<Integer> itr = deq1.iterator();

        System.out.println(itr.next());
        System.out.println(itr.next());

    }



}
