public class Exercise {

    public static void main(String[] args) {
        int[][] array = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};

        for (int[] i: array){ //i represents each row in the array. if printed it will display the address of the array
            for (int j:i){ //j represents each individual element of i
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }



}
