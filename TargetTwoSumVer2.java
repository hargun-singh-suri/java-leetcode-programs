import java.util.Arrays;
import java.util.HashMap;

public class TargetTwoSumVer2 {

    public static void main(String args[]) {
        int[] values = {3, 2, 4};
        int target = 6;
        int[] indexes;
        TargetTwoSumVer2 targetTwoSum = new TargetTwoSumVer2();
        indexes = targetTwoSum.getIndexes(values, target);
        System.out.println("Input array " + (Arrays.toString(values)));
        System.out.println("Target Value " + target);
        System.out.println("Indexe Value of item which sum up to target" + (Arrays.toString(indexes)));
    }


    int[] getIndexes(int[] getValue, int getTarget) {
        int[] getIndex = new int[2];
        HashMap hm = new HashMap();

        for (int i = 0; i <= getValue.length - 1; i++) {
            hm.put(getTarget - getValue[i], i);
        }

        for (int i = 0; i <= getValue.length - 1; i++) {
            if (hm.containsKey(getValue[i]) && ((int) hm.get(getValue[i]) != i)) {
                getIndex[0] = i;
                getIndex[1] = (int) hm.get(getValue[i]);
                return getIndex;
            }
        }

        throw new IllegalArgumentException("Sum not possible with current input array");
    }
}

//o(n)