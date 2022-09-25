package test;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked") // do not remove this line
public class Stack<T> {
  private Node<T> first;
  private int size;

  public void push(T value) {
    Node<T> node = new Node<>(value);
    if (first == null) {
      first = node;
    } else {
      Node<T> oldNode = first;
      while (oldNode.next != null) {
        oldNode = oldNode.next;
      }
      oldNode.next = node;
    }
    size++;
  }

  public T peek() {
    if (first == null) {
      throw new EmptyStackException();
    } else {
      Node<T> oldNode = first;
      while (oldNode.next != null) {
        oldNode = oldNode.next;
      }
      return oldNode.item;
    }
  }

  public T pop() {
    T returnedValue;
    if (first == null) {
      throw new EmptyStackException();
    } else if (first.next == null) {
      returnedValue = first.item;
      first = null;
      size--;
      return returnedValue;
    } else {
      Node<T> prevNode = first;
      Node<T> nextNode = first.next;
      while (nextNode.next != null) {
        prevNode = nextNode;
        nextNode = nextNode.next;
      }
      returnedValue = nextNode.item;
      prevNode.next = null;
      size--;
      return returnedValue;
    }
  }

  public int size() {
    return size;
  }

  private static class Node<T> {
    private T item;
    private Node<T> next;
    public Node(T element) {
      this.item = element;
    }
  }
}