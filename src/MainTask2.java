import java.util.Random;

public class MainTask2 {

    public static void main(String[] args) {

        int number = 8128;

        int a = 98;
        int b = 35;

        int tossCoin = 1000;

        int beginRange = 1153;
        int endRange = 70000;

        //условное подбрасывание монеты с сообщением результата
        headsOrTails(tossCoin);
        //нахождение наибольшой цифры натурального числа
        maxDigit(number);
        // проверка, является ли заданное натуральное число простым
        if(number > 0){
            if(simpleNumber(number)){
                System.out.println("This is simple number.");
            } else {
                System.out.println("This isn't simple number.");
            }
        } else {
            System.out.println("The number can't be negative.");
        }

        //нахождение всех простых делителей заданного натурального числа
        findSimpleDivisor(number);
        //проверка, является ли заданное натуральное число палиндромом
        checkOnPalindrome(number);
        //нахождение НОД и НОК двух натуральных чисел a и b
        nodAndNok(a,b);
        //нахождение количества различных цифр у заданного натурального числа
        amountDifferentDigit(number);
        //проверка, является ли заданное натуральное число совершенным
        completeNumber(number);
        // поиск всех дружественных чисел в заданном диапазоне
        friendlyNumbers(beginRange,endRange);

    }

    public static void headsOrTails(int tossCoin){
        if(tossCoin > 0) {
            int heads = 0;
            int tails = 0;
            Random rnd = new Random();
            for (int i = 0; i < tossCoin; i++) {
                int result = rnd.nextInt(2);
                if (result > 0) {
                    heads += 1;
                } else {
                    tails += 1;
                }
            }
            System.out.println("Result after " + tossCoin + " toss a coin give us: heads-" + heads + ", tails-" + tails);
        } else {
            System.out.println("The number of toss can't be negative.");
        }
    }

    public static void maxDigit(int number){
        int maxN = 0;
        if(number > 0) {
            String s = String.valueOf(number);
            for (int i = 0; i < s.length(); i++) {
                int temp = number % 10;
                if (temp > maxN) {
                    maxN = temp;
                }
                number /= 10;
            }
            System.out.println("The largest number "+maxN);
        } else {
            System.out.println("The number can't be negative.");
        }
    }

    public static Boolean simpleNumber(int number){
        for(int i = 2; i<=(number/2); i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void findSimpleDivisor(int number){
        String simpleDivisor = "";
        if(number > 0) {
            for (int i = 1; i <= (number / 2); i++) {
                if ((number % i) == 0) {
                    if (simpleNumber(i)) {
                        simpleDivisor += i + ";";
                    }
                }
            }
            System.out.println("The simple divisors: "+simpleDivisor);
        } else {
            System.out.println("The number can't be negative.");
        }
    }

    public static void checkOnPalindrome(int number){
        if(number >= 1) {
            String s = String.valueOf(number);
            int newNumber = 0;

            for (int i = 0; i < s.length(); i++) {
                newNumber += number % 10;
                number /= 10;
                if ((s.length() - i) != 1) {
                    newNumber *= 10;
                }
            }
            if (s.equals(String.valueOf(newNumber))) {
                System.out.println("This number is palindrome.");
            } else {
                System.out.println("This number isn't palindrome.");
            }
        } else {
            System.out.println("The number can't be negative.");
        }
    }

    public static String allDivisors(int number){
        String divisors = "";
        for (int i = 1; i <= (number / 2); i++) {
            if ((number % i) == 0) {
                divisors += i + ",";
            }
        }
        return divisors;
    }

    public static void nodAndNok(int a, int b){

        if(a > 0 && b > 0) {
            String divisorsA = allDivisors(a);
            String divisorsB = allDivisors(b);

            int NOD = 1;
            int NOK;

            for (String number : divisorsB.split(",")) {
                if (divisorsA.contains(String.valueOf(number)) && !number.isEmpty()) {
                    NOD = NOD < Integer.valueOf(number) ? Integer.valueOf(number) : NOD;
                }
            }

            NOK = a * b / NOD;

            System.out.println("NOD of numbers = "+NOD);
            System.out.println("NOK of numbers = "+NOK);
        } else {
            System.out.println("The numbers can't be negative.");
        }
    }

    public static void amountDifferentDigit(int number){
        int amountDigit = 0;
        if(number > 0) {
            for (int i = 0; i <= 9; i++) {
                String digit = String.valueOf(i);
                Boolean result = String.valueOf(number).contains(digit);
                if (result) {
                    amountDigit += 1;
                }
            }
            System.out.println("This number has " + amountDigit + " different digits.");
        } else {
            System.out.println("The number can't be negative.");
        }
    }

    public static int sumDivisors(int number){
        int sum =0;
        for (int i = 1; i <= (number / 2); i++) {
            if ((number % i) == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void completeNumber(int number){
        if(number > 0){
            if(number == sumDivisors(number)){
                System.out.println("This number is complete.");
            } else {
                System.out.println("This number isn't complete.");
            }
        } else {
            System.out.println("The number can't be negative.");
        }
    }

    public static void friendlyNumbers(int beginRange, int endRange){

        String result = "Friendly numbers: \n";

        int sum1;
        int sum2;

        if(beginRange > 0 && endRange > 0) {
            for (int number = beginRange; number <= endRange; number++) {

                sum1 = sumDivisors(number);

                if (sum1 <= endRange && sum1 != number) {

                    sum2 = sumDivisors(sum1);

                    if (sum2 == number) {
                        number = sum2;
                        if (!String.valueOf(result).contains(String.valueOf(number))) {
                            result += number + " " + sum1 + "; \n";
                        }
                    }
                }
            }
            System.out.println(result);
        } else {
            System.out.println("The numbers can't be negative.");
        }
    }

}

