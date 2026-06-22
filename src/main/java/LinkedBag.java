import java.lang.reflect.Array;
public class LinkedBag<T> implements BagInterface<T> {
    private Node<T> head;
    private int numberOfEntries;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedBag() {
        head = null;
        numberOfEntries = 0;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = head;
        head = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T removedData = head.data;
        head = head.next;
        numberOfEntries--;
        return removedData;
    }

    @Override
    public boolean remove(int index){
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            numberOfEntries--;
            return true;
        }
        return false;

    }

    @Override
    public boolean remove(T anEntry) {
        Node<T> currentNode = head;
        Node<T> previousNode = null;

        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                if (previousNode == null) {
                    head = head.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                numberOfEntries--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                count++;
            }
            currentNode = currentNode.next;
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int search(T anEntry) {
        Node<T> currentNode = head;
        int index=0;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }
    public T[] toArray(Class<T> type) {
        T[] result = (T[]) Array.newInstance(type, numberOfEntries);

        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            result[index++] = currentNode.data;
            currentNode = currentNode.next;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;
        int index = 1;
        while (currentNode != null) {
            sb.append("Item:").append(index++).append("\n");
            sb.append(currentNode.data).append("\n");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
