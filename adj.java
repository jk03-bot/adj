import java.io.*;
import java.util.*;
class adj
{
    public static void getCofactor(int[][] mat,int[][] temp,int p,int q,int n)
    {
        int row=0,col=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=p && j!=q)
                {
                    temp[row][col++]=mat[i][j];
                    if(col==n-1)
                {
                    col=0;
                    row++;
                }
                    
                }
                
            }
        }
    }
    public static int determinant(int[][] mat,int n)
    {
        int det=0;
        if(n==1)
        {
            return mat[0][0];
        }
        if(n==2)
        {
            return mat[0][0]*mat[1][1]-mat[1][0]*mat[0][1];
        }
        int sign=1;
        int[][] temp=new int[n-1][n-1];
        for(int f=0;f<n;f++)
        {
            getCofactor(mat,temp,0,f,n);
            det=det+sign*mat[0][f]*determinant(temp,n-1);
            sign=-sign;
        }
        return det;
    }
    public static int[][] adjoint(int[][] mat)
    {
        int n=mat.length;
        int[][] adj=new int[n][n];
        if(n==1)
        {
            adj[0][0]=1;
            return adj;
        }
        int sign=1;
        int[][] temp=new int[n-1][n-1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                getCofactor(mat,temp,i,j,n);
                sign=((i+j)%2==0)?1:-1;
                adj[i][j]=sign*determinant(temp,n-1);
            }   
        }
        return adj;

    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
       int n=in.nextInt();
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat[i][j]=in.nextInt();
            }
        }
        int result[][]=adjoint(mat);
        for(int[] row:result)
        {
            for(int num:row)
            {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}