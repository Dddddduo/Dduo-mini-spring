import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class JucHashMap {

    public static void main(String[] args) {
        // 多线程并发修改

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Thread thread1=new Thread(()->{
//            synchronized (arrayList){
//                ListIterator<Integer> integerListIterator = arrayList.listIterator();
//                while (integerListIterator.hasNext()){
//                    System.out.println(integerListIterator.next());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
            ListIterator<Integer> integerListIterator = arrayList.listIterator();
            while (integerListIterator.hasNext()){
                System.out.println(integerListIterator.next());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
//            synchronized (arrayList){
//                ListIterator<Integer> integerListIterator = arrayList.listIterator();
//                while (integerListIterator.hasNext()){
//                    if(integerListIterator.next()==1){
//                        integerListIterator.remove();
//                    }
//                }
//            }
            ListIterator<Integer> integerListIterator = arrayList.listIterator();
            while (integerListIterator.hasNext()){
                if(integerListIterator.next()==1){
                    integerListIterator.remove();
                }
            }
        });

        thread1.start();
        thread2.start();


    }

}
