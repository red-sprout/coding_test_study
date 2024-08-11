package com.practice.pro15638;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static Scanner sc;
    private static UserSolution usersolution = new UserSolution();

    static final int MAX_N = 25;
    static final int MAX_L = 10;

    static final int CMD_INIT = 100;
    static final int CMD_DESTROY = 200;
    static final int CMD_ALLY = 300;
    static final int CMD_ATTACK = 400;
    static final int CMD_RECRUIT = 500;

    static int [][] Sol= new int [MAX_N][MAX_N];
    static char [][][] Monarch = new char [MAX_N][MAX_N][MAX_L+1];

    private static void String2Char(char[] buf, String str) {
        Arrays.fill(buf, (char)0);
        for (int i = 0; i < str.length(); ++i)
            buf[i] = str.charAt(i);
        buf[str.length()] = '\0';
    }

    private static int run() throws IOException {
        int isOK = 0;

        int mN;
        char[] mMonarchA= new char [MAX_L + 1];
        char[] mMonarchB = new char [MAX_L + 1];
        char[] mGeneral= new char [MAX_L + 1];
        int mOption;
        int num;

        int N = sc.nextInt();
        int cmd, result, check;

        for (int c = 0; c < N; ++c) {

            cmd =  sc.nextInt();
            switch (cmd) {
            case CMD_INIT:
                mN = sc.nextInt();
                for (int j = 0; j < mN; j++)
                    for (int i = 0; i < mN; i++)
                        Sol[j][i] =  sc.nextInt();

                for (int j = 0; j < mN; j++)
                    for (int i = 0; i < mN; i++)
                        String2Char(Monarch[j][i],  sc.next());

                usersolution.init(mN, Sol, Monarch);
                isOK = 1;
                break;

            case CMD_ALLY:
                String2Char(mMonarchA,  sc.next());
                String2Char(mMonarchB,  sc.next());
                result = usersolution.ally(mMonarchA, mMonarchB);
                check = sc.nextInt();
                if (result != check)
                    isOK = 0;
                break;

            case CMD_ATTACK:
                String2Char(mMonarchA,  sc.next());
                String2Char(mMonarchB,  sc.next());
                String2Char(mGeneral,  sc.next());
                result = usersolution.attack(mMonarchA, mMonarchB, mGeneral);
                check = sc.nextInt();
                if (result != check)
                    isOK = 0;
                break;

            case CMD_RECRUIT:
                String2Char(mMonarchA,  sc.next());
                num = sc.nextInt();
                mOption = sc.nextInt();
                result = usersolution.recruit(mMonarchA, num, mOption);
                check = sc.nextInt();
                if (result != check)
                    isOK = 0;
                break;
            }
        }
        usersolution.destroy();
        return isOK;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;
        System.setIn(new java.io.FileInputStream("res/b/input15638.txt"));
        sc = new Scanner(System.in);

        T = sc.nextInt();
        MARK = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            if (run() == 1)
                System.out.println("#" + tc + " " + MARK);
            else
                System.out.println("#" + tc + " 0");
        }
        sc.close();
    }
}
