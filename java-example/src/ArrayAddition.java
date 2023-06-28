
import java.util.ArrayList;
import java.util.Collections;


public class ArrayAddition {
    public static ArrayList<Integer> normalAddition(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i) + b.get(i));
        }
        return result;
    }

    public  static ArrayList<Integer> parallelAddition(ArrayList<Integer> a,ArrayList<Integer>b) throws InterruptedException {
        Integer[] result = new Integer[a.size()];
        Thread t0 = new Thread(()->{
            for (int i = 0; i < a.size()/4; i++) {
                result[i] = a.get(i) + b.get(i);
            }
        });

        Thread t1 = new Thread(()->{
            for (int i = a.size()/4; i < a.size()/2; i++) {
                result[i] = a.get(i) + b.get(i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = a.size()/2; i < a.size(); i++) {
                result[i] = a.get(i) + b.get(i);
            }
        });

        t0.start();
        t1.start();
        t2.start();
        t0.join();
        t1.join();
        t2.join();

        ArrayList<Integer> list = new ArrayList<>(a.size());
        Collections.addAll(list, result);
        return list ;
    }
}
