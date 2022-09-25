import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.Stack;

import java.util.EmptyStackException;

public class StackTest {
  private static final String NEW_LIST_REGEX = ".*newArrayList.*|.*newLinkedList.*";
  private Stack<String> stack;
  private String resultCode;

  @Before
  public void setUp() {
    stack = new Stack<>();
    String Solution = "package test;\n" +
            "\n" +
            "import java.util.EmptyStackException;\n" +
            "\n" +
            "@SuppressWarnings(\"unchecked\") // do not remove this line\n" +
            "public class Stack<T> {\n" +
            "  private Node<T> first;\n" +
            "  private int size;\n" +
            "\n" +
            "  public void push(T value) {\n" +
            "    Node<T> node = new Node<>(value);\n" +
            "    if (first == null) {\n" +
            "      first = node;\n" +
            "    } else {\n" +
            "      Node<T> oldNode = first;\n" +
            "      while (oldNode.next != null) {\n" +
            "        oldNode = oldNode.next;\n" +
            "      }\n" +
            "      oldNode.next = node;\n" +
            "    }\n" +
            "    size++;\n" +
            "  }\n" +
            "\n" +
            "  public T peek() {\n" +
            "    if (first == null) {\n" +
            "      throw new EmptyStackException();\n" +
            "    } else {\n" +
            "      Node<T> oldNode = first;\n" +
            "      while (oldNode.next != null) {\n" +
            "        oldNode = oldNode.next;\n" +
            "      }\n" +
            "      return oldNode.item;\n" +
            "    }\n" +
            "  }\n" +
            "\n" +
            "  public T pop() {\n" +
            "    T returnedValue;\n" +
            "    if (first == null) {\n" +
            "      throw new EmptyStackException();\n" +
            "    } else if (first.next == null) {\n" +
            "      returnedValue = first.item;\n" +
            "      first = null;\n" +
            "      size--;\n" +
            "      return returnedValue;\n" +
            "    } else {\n" +
            "      Node<T> prevNode = first;\n" +
            "      Node<T> nextNode = first.next;\n" +
            "      while (nextNode.next != null) {\n" +
            "        prevNode = nextNode;\n" +
            "        nextNode = nextNode.next;\n" +
            "      }\n" +
            "      returnedValue = nextNode.item;\n" +
            "      prevNode.next = null;\n" +
            "      size--;\n" +
            "      return returnedValue;\n" +
            "    }\n" +
            "  }\n" +
            "\n" +
            "  public int size() {\n" +
            "    return size;\n" +
            "  }\n" +
            "\n" +
            "  private static class Node<T> {\n" +
            "    private T item;\n" +
            "    private Node<T> next;\n" +
            "    public Node(T element) {\n" +
            "      this.item = element;\n" +
            "    }\n" +
            "  }\n" +
            "}";
    resultCode = Solution.replaceAll("\\s", "");
  }

  @Test
  public void size_emptyStack_ok() {
    Assert.assertEquals(0, stack.size());
  }

  @Test
  public void size_oneElement_ok() {
    stack.push("Hello");
    Assert.assertEquals(1, stack.size());
  }

  @Test
  public void size_threeElements_ok() {
    stack.push("Hello");
    stack.push("World");
    stack.push("Mate");
    Assert.assertEquals(3, stack.size());
  }

  @Test
  public void peek_oneElement_ok() {
    stack.push("Hello");
    Assert.assertEquals(1, stack.size());
    String actual = stack.peek();
    String expected = "Hello";
    Assert.assertEquals(expected, actual);
    Assert.assertEquals(1, stack.size());
  }

  @Test
  public void peek_severalTimes_ok() {
    stack.push("Hello");
    stack.push("World");
    Assert.assertEquals(2, stack.size());
    String actual = stack.peek();
    String expected = "World";
    Assert.assertEquals(expected, actual);

    String actualSecondTry = stack.peek();
    String expectedSecondTry = "World";
    Assert.assertEquals(expectedSecondTry, actualSecondTry);

    String actualThirdTry = stack.peek();
    String expectedThirdTry = "World";
    Assert.assertEquals(expectedThirdTry, actualThirdTry);

    Assert.assertEquals(2, stack.size());
  }

  @Test(expected = EmptyStackException.class)
  public void peek_emptyStack() {
    Assert.assertEquals(0, stack.size());
    stack.peek();
  }

  @Test
  public void pop_ok() {
    stack.push("Hello");
    Assert.assertEquals(1, stack.size());
    String actual = stack.pop();
    String expected = "Hello";
    Assert.assertEquals(expected, actual);
    Assert.assertEquals(0, stack.size());
  }

  @Test
  public void pop_threeElements_ok() {
    stack.push("Hello");
    stack.push("World");
    stack.push("Mate");
    Assert.assertEquals(3, stack.size());

    String actual = stack.pop();
    String expected = "Mate";
    Assert.assertEquals(expected, actual);
    Assert.assertEquals(2, stack.size());

    String actualSecond = stack.pop();
    String expectedSecond = "World";
    Assert.assertEquals(expectedSecond, actualSecond);
    Assert.assertEquals(1, stack.size());

    String actualThird = stack.pop();
    String expectedThird = "Hello";
    Assert.assertEquals(expectedThird, actualThird);
    Assert.assertEquals(0, stack.size());
  }

  @Test(expected = EmptyStackException.class)
  public void pop_emptyStack() {
    Assert.assertEquals(0, stack.size());
    stack.pop();
  }

  @Test
  public void solution_containsCollectionClasses() {
    Assert.assertEquals("You should not use Collection classes "
        + "(e.g., ArrayList or LinkedList).\n",
      false, resultCode.matches(NEW_LIST_REGEX));
  }
}
