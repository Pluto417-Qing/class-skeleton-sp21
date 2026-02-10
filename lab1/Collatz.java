/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** cal the next collatz number of param
     * @param n the param
     * */
    public static int nextNumber(int n) {
        if(n % 2 == 0)
            return n / 2;
        else
            return 3 * n + 1;
    }

    static void main() {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

