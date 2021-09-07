public class gridSearch {

    public static boolean search(String[][] grid, String[][] pattern){
        boolean result = false;
        String pattern_start = pattern[0][0];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==pattern_start){
                    if(isMatched(grid, i, j, pattern)){
                        // System.out.println("YES");
                        result = true;
                    }else{
                        // System.out.println("NO");
                        result = false;
                    }
                }

                if(result) break;
            }
        }
        return result;
    }

    public static boolean isMatched(String[][] grid, int i, int j, String[][] pattern){
        if(i>grid.length-pattern.length || j>grid[0].length-pattern[0].length) return false;
        
        int rowG = i, colG = j;
        for(int k=0; k<pattern.length; k++){
            for(int l=0; l<pattern[0].length; l++){
                if(grid[rowG][colG]!=pattern[k][l]){
                    return false;
                }else{
                    colG++;
                }
            }
            rowG++;
            colG = j;
        }

        return true;
    }

    public static void main(String[] args){
        String[][] grid = new String[][]{{"7","2","8","3","4","5","5","8","6","4"},
                                         {"6","7","3","1","1","5","8","6","1","9"},
                                         {"8","9","8","8","2","4","2","6","4","3"},
                                         {"3","8","3","0","5","8","9","3","2","4"},
                                         {"2","2","2","9","5","0","5","8","1","3"},
                                         {"5","6","3","3","8","4","5","3","7","4"},
                                         {"6","4","7","3","5","3","0","2","9","3"},
                                         {"7","0","5","3","1","0","6","6","0","1"},
                                         {"0","8","3","4","2","8","2","9","5","6"},
                                         {"4","6","0","7","9","2","4","1","3","7"}};
        String[][] pattern = new String[][]{{"9","5","0","5"},
                                            {"3","8","4","5"},
                                            {"3","5","3","0"}};
        System.out.print(search(grid, pattern));
    }
    
}
