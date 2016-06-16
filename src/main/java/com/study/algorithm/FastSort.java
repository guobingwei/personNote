package com.study.algorithm;

/**
 * Created by guobing on 2016/6/15.
 */
public class FastSort {

    public static void main(String [] args ) {
        int [] attr = {22, 14, 46, 75, 68, 77, 87, 37, 17, 27, 70};
        sort(attr, 0, attr.length - 1);
        for(int i = 0; i < attr.length; i++) {
            System.out.print(attr[i] + ", ");
        }
    }

    /**
     * 快速排序
     * @param attr
     */
    static void sort(int [] attr, int l, int r) {
        if(l < r) {
            int i = l, j = r, p = attr[l];

            while (i < j) {
                while (attr[i] < p && i < j)
                    i++;

                if(i < j)
                    attr[j--] = attr[i];

                while (attr[j] > p && i < j)
                    j--;

                if(i < j)
                    attr[i++] = attr[j];
            }

            attr[i] = p;
            sort(attr, l, i - 1);
            sort(attr, i + 1, r);
        }
    }

    static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    /**
     * 快速排序 参考网上
     * @param s
     * @param l
     * @param r
     */
    static void quikSort(int s [], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quikSort(s, l, i - 1); // 递归调用
            quikSort(s, i + 1, r);
        }
    }
}
