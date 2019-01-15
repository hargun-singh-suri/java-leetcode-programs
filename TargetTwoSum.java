import java.util.Arrays;

public class TargetTwoSum {
    //#Problem1

    public static void main(String args[])
    {
        int[] values = {3,2,4};
        int target = 6;
        int [] indexes;
        TargetTwoSum targetTwoSum = new TargetTwoSum();
        indexes = targetTwoSum.getIndexes(values,target);
        System.out.println("Input array "+(Arrays.toString(values)));
        System.out.println("Input target "+target);
        System.out.println("Indexes involved in target value sum "+(Arrays.toString(indexes)));
    }


    int[]  getIndexes(int [] getValue,int getTarget)
    {
        int[] getIndexes;
        getIndexes = new int[2];

        outerloop:
        for(int i = 0; i <= getValue.length-1;i++)
        {
            System.out.println("*************Outer Loop****************" + getValue[i] );
            innerloop:
            for (int j = 0 ; j <= getValue.length-1; j++)
            {
                System.out.println("*************Inner Loop****************" + getValue[j] );
                if(i==j)
                {
                    continue innerloop;
                }
              else if((getValue[i]+getValue[j]) == getTarget)
                {
                    getIndexes[0] = i;
                    getIndexes[1] = j;
                    break outerloop;
                }
            }
        }
        return getIndexes;
    }

}


//o(n^2)