package U8T2_Algorithms;

import java.util.ArrayList;

public class Algorithm2DArrays {
    
    /** Return the sum of all elements of arr that are in the one particular row, 
     *  specified by the row parameter
     *
     *  PRECONDITION:  0 <= row < arr.length (i.e. row is guaranteed to be valid)
     *
     *  @param arr  2D array of ints
     *  @param row  the row to add up
     *  @return  the sum of all elements in row
     
     */
    public static int sumForRow(int[][] arr, int row)
    { /* implement this method */
        int sum = 0; 
        for(int num : arr[row]) {
            sum += num;
        }
        return sum;
    }

    /** Return the sum of all elements of arr that are in the one particular column 
   *
   *  PRECONDITION:  0 <= col < arr[0].length (i.e. col is valid)
   *
   *  @param arr  2D array of ints
   *  @param col  the column to add up
   *  @return  the sum of all elements in column
   */
  public static int sumForColumn(int[][] arr, int col) { 
    /* implement this method */ 
    int sum = 0;
    for(int[] nums : arr) {
        sum += nums[col];
    }
    return sum;
  }

/** Replaces all even integers in arr with 0; all odd integers are unchanged.
   *  It then returns the number of changes that were made.
   *
   *  Example: if arr is {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {4, 6, 8, 3, 5}}
   *  then this method modifies arr to be:
   *           {{1, 0, 3, 0, 5}, {0, 7, 0, 9, 0}, {0, 0, 0, 3, 5}}
   *  and returns 8 (the number of even numbers replaced by 0)
   *
   * POSTCONDITION: this method modifies the original 2D array referenced by arr
   *
   *  @param arr  2D array of ints
   *  @return  the number of changes made
   */
  public static int replaceEvensWithZero(int[][] arr)
  { /* implement this method */
    int replaced = 0;
    for(int i = 0; i < arr.length; i ++) {
        for(int j = 0; j < arr[i].length; j ++) {
            if(arr[i][j] %2 == 0 ) {
                arr[i][j] = 0;
                replaced ++;
            } 
        }
    }
    return replaced;
 } 

 /** Searches through the 2D array wordChart and finds all strings with
   *  length len; these strings are added to an ArrayList and returned.
   *  If no strings have that length, return an empty ArrayList
   *
   *  @param wordChart  2D array of Strings
   *  @parram len  the length of strings to search for
   *  @return  an ArrayList containing all strings in wordChart with length len
   */
  public static ArrayList<String> findStringsOfLength(String[][] wordChart, int len)
  {
     /* implement this method */ 
     ArrayList<String> out = new ArrayList<String>();
     for(String[] row : wordChart) {
        for(String word : row) {
            if(word.length() == len) {
                out.add(word);
            }
        }
     }
     return out;
  }

