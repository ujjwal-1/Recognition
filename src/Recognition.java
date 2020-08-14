import java.util.*;
import java.lang.Math;

public class Recognition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your value!! mate");

        String[] matrix = new String[5];
        for (int i = 0; i < 5; i++) {
            matrix[i] = sc.nextLine();
        }





        int[][] weights = { {1,1,1,1,-1,1,1,-1,1,1,-1,1,1,1,1},
                {-1,1,-1,-1,1,-1,-1,1,-1,-1,1,-1,-1,1,-1},
                {1,1,1,-1,-1,1,1,1,1,1,-1,-1,1,1,1},
                {1,1,1,-1,-1,1,1,1,1,-1,-1,1,1,1,1}, {1,-1,1,1,-1,1,1,1,1,-1,-1,1,-1,-1,1},
                {1,1,1,1,-1,-1,1,1,1,-1,-1,1,1,1,1},
                {1,1,1,1,-1,-1,1,1,1,1,-1,1,1,1,1},{1,1,1,-1,-1,1,-1,-1,1,-1,-1,1,-1,-1,1},
                {1,1,1,1,-1,1,1,1,1,1,-1,1,1,1,1}, {1,1,1,1,-1,1,1,1,1,-1,-1,1,1,1,1}};




        int[][] inNurons = new int[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++){
                if (matrix[i].charAt(j) == 'X') {
                    inNurons[i][j] = 1;
                } if (matrix[i].charAt(j) == '_'){
                    inNurons[i][j] = 0;
                }
            }
        }



        int[] bias = new int[10];
        bias = new int[]{-1, 6, 1, 0, 2, 0, -1, 3, -2, -1};

        int[] outputNuron = new int[10];
        int counter = 0;
        int w = 0;
        for(int k = 0; k < 10; k ++){
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 3; j++){
                    counter = counter + (inNurons[i][j] * weights[k][w]);
                    w = w+1;
                    if (i == 4 && j == 2){
                        counter = counter + bias[k];
                        outputNuron[k] = counter;
                        counter = 0;
                        w = 0;
                    }
                }
            }
        }


        int maxVal = outputNuron[0];
        int indexholder = 0;
        for (int i = 0; i < outputNuron.length; i++){
            if(outputNuron[i] > maxVal){
                maxVal = outputNuron[i];
                indexholder = i;
            }
        }

        System.out.println("Input Grid:");
        for (int i = 0; i < 5; i++) {
            System.out.println(matrix[i]);
        }


        System.out.println("This number is " + (indexholder));


    }
}

