public class MyArrayList<T> implements MyList<T>{
    private Object[] elements;
    private int size=0;
    public MyArrayList() {
        elements = new Object[5];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public void add(T t) {
        if (size == elements.length) {
          Object[] copy = new Object[elements.length*2];
          for (int i = 0; i<elements.length;i++) {
              copy[i] = elements[i];
          }
          elements = copy;
        }
        elements[size++] = t;

    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }



    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }
    public T getAll() {
        return (T) elements;
    }



    @Override
    public T remove(int index) {
        for (int i = index;i<size;i++) {
            elements[i]=elements[i+1];
        }
        size--;
        return (T) elements;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}