    /** calculates and returns the average class grade as a double for a
   *  all Students in the 2D array seatingChart
   *
   *  PRECONDITION:  seatingChart contains at least one element with at least
   *                 one student (i.e. no need to worry about division by 0)
   *  
   *  @param seatingChart  2D array of Student objects
   *  @return  the average grade of all Students in seatingChart, as a double
   */
  public static double classAverage(Student[][] seatingChart)
  { 
    /* implement this method */
    double average = 0;
    int studentCount = 0;
    for(Student[] students : seatingChart) {
        for(Student student : students) {
            average += student.getGrade();
            studentCount ++;
        }
    }
    average /= studentCount;
    return average;
}

/** Returns true if any two consecutive elements, horizontally or vertically,
   *  are equal, false otherwise.  You do not need to check for "wrap around"
   *  consecutiveness, such as if the last element in a row is the same as
   *  the first:
   *  
   *  For example, if arr is:
   *      1, 2, 3, 4
   *      2, 7, 3, 5
   *      3, 4, 5, 6
   *
   *  then this method returns true because there is a pair of consecutive
   *  numbers (vertically)
   *
   *  As another example, if arr is:
   *      1, 2, 3, 4
   *      2, 7, 8, 5
   *      3, 4, 4, 6
   *
   *  then this method returns true because there is a pair of consecutive
   *  numbers (horizontally)
   *
   *  As another example, if arr is:
   *      1, 2, 3, 8
   *      2, 7, 8, 5
   *      3, 2, 5, 3
   *
   *  then this method returns false because there are not two consecutive
   *  numbers, vertically or horizontally, that are equal.
   *
   *  NOTE: do not consider "wrap around" consecutive numbers, in other words,
   *  the 3's and 6's below are not considered consecutive:
   *      1, 6, 3, 8
   *      2, 7, 8, 5
   *      3, 6, 5, 3
   *
   *  Similarly, equal numbers on a diagonal are not considered consecutive,
   *  so the 8's below are not consecutive:
   *      1, 2, 3, 8
   *      2, 7, 8, 5
   *      3, 2, 5, 3
   *
   *  @param arr  2D array of ints
   */
  public static boolean consecutive(int[][] arr)
  { 
    /* implement this method */ 
    for(int row = 0; row < arr.length - 1; row ++) {
        for(int col = 0; col < arr[row].length; col ++) {
            if(arr[row][col] == arr[row + 1][col]) {
                return true;
            }
        }
    }
    for(int row = 0; row < arr.length; row ++) {
        for(int col = 0; col < arr[row].length - 1; col ++) {
            if(arr[row][col] == arr[row][col + 1]) {
                return true;
            }
        }
    }
    return false;
  }

 /** A "magic square" is a square grid filled with distinct integers such
   *  that each element is a different integer, and the sum of the integers
   *  in each row, column and diagonal is equal.  This method should return true
   *  if arr is a magic square.
   *
   *  PRECONDITION: arr is a square 2D array with the same number of rows and
   *                columns
   *  
   *  For example, if arr is:
   *      7, 2, 3
   *      0, 4, 8
   *      5, 6, 1
   *
   *  then this method returns true because each row, column, and diagonal add
   *  up to the same sum (12) and all numbers are unique (i.e. no duplicate
   *  values appear)
   *
   *  As another example, if arr is (note the 3 and 2 swapped):
   *      7, 3, 2
   *      0, 4, 8
   *      5, 6, 1
   *
   *  then this method returns false because the column sums no longer add up to
   *  the same value
   *
   *  As another example, if arr is:
   *      1, 2, 3
   *      2, 3, 1
   *      3, 1, 2
   *
   *  then this method returns false because, one diagonal does not sum to 6 and there are duplicate numbers.
   *
   *  @param arr  2D array of ints
   */
  public static boolean magicSquare(int[][] arr)
  { 
    /* implement this method */ 
    int sample = 0;
    for(int i = 0; i < arr[0].length; i ++) {
        sample += arr[0][i];
    }
    for(int i = 0; i < arr.length; i ++) {
        int sum = 0;
        for(int j = 0; j < arr[i].length; j ++) {
            sum += arr[i][j];
        }
        if(sum != sample) {
            return false;
        }
    }

    for(int j = 0; j < arr[0].length; j ++) {
        int sum = 0;
        for(int i = 0; i < arr.length; i ++) {
            sum += arr[i][j];
        }
        if(sum != sample) {
            return false;
        }
    }
    int sumDiag = 0;
    int sumDiagRev = 0;
    for(int i = 0; i < arr.length; i ++) {
        sumDiag += arr[i][i];
        sumDiagRev += arr[i][arr.length - 1 - i];
    } 
    if(sumDiag != sample || sumDiagRev != sample) {
        return false;
    }
    for(int[] elements : arr) {
        for(int element : elements) {
            int same = 0;
            for(int i = 0; i < arr.length; i ++) {
                for(int j = 0; j < arr[i].length; j ++) {
                    if(element == arr[i][j]) {
                        same ++;
                    }
                }
            }
            if(same > 1) {
                return false;
            }
        }
    }

    return true;
  }





