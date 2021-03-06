//Brandon Smith and Jackie Fang 12.4.18

import java.util.Arrays;

public abstract class Runner extends SortCompetition {

    public static void main(String[] args){

        SortCompetition team19 = new Team19SortCompetition();
        System.out.println(team19.greeting() + "\n");

        int[] arr1 = randomIntArr(10000, 0, 10000);
        System.out.println("Unsorted: " + Arrays.toString(arr1));
        long duration = System.currentTimeMillis();
        System.out.println("Returns: " + team19.challengeOne(arr1));
        duration = System.currentTimeMillis() - duration;
        System.out.println("Sorted: " + Arrays.toString(arr1));
        System.out.println("Challenge 1 Duration: " + duration * 0.001 + " seconds \n");

        String[] arr2 = randomStrArr(1000,5);
        System.out.println("Unsorted: " + Arrays.toString(arr2));
        duration = System.currentTimeMillis();
        System.out.println("Returns: " + team19.challengeTwo(arr2,"bingo"));
        duration = System.currentTimeMillis() - duration;
        System.out.println("Sorted: " + Arrays.toString(arr2));
        System.out.println("Challenge 2 Duration: " + duration  * 0.001 + " seconds \n");

        int[] arr3 = (partiallySorted());
        System.out.println("Unsorted: ");
        printPartialArr(arr3);
        duration = System.currentTimeMillis();
        System.out.println("Returns: " + team19.challengeThree(arr3));
        duration = System.currentTimeMillis() - duration;
        System.out.println("Sorted: ");
        printPartialArr(arr3);
        System.out.println("Challenge 3 Duration: " + duration * 0.001 + " seconds \n");

        int[][] arr4 = random3DIntArr(1000,10000);
        System.out.println("Unsorted: " + Arrays.toString(arr4[0]));
        duration = System.currentTimeMillis();
        System.out.println("Returns: " + team19.challengeFour(arr4));
        duration = System.currentTimeMillis() - duration;
        System.out.println("Challenge 4 Duration: " + duration  * 0.001 + " seconds \n");

        Things[] arr5 = randomThingsArr(10000);
        System.out.println("Unsorted: " + printThingsArr(arr5));
        Things z = new Things();
        duration = System.currentTimeMillis();
        System.out.println("Returns: " + team19.challengeFive(arr5, z));
        duration = System.currentTimeMillis() - duration;
        System.out.println("Sorted: " + printThingsArr(arr5));
        System.out.println("Challenge 5 Duration: " + duration  * 0.001 + " seconds");
    }

    public static int[] randomIntArr(int length, int min, int max){
        int[] output = new int[length];
        for(int i = 0; i < length; i++){
            output[i] = getRandomInteger(min,max);
        }
        return output;
    }

    public static String[] randomStrArr(int num, int length){
        String[] arr = new String[num];
        while(num > 0){
            int i = 0;
            String s = "";
            while (i < length){
                char c = (char)((Math.random()*26) + 65);
                s += c;
                i++;
            }
            num--;
            arr[num] = s;
        }
        return arr;
    }

    public static int[][] random3DIntArr(int num, int max){
        int[][] arr = new int[num][num];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = getRandomInteger(0,max);
            }
        }
        return arr;
    }

    public static int getRandomInteger(int min, int max){
        return (int)(Math.random()*(max-min));
    }

    public static int[] partiallySorted()
    {
        int[] partial = new int[100000];
        for (int i = 0; i <= 75000; i++)
        {
            partial[i] = i;
        }
        for (int j = 75001; j < 100000; j++)
        {
            partial[j] = (int)(Math.random()*10000);
        }
        return partial;
    }

    public static Things[] randomThingsArr(int num)
    {
        Things[] arr = new Things[num];
        for(int i = 0; i < num; i++){
            arr[i] = new Things();
        }
        return arr;
    }

    public static String printThingsArr(Things[] x){
        String arr = "[";
        for(int i = 0; i < x.length-1; i++){
            arr += x[i].value + ", ";
        }
        arr += x[x.length-1].value + "]";
        return arr;
    }

    public static void printPartialArr(int[] arr){
        String result = "[";
        for(int i = 10000; i < 19999; i++){
            result += arr[i] + ", ";
        }
        result += arr[19999] + "]";
        System.out.println(result);
    }

    /*public static int[] mostlySortedArr(int num) {
        int[] arr = new int[100000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }
        int sorted = 0;
        int x;
        while(sorted < num){
            x = getRandomInteger(0, 99999);
            if(arr[x] < 0){
                arr[x] = getRandomInteger(0, 10000);
                sorted++;
            }
        }
    }*/

}
