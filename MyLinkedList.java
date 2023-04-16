public class MyLinkedList<T> implements MyList<T>{

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private class MyNode<T> {
        T data;
        MyNode<T> next = null;
        MyNode<T> previous;
        MyNode(T data) {
            this.data = data;
        }
    }

    //Returns the number of elements in the linked list.
    @Override
    public int size() {
        return size;
    }

    //Returns true if the linked list contains the specified element, false otherwise.
    @Override
    public boolean contains(Object o) {
        MyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Appends the specified element to the end of the linked list.
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //Inserts the specified element at the specified position in the linked list.
    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.previous = current;
            newNode.next = current.next;
            current.next.previous = newNode;
            current.next = newNode;
        }
        size++;
    }


    //Removes the first occurrence of the specified element from the linked list, if it is present.
    @Override
    public boolean remove(Object o) {
        MyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Removes the Node in the Linked list.
    private void removeNode(MyNode<T> node) {
        if (node == head && node == tail) {
            head = tail = null;
        } else if (node == head) {
            head = node.next;
            head.previous = null;
        } else if (node == tail) {
            tail = node.previous;
            tail.next = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }
    //Removes the element at the specified position in the linked list.
    @Override
    public T remove(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        removeNode(current);
        return current.data;
    }

    //Removes all elements from the linked list.
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    //Returns the element at the specified position in the linked list.
    @Override
    public T get(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    //Returns the index of the first occurrence of the specified element in the linked list, or -1 if the linked list does not contain the element.
    @Override
    public int indexOf (Object o){
        int index = 0;
        MyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //Returns the index of the last occurrence of the specified element in the linked list, or -1 if the linked list does not contain the element.
    @Override
    public int lastIndexOf (Object o){
        int index = size - 1;
        MyNode<T> current = tail;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    //Sorts the linked list in ascending order using insertion sort. Note that the elements in the linked list must implement the Comparable interface in order for this method to work correctly.
    @Override
    public void sort() {
        if (size < 2) {
            return;
        }
        MyNode<T> current = head.next;
        while (current != null) {
            T key = current.data;
            MyNode<T> j = current.previous;
            while (j != null && ((Comparable<T>)j.data).compareTo(key) > 0) {
                j.next.data = j.data;
                j = j.previous;
            }
            if (j == null) {
                head.data = key;
            } else {
                j.next.data = key;
            }
            current = current.next;
        }
    }
}