    public static void main(String[] args) {
        // int[][] testArr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {4, 6, 8, 3, 5}};
        // System.out.println(Algorithm2DArrays.sumForRow(testArr, 0));
        // System.out.println(Algorithm2DArrays.sumForRow(testArr, 1));
        // System.out.println(Algorithm2DArrays.sumForRow(testArr, 2));
        // System.out.println();
        // int[][] testArr2 = {{3, 4, 5}, {8, 9, 10}, {8, 3, 5}, {1, 2, 3}};
        // System.out.println(Algorithm2DArrays.sumForRow(testArr2, 0));
        // System.out.println(Algorithm2DArrays.sumForRow(testArr2, 1));
        // System.out.println(Algorithm2DArrays.sumForRow(testArr2, 2));
        // System.out.println(Algorithm2DArrays.sumForRow(testArr2, 3));

        // int[][] testArr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {4, 6, 8, 3, 5}};
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr, 0));
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr, 1));
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr, 2));
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr, 3));
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr, 4));
        // System.out.println();
        // int[][] testArr2 = {{3, 4, 5}, {8, 9, 10}, {8, 3, 5}, {1, 2, 3}};
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr2, 0));
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr2, 1));
        // System.out.println(Algorithm2DArrays.sumForColumn(testArr2, 2));
        
        // int[][] testArr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {4, 6, 8, 3, 5}};
        // int changes = Algorithm2DArrays.replaceEvensWithZero(testArr);
        // System.out.println("Number of changes: " + changes);
        // System.out.println("2D Array modified:");
        // for (int[] row : testArr) {
        //     for (int val : row) {
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }
        // int[][] testArr2 = {{2, 2, 4, 4}, {6, 8, 8, 10}, {4, 6, 8, 2}, {4, 2, 4, 6}};
        // changes = Algorithm2DArrays.replaceEvensWithZero(testArr2);
        // System.out.println("\nNumber of changes: " + changes);
        // System.out.println("2D Array modified:");
        // for (int[] row : testArr2) {
        //     for (int val : row) {
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }
        // int[][] testArr3 = {{1, 3, 5}, {7, 5, 9}};
        // changes = Algorithm2DArrays.replaceEvensWithZero(testArr3);
        // System.out.println("\nNumber of changes: " + changes);
        // System.out.println("2D Array not modified:");
        // for (int[] row : testArr3) {
        //     for (int val : row) {
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }
        
        // String[][] words = {{"hi", "bye", "stuff", "goo"}, {"time", "up", "you", "map"}, {"good", "low", "bow", "mom"}};
        // ArrayList<String> returnedList = Algorithm2DArrays.findStringsOfLength(words, 3);
        // System.out.println(returnedList);
        // ArrayList<String> returnedList2 = Algorithm2DArrays.findStringsOfLength(words, 4);
        // System.out.println(returnedList2);
        // ArrayList<String> returnedList3 = Algorithm2DArrays.findStringsOfLength(words, 5);
        // System.out.println(returnedList3);
        // ArrayList<String> returnedList4 = Algorithm2DArrays.findStringsOfLength(words, 6);
        // System.out.println(returnedList4);
        // System.out.println();
        // String[][] words2 = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}};
        // returnedList = Algorithm2DArrays.findStringsOfLength(words2, 1);
        // System.out.println(returnedList);
        // returnedList2 = Algorithm2DArrays.findStringsOfLength(words2, 2);
        // System.out.println(returnedList2);

        // Student s1 = new Student("Abby", 95);
        // Student s2 = new Student("Barb", 98);
        // Student s3 = new Student("Cole", 91);
        // Student s4 = new Student("Dave", 92);
        // Student s5 = new Student("Ellie", 98);
        // Student s6 = new Student("Frank", 87);
        // Student s7 = new Student("George", 93);
        // Student s8 = new Student("Jim", 92);
        // Student s9 = new Student("Kara", 95);
        // Student s10 = new Student("Lenny", 98);
        // Student s11 = new Student("Mona", 100);
        // Student s12 = new Student("Nancy", 99);
        // Student[][] chart = {{s1, s2, s3}, {s4, s5, s6}, {s7, s8, s9}, {s10, s11, s12}};
        // double avg = Algorithm2DArrays.classAverage(chart);
        // System.out.println(avg);
        // Student[][] chart2 = {{s1, s2}, {s4, s5}, {s8, s9}};
        // avg = Algorithm2DArrays.classAverage(chart2);
        // System.out.println(avg);
        // Student[][] chart3 = {{s6}};
        // avg = Algorithm2DArrays.classAverage(chart3);
        // System.out.println(avg);
        
    //     int[][] testArr1 = { // true
    //         {1, 2, 3, 4},
    //         {1, 3, 4, 5},
    //         {3, 4, 5, 6}
    // };
    // int[][] testArr2 = { // true
    //         {1, 2, 3, 4},
    //         {2, 3, 4, 6},
    //         {3, 4, 5, 6}
    // };
    // int[][] testArr3 = { // true
    //         {7, 7, 3, 4},
    //         {2, 3, 4, 5},
    //         {3, 4, 5, 6}
    // };
    // int[][] testArr4 = { // true
    //         {1, 2, 3, 4},
    //         {2, 3, 4, 5},
    //         {3, 4, 2, 2}
    // };
    // int[][] testArr5 = { // true
    //         {1, 2, 3, 4, 5},
    //         {2, 3, 9, 5, 6},
    //         {3, 4, 9, 6, 7},
    //         {4, 5, 6, 7, 8}
    // };
    // int[][] testArr6 = { // true
    //         {1, 2, 3, 4, 5},
    //         {2, 3, 4, 5, 6},
    //         {3, 4, 1, 1, 7},
    //         {4, 5, 6, 7, 8}
    // };
    // int[][] testArr7 = { // true
    //         {1, 2, 3, 4, 5},
    //         {2, 3, 4, 5, 6},
    //         {3, 4, 5, 6, 8},
    //         {4, 5, 6, 7, 8}
    // };
    // int[][] testArr8 = { // true
    //         {1, 2, 3, 4, 5},
    //         {2, 3, 4, 5, 6},
    //         {3, 4, 5, 6, 7},
    //         {4, 5, 6, 8, 8}
    // };
    // int[][] testArr9 = { // false
    //         {1, 2, 3, 4},
    //         {2, 3, 4, 5},
    //         {3, 4, 5, 6}
    // };
    // int[][] testArr10 = { // false
    //         {1, 2, 3, 4, 5},
    //         {2, 3, 4, 5, 6},
    //         {3, 4, 5, 6, 7},
    //         {4, 5, 6, 7, 8}
    // };
    // boolean test1 = Algorithm2DArrays.consecutive(testArr1);
    // System.out.println(test1);
    // boolean test2 = Algorithm2DArrays.consecutive(testArr2);
    // System.out.println(test2);
    // boolean test3 = Algorithm2DArrays.consecutive(testArr3);
    // System.out.println(test3);
    // boolean test4 = Algorithm2DArrays.consecutive(testArr4);
    // System.out.println(test4);
    // boolean test5 = Algorithm2DArrays.consecutive(testArr5);
    // System.out.println(test5);
    // boolean test6 = Algorithm2DArrays.consecutive(testArr6);
    // System.out.println(test6);
    // boolean test7 = Algorithm2DArrays.consecutive(testArr7);
    // System.out.println(test7);
    // boolean test8 = Algorithm2DArrays.consecutive(testArr8);
    // System.out.println(test8);
    // boolean test9 = Algorithm2DArrays.consecutive(testArr9);
    // System.out.println(test9);
    // boolean test10 = Algorithm2DArrays.consecutive(testArr10);
    // System.out.println(test10);
    // if (test1 && test2 && test3 && test4 && test5 && test6 && test7 && test8 && !test9 && !test10) {
    //     System.out.println("\n--- ALL TESTS PASS! ---");
    // } else {
    //     System.out.println("\n!!!!!! TEST FAIL!!!!!!!");
    // }
    
    int[][] testArr1 = {{7, 2, 3}, {0, 4, 8}, {5, 6, 1}};
    int[][] testArr2 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
    int[][] testArr3 = {{2, 16, 13, 3}, {11, 5, 8, 10}, {7, 9, 12, 6}, {14, 4, 1, 15}};
    int[][] testArr4 = {{1, 23, 16, 4, 21}, {15, 14, 7, 18, 11}, {24, 17, 13, 9, 2}, {20, 8, 19, 12, 6}, {5, 3, 10, 22, 25}};
    int[][] testArr5 = {{2, 16, 13, 3}, {11, 5, 8, 10}, {7, 9, 12, 15}, {14, 4, 1, 6}};
    int[][] testArr6 = {{2, 16, 13, 3}, {11, 5, 8, 10}, {7, 9, 12, 6}, {14, 4, 1, 8}};
    int[][] testArr7 = {{7, 3, 2}, {0, 4, 8}, {5, 6, 1}};
    int[][] testArr8 = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
    int[][] testArr9 = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
    int[][] testArr10 = {{0, 4, 8}, {7, 2, 3}, {5, 6, 1}};
    int[][] testArr11 = {{1, 23, 16, 4, 21}, {15, 14, 7, 18, 11}, {24, 26, 13, 9, 2}, {20, 8, 19, 12, 6}, {5, -6, 10, 22, 25}};
    int[][] testArr12 = {{1, 23, 16, 4, 21}, {15, 14, 7, 18, 11}, {24, 27, 13, -1, 2}, {20, 8, 19, 12, 6}, {5, 3, 10, 22, 25}};;
    int[][] testArr13 = {{1, 2, 9}, {4, 15, -7}, {7, -5, 10}};
    int[][] testArr14 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 5}};
    
    
    
    boolean test1 = Algorithm2DArrays.magicSquare(testArr1);
    System.out.println(test1);
    boolean test2 = Algorithm2DArrays.magicSquare(testArr2);
    System.out.println(test2);
    boolean test3 = Algorithm2DArrays.magicSquare(testArr3);
    System.out.println(test3);
    boolean test4 = Algorithm2DArrays.magicSquare(testArr4);
    System.out.println(test4);
    boolean test5 = Algorithm2DArrays.magicSquare(testArr5);
    System.out.println(test5);
    boolean test6 = Algorithm2DArrays.magicSquare(testArr6);
    System.out.println(test6);
    boolean test7 = Algorithm2DArrays.magicSquare(testArr7);
    System.out.println(test7);
    boolean test8 = Algorithm2DArrays.magicSquare(testArr8);
    System.out.println(test8);
    boolean test9 = Algorithm2DArrays.magicSquare(testArr9);
    System.out.println(test9);
    boolean test10 = Algorithm2DArrays.magicSquare(testArr10);
    System.out.println(test10);
    boolean test11 = Algorithm2DArrays.magicSquare(testArr11);
    System.out.println(test11);
    boolean test12 = Algorithm2DArrays.magicSquare(testArr12);
    System.out.println(test12);
    boolean test13 = Algorithm2DArrays.magicSquare(testArr13);
    System.out.println(test13);
    boolean test14 = Algorithm2DArrays.magicSquare(testArr14);
    System.out.println(test14);
    if (test1 && test2 && test3 && test4 && !test5 && !test6 && !test7 && !test8 && !test9 && !test10 && !test11 && !test12 && !test13 && !test14) {
        System.out.println("\n--- ALL TESTS PASS! ---");
    } else {
        System.out.println("\n!!!!!! TEST FAIL!!!!!!!");
    }
    
    }
}
  