package lab9.part1.prob4;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class PrimeStream {

	public static void main(String[] args) {
		// Prob 4A
		final Stream<Integer> primes = Stream.iterate(1, PrimeStream::nextPrime)
				.limit(10);
		
		primes.forEach(System.out::println);
		System.out.println("====");
		
		// Prob 4B
		PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
		ps.printFirstNPrimes(10);
		System.out.println("====");
		ps.printFirstNPrimes(5);
	}
	
	public void printFirstNPrimes(long n) {
		Stream.iterate(1, PrimeStream::nextPrime)
				.limit(n)
				.forEach(System.out::println);
	}
	
	private static boolean isPrime(int n)  
    {  
        // Corner cases  
        if (n <= 1) return false;  
        if (n <= 3) return true;  
          
        // This is checked so that we can skip  
        // middle five numbers in below loop  
        if (n % 2 == 0 || n % 3 == 0) return false;  
          
        for (int i = 5; i * i <= n; i = i + 6)  
            if (n % i == 0 || n % (i + 2) == 0)  
            return false;  
          
        return true;  
    }  
      
    // Function to return the smallest  
    // prime number greater than N  
    static int nextPrime(int N)  
    {  
      
        // Base case  
        if (N <= 1)  
            return 2;  
      
        int prime = N;  
        boolean found = false;  
      
        // Loop continuously until isPrime returns  
        // true for a number greater than n  
        while (!found)  
        {  
            prime++;  
      
            if (isPrime(prime))  
                found = true;  
        }  
      
        return prime;  
    }  

}
