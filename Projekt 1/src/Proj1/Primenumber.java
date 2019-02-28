package Proj1;

import java.math.BigInteger;
import java.util.Random;

public class Primenumber{
	BigInteger prime;
	int bits;
	Random rand = new Random();
	
	public Primenumber(int bits) {
		this.bits = bits;
		prime = new BigInteger(bits,rand);
		while((prime.mod(new BigInteger("2")).equals(BigInteger.ZERO)||prime.mod(new BigInteger("3")).equals(BigInteger.ZERO))||(prime.mod(new BigInteger("5")).equals(BigInteger.ZERO)||prime.mod(new BigInteger("7")).equals(BigInteger.ZERO))){
			prime = new BigInteger(bits,rand);
		}
		while((!RMtest(prime))||(prime.compareTo(new BigInteger("4")) < 0)){
			prime = new BigInteger(bits,rand);
			while((prime.mod(new BigInteger("2")).equals(BigInteger.ZERO)||prime.mod(new BigInteger("3")).equals(BigInteger.ZERO))||(prime.mod(new BigInteger("5")).equals(BigInteger.ZERO)||prime.mod(new BigInteger("7")).equals(BigInteger.ZERO))){
				prime = new BigInteger(bits,rand);
			}
		}
		
	}
	
	public BigInteger getValue(){
		return prime;
	}

	private boolean RMtest(BigInteger n){
		BigInteger s = n.subtract(BigInteger.ONE);
		BigInteger r = BigInteger.ZERO;
		
		while(!s.testBit(0)){
			s = s.divide(new BigInteger("2"));
			r = r.add(BigInteger.ONE);
		}
		
		BigInteger a,x;
		for(int i = 0;i<20;i++){
		a = new BigInteger(bits,rand);
		
		while((a.compareTo(new BigInteger("2")) < 0) || (a.compareTo(n.subtract(new BigInteger("2"))) > 0)){
			a = new BigInteger(bits,rand);
		}
		x = a.modPow(s,n);
		
		if(x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))){
			return true;
		}
		
		for(int j=1;j<r.intValue()-1;j++){
			x = a.modPow(new BigInteger("2").pow(j).multiply(s), n);
			if(x.equals(BigInteger.ONE)){
				return false;
			}
			if(x.equals(n.subtract(BigInteger.ONE))){
				return true;
			}
		}
		return false;
		}
		return true;
	}
}
