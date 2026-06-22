import java.util.Arrays;
public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayBag() {
        bag = (T[]) new Object[DEFAULT_CAPACITY];
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
        if (isArrayFull()) {
            doubleCapacity();
        }
        bag[numberOfEntries++] = newEntry;
        return true;
    }

    @Override
    public T get(int i){
        if(i<0 || i>=numberOfEntries){
            return null;
        }
        return bag[i];
    }
    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T removedEntry = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return removedEntry;
    }
    @Override
    public boolean remove(int index) {
        if (index>=0 && index<numberOfEntries) {
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index != -1) {
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(bag, 0, numberOfEntries, null);
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfEntries; i++) {
            String st="Item:"+(i+1)+"\n";
            sb.append(st);
            sb.append(bag[i]).append("\n");
        }

        return sb.toString();
    }

    private boolean isArrayFull() {

        return numberOfEntries == bag.length;
    }

    private void doubleCapacity() {

        bag = Arrays.copyOf(bag, bag.length * 2);
    }

    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }
}
