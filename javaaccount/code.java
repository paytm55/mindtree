import java.util.Scanner;
public class JavaExample
{
    /* This array is to determine the factorial of single digit quickly
     * (factorials of 0 to 9 stored)
     */
    static long[] factorial = new long[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");

        //storing the input number in the variable num
        int num = scan.nextInt();

        /* now we are calling our user-defined function to check whether
         * the input number is Peterson or not
         */
        if (isPeterson(num))
            System.out.println(num + " is a Peterson number.");
        else
            System.out.println(num + " is not a Peterson number.");
    }

    //user-defined function where we have written the logic to check
    static boolean isPeterson(int n)
    {
        int num = n;
        int sum = 0;
        //looping the number until we find the factorial of each digit
        while (n > 0)
        {
            //we get the last digit of the number
            int lastDigit = n % 10;

            /* Since we have already stored the factorial of each digit 
             * in the array factorial, we are pulling the factorial quickly 
             * from the array itself by passing the digit
             */
            sum += factorial[lastDigit];

            /* Since we have stored the factorial of last digit in the 
             * variable sum, lets remove this digit from the number to find 
             * the factorial of second last digit in the second iteration of loop.
             */
            n = n / 10;
        }
        /* We are comparing the sum of factorials of all digits to the 
         * number and returning boolean value true or false.
         */
        return (sum == num);
    }
}
