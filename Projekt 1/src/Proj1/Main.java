package Proj1;

import java.math.BigInteger;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		/**2.3, 2.4**/
		//generate100Primes(512);
		//generate100Primes(1024);
		//generate100Primes(2048);
		
		
		/**4.1**/
		/*
		BigInteger v = inverseModm(new BigInteger("21"),new BigInteger("93"));
		System.out.print(v.intValue());
		*/
	
		/**4.2**/
		/*
		Primenumber[] setPr = twoprimes();
		BigInteger m = (setPr[0].getValue().subtract(BigInteger.ONE)).multiply(setPr[1].getValue().subtract(BigInteger.ONE));
		BigInteger v2 = inverseModm(new BigInteger("2").pow(16).add(BigInteger.ONE),m);
		System.out.println("d: " + v2);
		*/
		
		/**5**/
		/*
		long t = System.currentTimeMillis();
		Random rand = new Random();
		Primenumber[] setP = twoprimes();
		BigInteger p = setP[0].getValue();
		BigInteger q = setP[1].getValue();
		System.out.println("p: " + p);
		System.out.println("q: " + q);
		BigInteger e = new BigInteger("2").pow(16).add(BigInteger.ONE);
		BigInteger mod = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		*/
		BigInteger d = inverseModm(new BigInteger("253"), new BigInteger("29008"));
		/*
		BigInteger N = p.multiply(q);

		System.out.println("---------- Random s ----------");

		BigInteger s = new BigInteger(N.bitLength(),rand);
		while(s.compareTo(BigInteger.ZERO) < 1 || s.compareTo(N) >= 0){
			s = new BigInteger(N.bitLength(),rand);
		}
		
		// 5.1
		System.out.println("s = " + s);

		// 5.2
		BigInteger c = s.modPow(e, N);
		System.out.println("c = " + c.toString());

		// 5.3
		BigInteger z = c.modPow(d, N);
		System.out.println("z = " + z.toString());

		System.out.println("Success? " + s.equals(z));
		
		t = System.currentTimeMillis() - t;
		//System.out.println("Done in: "+ t +"ms");
	
		// 5.4
		BigInteger s0 = BigInteger.ZERO;
		BigInteger c0 = s0.modPow(e, N);
		BigInteger z0 = c0.modPow(d, N);


		BigInteger s1 = BigInteger.ONE;
		BigInteger c1 = s1.modPow(e, N);
		BigInteger z1 = c1.modPow(d, N);
*/

		/*
		System.out.println();
		System.out.println("---------- s = 0 ----------");
		System.out.println("s = " + s0);
		System.out.println("c = " + c0);
		System.out.println("z = " + z0);
		System.out.println("Success? " + s0.equals(z0));
		System.out.println();
		System.out.println("---------- s = 1 ----------");
		System.out.println("s = " + s1);
		System.out.println("c = " + c1);
		System.out.println("z = " + z1);
		System.out.println("Success? " + s1.equals(z1));
		
		*/
	}
	
	public static void generate100Primes(int bits){
		long t = System.currentTimeMillis();
		for(int i = 0;i<100;i++){
			Primenumber prime = new Primenumber(bits);
			System.out.print("i");
		}
		t = System.currentTimeMillis() - t;
		System.out.println("Done in: "+ t +"ms");
	}
	
	public static Primenumber[] twoprimes(){
		Primenumber p = new Primenumber(512);
		Primenumber q = new Primenumber(512);
		Primenumber[] pSet = {p,q};
		return pSet;
	}
	
	public static BigInteger inverseModm(BigInteger a,BigInteger m){
		BigInteger d1,d2,v1,v2,v,q,d,t2,t3;
		
		d1 = m;
		v1 = BigInteger.ZERO;
		v2 = BigInteger.ONE;
		d2 = a;
		
		while(!d2.equals(BigInteger.ZERO)){
			q = d1.divide(d2);
			t2 = v1.subtract(q.multiply(v2));
			t3 = d1.subtract(q.multiply(d2));
			v1 = v2;
			d1 = d2;
			v2 = t2;
			d2 = t3;
			System.out.print(" "+q + " " + t2 + " "+t3 + " ");
			System.out.print("1");
		}
		
		v = v1;
		d = d1;
		
		if(v.compareTo(BigInteger.ZERO) < 0) {
			//v = v.add(m);
		}
		System.out.println("");
		System.out.print(v);
		return v;
	}

}
