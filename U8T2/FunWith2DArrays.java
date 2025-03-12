package U8T2;
public class FunWith2DArrays {
    public static int totalElements(int[][] twodArray) {
        int total = 0;
        for(int[] row : twodArray) {
            total += row.length;
        }
        return total;
    }

    public static void fourCorners(String[][] strs) {
        System.out.println(strs[0][0]);
        System.out.println(strs[0][strs[0].length - 1]);
        System.out.println(strs[strs.length - 1][0]);
        System.out.println(strs[strs.length - 1][strs[strs.length - 1].length - 1]);
    } 

    public static void swapFrontAndBackRows(String[][] strs) {
        String[] temp = strs[0];
        strs[0] = strs[strs.length - 1];
        strs[strs.length - 1] = temp; 

    }

    public static double average(int[][] array) {
        double average = 0;
        for(int[] row : array) {
            for(int num : row) {
                average += num;
            }
        }
        average = average / (array.length * array[0].length);
        return average;
    }

    public static int edgeSum(int[][] array) {
        int sum = 0;
        for(int i = 0; i < array[0].length; i ++) {
            sum += array[0][i];
        }
        for(int i = 1; i < array.length - 1; i ++ ){
            sum += array[i][0];
            sum += array[i][array[i].length - 1];
        }
        for(int i = 0; i < array[array.length - 1].length; i ++) {
            sum += array[array.length - 1][i];
        }
        return sum;
    }

    public static int[] indexFound(String[][] strs, String target) {
        int[] out = {-1, -1};
        for(int i = 0; i < strs[0].length; i ++) {
            for(int j = 0; j < strs.length; j ++) {
                if(strs[j][i].equals(target)) {
                    out[0] = j;
                    out[1] = i;
                    return out;
                }
            }
        }
        return out;

    }

    public static int[][] split(int[][] numArray, int row, int column) {
        int[][] out = new int[0][0];
        if(row >=0 && row < numArray.length && column >=0 && column < numArray[0].length) {
            out = new int[row + 1][column + 1];
            for(int i = 0; i <= row ; i ++) {
                for(int j = 0; j <= column; j ++) {
                    out[i][j] = numArray[i][j];
                }
            }
        }
        return out;
    }

    public static int[][] invert(int[][] array) {
        int[][] out = new int[array[0].length][array.length];
        for(int i = 0; i < array.length; i ++) {
            for(int j = 0; j < array[0].length; j ++) {
                out[j][i] = array[i][j];
            }
        } 
        return out;
    }
}
