import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class AddTwoNumbersVer1 {

    public static void main(String args[]) {

        AddTwoNumbersVer1 obj = new AddTwoNumbersVer1();
        LinkedList<Integer> firstLinkedList = new LinkedList<Integer>();
        LinkedList<Integer> secondLinkedList = new LinkedList<Integer>();
        LinkedList<Integer> finalLinkedList = new LinkedList<Integer>();
        long sum = 0 ;
        long firstLnkedListNumber;
        long secondLnkedListNumber;
/*//Input 1
        // 2 -> 4 -> 3
        firstLinkedList.add(2);
        firstLinkedList.add(4);
        firstLinkedList.add(3);

        // 5 -> 6 -> 4
        secondLinkedList.add(5);
        secondLinkedList.add(6);
        secondLinkedList.add(4);*/

//Input 2
        firstLinkedList.add(9);

        secondLinkedList.add(1);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);
        secondLinkedList.add(9);


        firstLnkedListNumber = obj.mergeNumber(firstLinkedList); //o(n)
        secondLnkedListNumber = obj.mergeNumber(secondLinkedList); //o(m)
        System.out.println("reversed value of firstLnkedListNumber " + firstLnkedListNumber);
        System.out.println("reversed value of secondLnkedListNumber " + secondLnkedListNumber);
        sum = firstLnkedListNumber + secondLnkedListNumber ;
        System.out.println("Value of sum " + sum);
        finalLinkedList = obj.createLinkList(sum,finalLinkedList); //o(x)
        System.out.println("Input value ll 1" + (Arrays.toString(new LinkedList[]{firstLinkedList})));
        System.out.println("Input value ll 2" + (Arrays.toString(new LinkedList[]{secondLinkedList})));
        System.out.println("New Linked list" + (Arrays.toString(new LinkedList[]{finalLinkedList})));
    }

    long mergeNumber(LinkedList<Integer> list) {
        long temp = 0;
        double multiplier = 1;

        for (Integer value : list) {
            temp = (long) (temp + (value * multiplier));
            multiplier *= 10;
        }
        return temp;
    }

    LinkedList<Integer> createLinkList(long sum, LinkedList<Integer> finalLinkedList) {

        do {
            finalLinkedList.add((int) (sum%10));
            sum /= 10;
        } while (sum > 0);

        return finalLinkedList;
    }
}
