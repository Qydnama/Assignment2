public class Main {
    public static void main(String[] args) {

        //Examples for MyArrayList
        MyList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(3);
        myArrayList.add(1);
        myArrayList.add(4);

        System.out.println("MyArrayList:");

        System.out.println("The list contains 4: " + myArrayList.contains(4));

        System.out.println("The size of the list is: " + myArrayList.size());

        System.out.println("The second element in the list is: " + myArrayList.get(1));

        System.out.println("Removed element: " + myArrayList.remove(1));

        System.out.println("Size of cleared list: " + myArrayList.size());

        myArrayList.add(6, 2);
        System.out.println("The list now contains: " + myArrayList.get(2));

        myArrayList.sort();
        System.out.print("The sorted list: ");
        for (int i = 0;i< myArrayList.size();i++) {
            System.out.print(myArrayList.get(i)+" ");
        }
        System.out.println();

        System.out.println("The index of 6 is: " + myArrayList.indexOf(6));


        System.out.println();
        System.out.println();
        System.out.println("MyLinkedList:");

        //Examples for MyLinkedList
        MyLinkedList<String> myList = new MyLinkedList<>();

        myList.add("Askar");
        myList.add("Khaimuldin");
        myList.add("is great teacher");

        System.out.println("Size of the list: " + myList.size());

        System.out.println("Does it contain Askar? " + myList.contains("Askar"));

        System.out.println("Element at index 2: " + myList.get(2));

        System.out.println("Index of Khaimuldin: " + myList.indexOf("Khaimuldin"));

        myList.remove("Askar");
        System.out.println("Size of the list " + myList.size());

        myList.clear();
        System.out.println("Size of the list after clearing: " + myList.size());
    }

}