

public class PowOfNumber {

    public static void main(String[] args) {
        System.out.println(myPow(5, 20));
    }


    /**
     * Method used to find a power of number.
     * 
     * Intutaion : Find the power for n / 2 and then multiply it.
     * if negative divide the result by / n
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        double temp;
        if (n == 0)
            return 1;
        // recursively call myPow to find the value for n/2 
        temp = myPow(x, n / 2);


        /**
         * If the number is even
         */
        if (n % 2 == 0)
            // multiply twice to get answer
            return temp * temp;
        else {

            // If number is odd and positive 
            if (n > 0)
                //  multiply the result 
                return x * temp * temp;
            else
                // If the number is negative divide it by x
                return (temp * temp) / x;
        }
    }
}