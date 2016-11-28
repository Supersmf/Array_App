import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg on 27.11.2016.
 */
public class My_Array {

    private int[][] arr;
    private int m, n;


    public My_Array(int m, int n) {
        this.m = m;
        this.n = n;
        arr = new int[m][n];
    }

    public boolean addValue(String[] value){

        try{
            if(value.length != m*n) return false;
            int index = 0;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    String str = value[index++].trim();
                    int temp = Integer.parseInt(str);
                    arr[i][j] = temp;
                }
            }
        }catch (Exception ex){
            System.out.println("You wrote the wrong values, try again!");
            return false;
        }

        return true;
    }

    public void removeColumnsWithMinValue() {

        int minValue = Integer.MAX_VALUE;
        Set<Integer> removeColumn = new HashSet<Integer>();

        // Finds columns with minimum value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < minValue) {
                    minValue = arr[i][j];
                    removeColumn.clear();
                    removeColumn.add(j);
                } else if (arr[i][j] == minValue) {
                    removeColumn.add(j);
                }
            }
        }
        System.out.println("\nMin value: " + minValue);
        System.out.println("Columns with min value: " + removeColumn.toString() + "\n");

        int offSet = 0;

        // Remove columns with minimum value
        for (int del : removeColumn) {
            int[][] temp = new int[m][--n];
            del = del - offSet++;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j >= del)
                        temp[i][j] = arr[i][j++];
                    else
                        temp[i][j] = arr[i][j];
                }
            }
            arr = temp;
        }
    }

    public void print(){
        for(int i = 0; i < m;i++){
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
