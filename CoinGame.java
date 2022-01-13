package CoinGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoinGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCoinStacks = sc.nextInt();
        if (numberOfCoinStacks < 2) {
            System.out.println("no");
            System.exit(0);
        }
        int[] coins = new int[numberOfCoinStacks];
        ArrayList<Integer> moves = new ArrayList<>();

        for (int i = 0; i < numberOfCoinStacks; i++) {
            int numberOfCoins = sc.nextInt();
            coins[i] = numberOfCoins;
        }
        if (!coinsChek(coins)) {
            System.out.println("no");
            System.exit(0);
        }

        while(coinsSum(coins) > 0){
            int a = Arrays.stream(coins).max().getAsInt();
            int indexOfA = getIndex(a, coins);
            coins[indexOfA] = 0;
            int b = Arrays.stream(coins).max().getAsInt();
            int indexOfB = getIndex(b, coins);
            if(b == 0){
                System.out.println("no");
                System.exit(0);
            }
            coins[indexOfB] = 0;
                a--;
                b--;
                moves.add(indexOfA + 1);
                moves.add(indexOfB + 1);
                coins[indexOfA] = a;
                coins[indexOfB] = b;
            }

        System.out.println("yes");
        for (int q = 0; q < moves.size(); q++) {
            int w = moves.get(q);
            int e = moves.get(q + 1);
            System.out.println(w + " " + e);
            q++;
        }
    }

    private static int getIndex(int a, int[] coins) {
        int index = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] == a){
                index = i;
                return index;
            }
        }
        return index;
    }

    private static int coinsSum(int [] coins){
        int sum = 0;
        for(int i = 0; i < coins.length; i++){
            sum += coins[i];
        }
        return sum;
    }

    private static boolean coinsChek(int[] coins) {
        int summa = 0;
        for(int i = 0; i < coins.length; i++){
            summa += coins[i];
        }
        if(summa % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
