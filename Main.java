public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(245);
        arrayList.add(3135);
        arrayList.add(4465);
        arrayList.add(5321);
        arrayList.add(6231);
        arrayList.add(7521);
        arrayList.remove(0);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
        System.out.println(arrayList.isEmpty());

    }
}