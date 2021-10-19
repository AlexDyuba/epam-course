
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;
public class Solution {

    public static void main(String[] args) {
//        System.out.println(countZ(2, 3, 4));
//        System.out.printf("%.2f\n", countFormula(2, 3, 4));
//        System.out.println(swapNumber(234.578));
//        System.out.println(countTime(12312));
//        System.out.println(findSum(5));
//        System.out.println(findResFunction(1, 10, 0.5).toString());
//        System.out.println(findSum100());
//        System.out.println(findMultiplyPow200().toString());
//        System.out.println(findSumLine(0.001));
//        showSymbolAndCode();
//        System.out.println(findDivide(2, 20));
//        System.out.println(isEqualsNumber(12, 13));
//        System.out.println(isEqualsNumber(1234593490, 542222100));
    }
    // Line program
    // 1
    public static double countZ(double a, double b, double c) {
        return ((a - 3) * b / 2) + c;
    }
    // 2
    public static double countFormula(double a, double b, double c) {
        return (b + sqrt(pow(b, 2) + 4 * a * c)) / (2 * a) - pow(a, 3) * c + pow(b, -2);
    }
    // 3
    public static double countTreg(double x, double y) {
        return (sin(x) + cos(y)) / (cos(x) - sin(y)) * tan(x * y);
    }
    // 4
    public static double swapNumber(double number) {
        return number * 1000 % 1000 + (int) number / 1000.0;
    }
    // 5
    public static String countTime(int allSeconds) {
        int hours = allSeconds / 3600;
        int minutes = allSeconds % 3600 / 60;
        int seconds = allSeconds % 60;
        StringBuilder string = new StringBuilder("00ч 00мин 00с");
        string.setCharAt(0, (char) (hours / 10 + '0'));
        string.setCharAt(1, (char) (hours % 10 + '0'));
        string.setCharAt(4, (char) (minutes / 10 + '0'));
        string.setCharAt(5, (char) (minutes % 10 + '0'));
        string.setCharAt(10, (char) (seconds / 10 + '0'));
        string.setCharAt(11, (char) (seconds % 10 + '0'));
        return string.toString();
    }
    // 6
    public static boolean isArea(double x, double y) {
        return (x >= -4 && x <= 4 && y >= -3 && y <= 0) || (x >= -2 && x <= 2 && y >= 0 && y <= 4);
    }
    // if .. else program
    // 1
    public static boolean[] isTriangle(int angleA, int angleB) {

        boolean[] answer = {false, false};
        if (angleA + angleB < 180) {
            answer[0] = true;
            answer[1] = isTriangle90(angleA, angleB);
        }
        return answer;
    }

    public static boolean isTriangle90(int angleA, int angleB) {
        return angleA + angleB == 90;
    }
    // 2
    public static double findMax(double a, double b, double c, double d) {
        return max(min(a, b), min(c, d));
    }
    // 3
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean isLine(Point A, Point B, Point C) {
        return (C.x - A.x) / (B.x - A.x) == (C.y - A.y) / (B.y - A.y);
    }
    // 4
    public static boolean isBrick(int sideA, int sideB, int sideBrickX, int sideBrickY, int sideBrickZ) {
        return ((sideA >= sideBrickX && sideB >= sideBrickY)
                || (sideA >= sideBrickY && sideB >= sideBrickX)
                || (sideA >= sideBrickX && sideB >= sideBrickZ)
                || (sideA >= sideBrickZ && sideB >= sideBrickX)
                || (sideA >= sideBrickZ && sideB >= sideBrickY)
                || (sideA >= sideBrickY && sideB >= sideBrickZ)
        );
    }
    // 5
    public static double findResult(double x) {
        double result;
        if(x <= 3) {
            result = pow(x, 2) - 3 * x + 9;
        } else {
            result = 1/(pow(x,3) + 6);
        }
        return result;
    }

    // cycles
    // 1
    public static int findSum(int n) {
        int result = 0;
        while (n > 0) {
            result += n--;
        }
        return result;
    }
    // 2
    public static List<Double> findResFunction(double a, double b, double step) {
        List<Double> list = new ArrayList<>();
        for (double x = a; x <= b; x += step) {
            if(x <= 2) {
                list.add(-x);
            } else {
                list.add(x);
            }
        }
        return list;
    }
    // 3
    public static int findSum100() {
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += pow(i, 2);
        }
        return result;
    }
    // 4 произведение квадратов первых двухсот чисел
    public static BigInteger findMultiplyPow200() {
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 2; i <= 200; i++) {
            sum = sum.multiply(BigInteger.valueOf((long)pow(i, 2)));
        }
        return sum;
    }
    // 5
    // an = 1 / 2^n + 1 / 3^n;
    public static double findSumLine(double e) {
       // n = 0 or n = 1 where is it start ?
        int n = 1;
        double sum = 2; // sum an0
        double tempSum;
        do {
            tempSum = sum;
            sum += 1 / pow(2, n) + 1 / pow(3, n);
            n++;
        } while(abs(sum - tempSum) > e);

        return tempSum;
    }
    //6
    //symbol - number ????
    public static void showSymbolAndCode() {
        for (int i = 0; i <= 65535; i++) {
            System.out.println((char)i);
        }
    }
    // 7
    public static Map<Integer, List<Integer>> findDivide(int m, int n) {
        ArrayList[] list = new ArrayList[n - m + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 2; j <= (m + i) / 2; j++) {
                if ((m + i) % j == 0) {
                    list[i].add(j);
                }
            }
            map.put(m + i, list[i]);
        }
        return map;
    }
    // 8 даны два числа определить какие цифры входят как в первое так и во второе
    // не нравится решение, но хочется спать)
    public static List<Integer> isEqualsNumber(int a, int b) {
        Integer integer = a;
        Integer integer1 = b;
        List<Integer> res = new ArrayList<>();
        char[] msA = integer.toString().toCharArray();
        char[] msB = integer1.toString().toCharArray();
        List<Character> res1 = new ArrayList<>();
        for (Character i : msB) {
            res1.add(i);
        }
        List<Character> list = new ArrayList<>();
        for (Character i : msA) {
            if(list.contains(i)) {
                continue;
            } else {
                list.add(i);
            }
        }
        for (Character i : list) {
            if(res1.contains(i)) {
                res.add(Integer.parseInt(i + ""));
            }
        }
        return res;
    }

}
