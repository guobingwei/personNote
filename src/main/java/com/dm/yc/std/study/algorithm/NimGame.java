package com.dm.yc.std.study.algorithm;

/**
 *  description:
 *  You are playing the following Nim Game with your friend: There is a heap of stones on the table,
 *  each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will
 *  be the winner. You will take the first turn to remove the stones.
 *  Both of you are very clever and have optimal strategies for the game.
 *  Write a function to determine whether you can win the game given the number of stones in the heap.
 *  For example, if there are 4 stones in the heap, then you will never win the game:
 *  no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 *
 * Created by guobingwei on 2016/6/24.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    // 这种题高效的做法一定与位运算相关 4 = 2^i，与3做与运算都是0
    public boolean canWinNimBybit(int n) {
        return (n & 3) != 0;
    }
}
