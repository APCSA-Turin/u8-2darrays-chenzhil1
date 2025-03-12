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
}
