	//**Assignment 2
	//Problem 2
	//Write a program to accept an integer (between 1 and 32000) and 
	//count the number of primes between and that number inclusive**//
	/**Precondition:Assume all numbers are Prime numbers
	 * Postcondition:Eratosthenes Seive filters out all Prime numbers **/
	
	import java.util.Scanner;
	
	public class PrimeNumbers
	
	{
		private static Scanner keyboard;
	
		public static void main(String[] args) {
			System.out.println("Enter an integer between 2 and 32000: ");
			keyboard = new Scanner(System.in);
			int m = keyboard.nextInt(); // Read the integer from the user
			int[] array = new int[m];
			System.out.println("Count the number of Primes for digit: " + m);
			System.out.println("The number of prime numbers for digit " + m + " is " + countp(m));
			System.out.println("THE PRIME NUMBERS ARE: ");
			printPrimes(m);
	
		}
	
		public static int printPrimes(int v) {
			int[] array = new int[v];
			for (v = 2; v <= array.length; v++)
				for (int j = 2; j <= v; j++) // Print out all of the prime number
					// for the given digit
					if (j == v) {
						System.out.print(v + " ");
					} else if (v % j == 0) {
						break;
					}
			return (v);
	
		}
	
		public static boolean isprime(int v) // Assume all the numbers are prime
		{
			boolean r = true;
			for (int i = 2; i <= v;) {
	
				if (v % i == 0)
					r = false;
				i++;
	
				break;
			}
			return r;
		}
	
		public static int countp(int v) // Method uses Eratosthenes Sieve to
		{
			boolean[] isPrime = new boolean[v + 1]; // filter no-primes and counts the Prime Numbers
			for (int i = 2; i <= v; i++) {
				isPrime[i] = true;
	
			}
	
			// mark non-primes <= n using Sieve of Eratosthenes
			for (int factor = 2; factor * factor <= v; factor++) {
	
				// if factor is prime, then mark multiples of factor as nonprime
				// Check multiples factor, factor+1, ..., n/factor
				if (isPrime[factor]) {
					for (int j = factor; factor * j <= v; j++) {
						isPrime[factor * j] = false;
					}
				}
			}
	
			// count primes
			int primes = 0;
			for (int i = 2; i <= v; i++) {
				if (isPrime[i])
					primes++;
			}
			return primes;
	
		}
	
	}
