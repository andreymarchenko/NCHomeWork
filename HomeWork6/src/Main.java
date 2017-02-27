public class Main {
    public static void main(String[] args) {
        //Check the basic functions
        MyLinkedList list = new MyLinkedList<Double>();
        list.add(5);
        list.add(10);
        list.add(7);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        list.add(1, 6);
        System.out.println(list.toString());
        System.out.println(list.indexOf(7));
        System.out.println(list.set(2, 19));
        System.out.println(list.toString());
        list.clear();
        System.out.println(list.toString());
        list.add(5);
        System.out.println(list.toString());

        //Check perfomance
        CheckPerfomance checkPerfomance = new CheckPerfomance();
        checkPerfomance.compareA();
        checkPerfomance.compareB();
        checkPerfomance.compareC();
    }
}
