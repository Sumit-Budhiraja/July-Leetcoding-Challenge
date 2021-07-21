import java.util.Arrays;

public class Solution {

    public String pushDominoes(String dominoes) {
        char[] array = dominoes.toCharArray();

        for (int i = 0; i < array.length; i++) {

            if (array[i] == '.') {

                int uprightPieces = 0;
                char leftChar = i > 0 ? array[i - 1] : '\0';
                int leftIndex = i;

                while (i < array.length && array[i] == '.') {
                    uprightPieces++;
                    i++;
                }
                
                //Case "R....." and case "R....R" => fill with 'R'.
                if ((i == array.length || array[i] == 'R') && leftChar == 'R') {
                    Arrays.fill(array, leftIndex, i, 'R');
                } 
                
                //Case "......L" and case "L....L" => fill with 'L'.
                else if ((leftIndex == 0 || leftChar == 'L') && i < array.length && array[i] == 'L') {
                    Arrays.fill(array, leftIndex, i, 'L');
                } 
                
                //Case "R.....L" => fill with equal number of 'R' and 'L'. 
                //If the number of '.' is odd, the middle should be left '.'.
                else if (leftChar == 'R' && array[i] == 'L') {
                    int endIndex_fill_R = leftIndex + (uprightPieces / 2);
                    int startIndex_fill_L = leftIndex + (uprightPieces / 2) + (uprightPieces % 2);
                    Arrays.fill(array, leftIndex, endIndex_fill_R, 'R');
                    Arrays.fill(array, startIndex_fill_L, i, 'L');
                }
                i--;
            }

        }
        return String.valueOf(array);
    }

}