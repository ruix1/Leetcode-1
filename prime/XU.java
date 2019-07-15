package prime;



	import java.math.BigInteger;  
	import java.util.Random;  
	import java.util.Scanner;  
	  
	public class XU{  
	       
	    public static void main(String[] args) {          
	          
	        Scanner scan=new Scanner(System.in);  
	        while(scan.hasNext()){  
	         String s=new String();  
	         s=scan.next();      //用字符串s接收n的数值  
	         BigInteger n=new BigInteger(s);    
	         BigInteger x=new BigInteger("0");//x为大于1小于n的任意值 初始化值为0  
	         Random rnd=new Random();  
	         BigInteger y=n.subtract(BigInteger.ONE); //y=n-1      
	         BigInteger result=new BigInteger("1");  
	         for(int i=0;i<100;i++){  //进行重复多次的测试 把出错率降到2^-100以下  
	             do{  
	                 x=new BigInteger(128,rnd);  //x的取值范围
	                 x=x.mod(n);  
	             }while(x.equals(BigInteger.ZERO)); //取一个小于n且不为0的数x        
	             result=fast_sort(x,y,n);       //调用快速幂取余         
	             if(!result.equals(BigInteger.ONE)){//如果有任意值a不符合(x^y)%n=1则n非素数  
	                 System.out.println("no");//输出结果 结束循环  
	                 break;  
	             }         
	         }  
	         if(result.equals(BigInteger.ONE))System.out.println("yes");       
	        }  
	        scan.close();  
	    }  
	    static BigInteger fast_sort(BigInteger x, BigInteger y, BigInteger n){  
	        BigInteger two=new BigInteger("2");  //two作为常数2使用  
	        BigInteger result=new BigInteger("0");  //保存数值结果  
	        if (y.equals(BigInteger.ZERO)) {//指数y为0   
	             result=BigInteger.ONE; //返回1  
	              
	             return result;  
	        }  
	        else {  
	            if (y.mod(two)== BigInteger.ZERO){  //指数y为偶数              
	                result=fast_sort(x, y.divide(two), n);//result=(x^y/2)%n  
	                  
	                result=result.multiply(result);  
	                  
	                result=result.mod(n);  
	                  
	                return result;  
	            }  
	                  
	            else {//指数y为奇数  
	                //result=(x^y/2)*x%n  
	                result=fast_sort(x, y.divide(two), n);  
	              
	                result=result.multiply(result);  
	              
	                result=result.multiply(x);  
	                  
	                result=result.mod(n);  
	                  
	                return result;  
	            }  
	        }  
	    }  
	  
	} 


