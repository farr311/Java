package lesson30;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentCollections {

    public static void main(String[] args) {
        List<Integer> copyList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            copyList.add(i);
        }

        //12600252
        int index = 0;
        for (Integer integer : copyList) {
            System.out.println(index);
            if (integer % 2 == 0) {
                copyList.remove(integer);
            }
            index++;
        }

        System.out.println(copyList);

    }
}
