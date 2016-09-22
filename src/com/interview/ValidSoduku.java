package com.interview;

import java.util.HashSet;

/**
 * Created by arjun on 2/29/16.
 */
public class ValidSoduku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            if(!isValid(i,i,0,8, board) || !isValid(0,8,i,i, board))
                return false;
        }
        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
            {
                if(!isValid(i*3,i*3+2,j*3,j*3+2, board))
                    return false;
            }
        }
        return true;
    }
    public boolean isValid(int x1, int x2,int y1, int y2, char[][] board)
    {
        HashSet<Character> h1=new HashSet<>();
        for(int i=x1; i<=x2; i++)
        {
            for(int j=y1; j<=y2; j++)
            {
                if(board[i][j]!='.') {
                    if (!h1.add(board[i][j]))
                        return false;
                    else
                        h1.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSoduku vs=new ValidSoduku();
        String[] arr={"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
        char[][] board= new char[9][9];
        for(int i=0;i<arr.length;i++)
        {
            board[i]=arr[i].toCharArray();
        }
        System.out.print(vs.isValidSudoku(board));
    }
}