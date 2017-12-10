package com.gmail.zhukvitaliis;

public class Main {
    static int[] combinatins = new int[200];
    static int[] buckets = {1, 2, 5, 10};
    static int count = 0;

    public static void main(String[] args) {
        int min = 10;
        int max = 200;
        int rnd = getRandom(min, max);
        System.out.println("n= " + rnd);
        parse(rnd, rnd, 0);
        System.out.println("Кількість комбінацій = " + count);
    }
    static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    static void parse(int n, int k, int i) {
        if (n == 0) {
            int fiveLiters=0;
            int oneLiter=0;
            int twoLiters=0;
            int fourLiters=0;
            System.out.print(count+1 +") ");
            for (int j = 0; j < i; j++) {
                if (combinatins[j] == 5) {
                    fiveLiters += 1;
                } else {
                    if (combinatins[j] == 1) {
                        oneLiter += 1;
                } else {
                    if (combinatins[j] == 2) {
                        twoLiters = twoLiters + 1;
                } else {
                    if (combinatins[j] == 10) {
                        fourLiters = fourLiters + 1;
                            }
                        }
                    }
                }
            }
            if(fiveLiters!=0 & (oneLiter!=0)) {
                System.out.print(fiveLiters + " по 5л +  ");
            }if(fiveLiters!=0 & (oneLiter==0)) {
                System.out.print(fiveLiters + " по 5л ");
            }
            if(oneLiter!=0 & (twoLiters!=0)) {
                System.out.print(oneLiter + " по 1л + ");
            }
            if(oneLiter!=0 & (twoLiters==0)) {
                System.out.print(oneLiter + " по 1л ");
            }
            if(twoLiters!=0 & (fourLiters!=0)) {
                System.out.print(twoLiters + " по 2л + ");
            }
            if(twoLiters!=0 & fourLiters==0) {
                System.out.print(twoLiters + " по 2л ");
            }
            if(fourLiters!=0) {
                System.out.print(fourLiters + " по 10л ");
            }
            System.out.println();
            count++;
        } else {
            for (int bucket : buckets) {
                if (n >= k & (k == bucket)) {
                    combinatins[i] = k;
                    parse(n - k, k, i + 1);
                }
            }
            if (k > 1) {
                parse(n, k - 1, i);
            }
        }
    }
}
