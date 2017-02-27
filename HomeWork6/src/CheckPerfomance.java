import java.util.*;

public class CheckPerfomance {
    //a
    ArrayList arrayList;
    LinkedList linkedList;
    //b
    HashSet hashSet;
    LinkedHashSet linkedHashSet;
    TreeSet treeSet;
    //c
    HashMap hashMap;
    LinkedHashMap linkedHashMap;
    TreeMap treeMap;

    public CheckPerfomance() {
        arrayList = new ArrayList<Double>();
        linkedList = new LinkedList<Double>();
        hashSet = new HashSet<Double>();
        linkedHashSet = new LinkedHashSet<Double>();
        treeSet = new TreeSet<Double>();
        hashMap = new HashMap<Integer, Double>();
        linkedHashMap = new LinkedHashMap<Integer, Double>();
        treeMap = new TreeMap<Integer, Double>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            arrayList.add(random.nextDouble());
            linkedList.add(random.nextDouble());
            hashSet.add(random.nextDouble());
            linkedHashSet.add(random.nextDouble());
            treeSet.add(random.nextDouble());
            hashMap.put(i, random.nextDouble());
            linkedHashMap.put(i, random.nextDouble());
            treeMap.put(i, random.nextDouble());
        }
    }

    public void compareA() {
        double s1, e1;

        s1 = System.nanoTime();
        arrayList.add(173.85);
        e1 = System.nanoTime();
        System.out.println("Array list's adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedList.add(173.85);
        e1 = System.nanoTime();
        System.out.println("Linked list's adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        arrayList.add(5000, 181.5);
        e1 = System.nanoTime();
        System.out.println("Array list's Inserting time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedList.add(5000, 181.5);
        e1 = System.nanoTime();
        System.out.println("Linked list's Inserting time: " + (e1 - s1));

        s1 = System.nanoTime();
        arrayList.remove(5000);
        e1 = System.nanoTime();
        System.out.println("Array list's Removing time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedList.remove(5000);
        e1 = System.nanoTime();
        System.out.println("Linked list's time: " + (e1 - s1));
    }

    public void compareB() {
        double s1, e1;

        s1 = System.nanoTime();
        hashSet.add(173.85);
        e1 = System.nanoTime();
        System.out.println("Hash set's adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedHashSet.add(173.85);
        e1 = System.nanoTime();
        System.out.println("Linked Hash Set's adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        treeSet.add(173.85);
        e1 = System.nanoTime();
        System.out.println("Tree Set's lists adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        hashSet.remove(5.0);
        e1 = System.nanoTime();
        System.out.println("Hash Set's removing time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedHashSet.remove(5.0);
        e1 = System.nanoTime();
        System.out.println("Linked Hash Set's removing time: " + (e1 - s1));

        s1 = System.nanoTime();
        treeSet.remove(5.0);
        e1 = System.nanoTime();
        System.out.println("Tree Set's lists removing time: " + (e1 - s1));
    }

    public void compareC() {
        double s1, e1;

        s1 = System.nanoTime();
        hashMap.put(5000, 173.85);
        e1 = System.nanoTime();
        System.out.println("Hash map's adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedHashMap.put(5000, 173.85);
        e1 = System.nanoTime();
        System.out.println("Linked Hash Map's adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        treeMap.put(5000, 173.85);
        e1 = System.nanoTime();
        System.out.println("Tree Map's lists adding time: " + (e1 - s1));

        s1 = System.nanoTime();
        hashMap.remove(5000);
        e1 = System.nanoTime();
        System.out.println("Hash Map's removing time: " + (e1 - s1));

        s1 = System.nanoTime();
        linkedHashMap.remove(5000);
        e1 = System.nanoTime();
        System.out.println("Linked Hash Map's removing time: " + (e1 - s1));

        s1 = System.nanoTime();
        treeMap.remove(5000);
        e1 = System.nanoTime();
        System.out.println("Tree Map's lists removing time: " + (e1 - s1));
    }

}
