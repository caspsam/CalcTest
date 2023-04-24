// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException
    {

        String StrH;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StrH = reader.readLine();
        StrH.replace(" ","");

        StrH = calc(StrH);

        System.out.println(StrH);
        System.out.println("Good day.");

    }
    public static String calc(String input) {

        String StrH, Str1, Str2;
        int[] znak = new int[100];
        int first = 0, second = 0, nzn = 0, res = 0, edin = 0, des = 0;

        StrH =input;

        if (StrH.indexOf("+") > 0 ){
            nzn = StrH.indexOf("+");
            znak[nzn] = 1;
            if (StrH.indexOf("+",nzn+1) > 0 ){ return "Throws Exception - more than one operator !"; }
        }
        if (StrH.indexOf("-") > 0 ){
            if (nzn > 0) { return "Throws Exception - more than one operator !"; }
            nzn = StrH.indexOf("-");
            znak[nzn] = 2;
            if (StrH.indexOf("-",nzn+1) > 0 ){ return "Throws Exception - more than one operator !"; }
        }
        if (StrH.indexOf("*") > 0 ){
            if (nzn > 0) { return "Throws Exception - more than one operator !"; }
            nzn = StrH.indexOf("*");
            znak[nzn] = 3;
            if (StrH.indexOf("*",nzn+1) > 0 ){ return "Throws Exception - more than one operator !"; }
        }
        if (StrH.indexOf("/") > 0 ){
            if (nzn > 0) { return "Throws Exception - more than one operator !"; }
            nzn = StrH.indexOf("/");
            znak[nzn] = 4;
            if (StrH.indexOf("/",nzn+1) > 0 ){ return "Throws Exception - more than one operator !"; }
        }

        // проконтролируем допустимость выражения
        if (nzn == 0) { return "Throws Exception - no operator !"; }
        else {  // продолжаем анализ выражения
            Str1 = StrH.substring(0, nzn);
            Str2 = StrH.substring(nzn + 1, StrH.length());

            if (isNumeric(Str1)) {
                first = Integer.valueOf(Str1);
            }
            if (isNumeric(Str2)) {
                second = Integer.valueOf(Str2);
            }
            if (first == 0 && second != 0) {
                return "Throws Exception - paramaters are diffrent !";
            } else if (first != 0 && second == 0) {
                return "Throws Exception - paramaters are diffrent !";
            } else if (first > 10 || second > 10) {
                return "Throws Exception - paramaters can't be more 10 !";
            } else if (first == 0 && second == 0) {   //  выражение задано римскими цифрами

                Str1 = Str1.toUpperCase();
                switch (Str1.length()) {    // определяем первый параметр
                    case 1:         // варианты I - V - X
                        if (Str1.equals("I")) {
                            first = 1;
                        } else if (Str1.equals("V")) {
                            first = 5;
                        } else if (Str1.equals("X")) {
                            first = 10;
                        } else {
                            first = 11;
                        }
                        break;
                    case 2:         // варианты II - IV - VI - IX
                        if (Str1.equals("II")) {
                            first = 2;
                        } else if (Str1.equals("IV")) {
                            first = 4;
                        } else if (Str1.equals("VI")) {
                            first = 6;
                        } else if (Str1.equals("IX")) {
                            first = 9;
                        } else {
                            first = 11;
                        }
                        break;
                    case 3:         // варианты III - VII
                        if (Str1.equals("III")) {
                            first = 3;
                        } else if (Str1.equals("VII")) {
                            first = 7;
                        } else {
                            first = 11;
                        }
                        break;
                    case 4:         // варианты VIII
                        if (Str1.equals("VIII")) {
                            first = 8;
                        } else {
                            first = 11;
                        }
                        break;
                }
                Str2 = Str2.toUpperCase();
                switch (Str2.length()) {    // определяем первый параметр
                    case 1:         // варианты I - V - X
                        if (Str2.equals("I")) {
                            second = 1;
                        } else if (Str2.equals("V")) {
                            second = 5;
                        } else if (Str2.equals("X")) {
                            second = 10;
                        } else {
                            second = 11;
                        }
                        break;
                    case 2:         // варианты II - IV - VI - IX
                        if (Str2.equals("II")) {
                            second = 2;
                        } else if (Str2.equals("IV")) {
                            second = 4;
                        } else if (Str2.equals("VI")) {
                            second = 6;
                        } else if (Str2.equals("IX")) {
                            second = 9;
                        } else {
                            second = 11;
                        }
                        break;
                    case 3:         // варианты III - VII
                        if (Str2.equals("III")) {
                            second = 3;
                        } else if (Str2.equals("VII")) {
                            second = 7;
                        } else {
                            second = 11;
                        }
                        break;
                    case 4:         // варианты VIII
                        if (Str2.equals("VIII")) {
                            second = 8;
                        } else {
                            second = 11;
                        }
                        break;
                }
                switch (znak[nzn]) {
                    case 1:
                        res = first + second;
                        break;
                    case 2:
                        res = first - second;
                        break;
                    case 3:
                        res = first * second;
                        break;
                    case 4:
                        res = (int) Math.floor(first / second);
                        break;
                }
                if (res < 1) {
                    return "Throws Exception - in Roman dimension negative numbers or zero aren't avalable !";
                } else if (first > 10 || second > 10) {
                    return "Throws Exception - paramaters can't be more X !";
                } else {
                    des = (int) Math.floor(res / 10) * 10;
                    edin = res - des;
                    switch (edin) {
                        case 1:
                            Str2 = "I";
                            break;
                        case 2:
                            Str2 = "II";
                            break;
                        case 3:
                            Str2 = "III";
                            break;
                        case 4:
                            Str2 = "IV";
                            break;
                        case 5:
                            Str2 = "V";
                            break;
                        case 6:
                            Str2 = "VI";
                            break;
                        case 7:
                            Str2 = "VII";
                            break;
                        case 8:
                            Str2 = "VIII";
                            break;
                        case 9:
                            Str2 = "IX";
                            break;
                        case 10:
                            Str2 = "X";
                            break;
                        default:
                            Str2 = "0";
                            break;
                    }
                    switch (des) {
                        case 10:
                            Str1 = "X";
                            break;
                        case 20:
                            Str1 = "XX";
                            break;
                        case 30:
                            Str1 = "XXX";
                            break;
                        case 40:
                            Str1 = "XL";
                            break;
                        case 50:
                            Str1 = "L";
                            break;
                        case 60:
                            Str1 = "LX";
                            break;
                        case 70:
                            Str1 = "LXX";
                            break;
                        case 80:
                            Str1 = "LXXX";
                            break;
                        case 90:
                            Str1 = "XC";
                            break;
                        case 100:
                            Str1 = "C";
                            break;
                        default:
                            Str1 = "";
                            break;
                    }
                    return ("Result is " + Str1 + Str2 + ".");
                }
            } else {                                  // выражение задано арабскими цифрами
                switch (znak[nzn]) {
                    case 1:
                        res = first + second;
                        break;
                    case 2:
                        res = first - second;
                        break;
                    case 3:
                        res = first * second;
                        break;
                    case 4:
                        res = (int) Math.floor(first / second);
                        break;
                }

                return ("Result is " + res + ".");
            }

        }
    }
    private static boolean isNumeric(String str) { return str != null && str.matches("[0-9.]+"); }
}
