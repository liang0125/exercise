package com.github;

/**
 * Author:lorrie
 * Create:2019/3/16
 */
/*
题目描述
井字棋盘，判断当前玩家是否赢，棋盘为1表示当前玩家
棋盘为0，表示没有棋子
棋盘为-1表示对方玩家
 */
public class Board {
//        public static boolean checkWon(int[][] board) {
//            if(board==null){
//                return false;
//            }
//            for (int i=0;i<3;i++){
//
//                    if((board[0][i]==board[1][i])&&(board[0][i]==board[2][i])&&board[0][i]==1){
//                        return true;
//                    }
//                    if((board[i][0]==board[i][1])&&(board[i][0]==board[i][2])&&board[i][0]==1){
//                        return true;
//                    }
//            }
//
//            if(board[0][0]==1&&board[1][1]==1&&board[2][2]==1) {
//                return true;
//            }
//            if(board[0][2]==1&&board[1][1]==1&&board[2][0]==1) {
//                return true;
//            }
//          return false;
//
//        }

    /*
    题目描述
    X*Y的方格，每次从左上角走到右下角，每次只能向右或者向下走，问有多少种走法？
     */
    public static int countWays(int x, int y) {
        if (x==1||y==1){
            return 1;
        }
        else {
            return countWays(x,y-1)+countWays(x-1,y);
        }
    }

    public static void main(String[] args) {
//            int[][] board={{1,-1,1},{0,1,-1},{1,1,-1}};
        //System.out.println(checkWon(board));
        System.out.println(countWays(4,5));
    }

}
