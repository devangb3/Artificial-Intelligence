import java.util.*;
public class NQueensBranchNBound{
    public static void bnb(boolean[][] chess, int row, boolean[] cols,
                           boolean[] ndiag, boolean[] rdiag, String qsf) {
        if(row==chess.length) {
            System.out.println(qsf);
        }
        for(int col=0; col<chess[0].length; col++) {
            if(!cols[col] && !ndiag[row+col] && !rdiag[row-col+chess.length-1]) {
                chess[row][col] = true;
                cols[col] = true;
                ndiag[row+col] = true;
                rdiag[row-col+chess.length-1] = true;
                bnb(chess,row+1,cols,ndiag,rdiag,qsf+row+"-"+col+",");
                chess[row][col] = false;
                cols[col] = false;
                ndiag[row+col] = false;
                rdiag[row-col+chess.length-1] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        boolean[][] chess = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        bnb(chess,0,cols,ndiag,rdiag,"");
    }
}