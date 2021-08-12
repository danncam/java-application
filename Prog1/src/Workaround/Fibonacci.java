package Workaround;

import java.math.BigInteger;

public class Fibonacci
{
	public static void main (String[] args)
	{
	BigInteger i = BigInteger.ONE;
	BigInteger j = BigInteger.ONE;
	System.out.println (i);
		while (true)
		{
			System.out.println(i.intValue());
			i = i.add(j);
			j = i.subtract(j);
		}

	}
}