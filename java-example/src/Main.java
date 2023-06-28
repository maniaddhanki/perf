import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<Integer> populateArray(int count){
        int min = 100;
        int max = 400;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            array.add((int)(Math.random()*(max-min+1)+min));
        }

        return array;
    }

    public static int median(ArrayList<Integer> numbers){
        Collections.sort(numbers);
        return numbers.get(numbers.size()/2);
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> nums = populateArray(100000); //1,00,000
        long medianStart = System.currentTimeMillis();
        int median = median(nums);
        System.out.println("time taken for median is : " + (System.currentTimeMillis() - medianStart) + " ms");
        System.out.println("median = " + median);

        //--------------------multi threading example
        long additionStart = System.currentTimeMillis();
        ArrayList<Integer> sum = ArrayAddition.parallelAddition(nums,nums);
        System.out.println("time taken for addition is : " + (System.currentTimeMillis() - additionStart) + " ms");
        System.out.println("result size "  + sum.size());

    }

}