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
            this.last = this.last.prev;
        }
        this.numberOfItems--;
        node.next = null;
        return node.item;
    }

    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = first;
        int position = 0;
        while (position < numberOfItems) {
            result.append(current.item.toString()).append(" ");
            current = current.next;
            position++;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();

        System.out.println("Дека: " + deque);
        System.out.println("Размер: " + deque.size());

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);


        System.out.println("Дека: " + deque);

        deque.removeLast();
        System.out.println("Дека: " + deque);

        deque.removeFirst();
        System.out.println("Дека: " + deque);
        System.out.println("Размер: " + deque.size());

        deque.addFirst(1);
        deque.addLast(2);
        System.out.println("Дека: " + deque);

        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("Дека: " + deque);

        System.out.println("Размер: " + deque.size());

        Iterator<Integer> iterator = deque.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }



}
