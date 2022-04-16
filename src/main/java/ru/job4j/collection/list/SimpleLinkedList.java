package ru.job4j.collection.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node<E>(value, null);
            tail = head;
        } else {
            tail.setNext(new Node<E>(value, null));
            tail = tail.getNext();
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Iterator<E> iter = iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> pointer = head;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (pointer != null);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = pointer.getData();
                pointer = pointer.getNext();
                return result;
            }
        };
    }

    private class Node<E> {
        private Node<E> next;
        private E data;

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> next) {
            this.next = next;
            this.data = data;
        }
    }
}
