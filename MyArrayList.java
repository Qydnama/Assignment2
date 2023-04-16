public class MyArrayList<T> implements MyList<T>{
    private Object[] elements;
    private int size=0;
    public MyArrayList() {
        elements = new Object[5];
    }
    
    //Returns the number of elements in the list.
    @Override
    public int size() {
        return size;
    }

    //Returns true if the list contains the specified element, false otherwise.
    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    //Appends the specified element to the end of the list.
    @Override
    public void add(T t) {
        if (size == elements.length) {
            increaseArray();
        }
        elements[size++] = t;
    }

    //Inserts the specified element at the specified position in the list. 
    //Shifts the element currently at that position (if any) and any subsequent elements to the right.
    @Override
    public void add(T item, int index) {
        for (int i = size+1;index<i;i--) {
            if (i == elements.length) {
                increaseArray();
            }
            elements[i]=elements[i-1];
        }
        elements[index] = item;
        size++;
    }
    
    //Increases the size of the underlying array when the list is full.
    private void increaseArray() {
        Object[] copy = new Object[(int) (elements.length*1.5)];
        for (int i = 0; i<size;i++) {
            copy[i] = elements[i];
        }
        elements = copy;

    }

    //Removes the first occurrence of the specified element from the list, if it is present.
    @Override
    public boolean remove(Object o) {
        for(int i = 0;i<size;i++) {
            if (elements[i]==o) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    //Removes the element at the specified position in the list. Shifts any subsequent elements to the left.
    @Override
    public T remove(int index) {
        T oldValue = (T) elements[index];
        for (int i = index;i<size-1;i++) {
            elements[i]=elements[i+1];
        }
        size--;
        return oldValue;
    }

    //Removes all of the elements from the list.
    @Override
    public void clear() {
        for(int i = 0;i < size; i++) {
            elements[i] = null;
        }
    }

    //Returns the element at the specified position in the list.
    @Override
    public T get(int index) {
        return (T) elements[index];
    }
    
    //Returns the index of the first occurrence of the specified element in the list,
    //or -1 if the list does not contain the element.
    @Override
    public int indexOf(Object o) {
        for(int i = 0;i<size;i++) {
            if (elements[i] == o)
                return i;
        }
        return -1;
    }
    
    //Returns the index of the last occurrence of the specified element in the list,
    //or -1 if the list does not contain the element.
    @Override
    public int lastIndexOf(Object o) {
        int last=-1;
        for(int i = 0;i<size;i++) {
            if (elements[i]== o)
                last = i;
        }
        return last;
    }
    
    //Sorts the list into ascending order using the natural ordering of its elements.
    @Override
    public void sort() {
        for (int i = 1; i < size; i++) {
            T key = get(i);
            int j = i - 1;

            while (j >= 0 && ((Comparable<T>) get(j)).compareTo(key) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }
}

