import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 并发修改异常
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            if(iterator.next()==1){
                iterator.remove();
            }
        }
        System.out.println(list);

    }
}