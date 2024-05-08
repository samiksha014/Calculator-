import java.util.Scanner;
import java.io.*;

class calculator {

	int a;                   //a and b instance variables for the arthmetic operations -
 	int b;			//addittion , subtraction , multiplication and division
 	int numerator;          //numerator and denominator - variables for mixed fraction
 	int denominator; 
 	int num1;
 	int num2;
 	
}

//----------------------------------------------------- functionality 1----------------------------------------------------------- //


class operations extends calculator{                          
	
 	
 	int addition (int a, int b)     //method to solve addition
 	{ 
 		int addition;
 		addition=a+b;
 		return addition;
 	}
 	
 	int subtraction (int a, int b)          //method to solve subtraction
 	{
 		int subtraction;
 		subtraction = a-b;
 		return subtraction;
 	}
 	
 	int multiplication(int a, int b)         //method to solve multiplication
 	{
 		int multiplication;
 		multiplication=a*b;
 		return multiplication;
 	}
 	
 	
 	int divide (int a, int b)          //method to solve division
 	{
 
 		try{
 			return a/b;
 		}
 		
 		catch ( ArithmeticException e )
 		{
 			Scanner scanner = new Scanner(System.in);
 			
 			do {
 			System.out.println("Arithmetic Exception found !! - denominator must be non zero");
 			System.out.println("Enter the valid denominator");
 			b = scanner.nextInt();
 			}while(b==0);
 		}
 		return a/b;
 	}
 	
	public static void main (String args[])
	{
	
		operations op = new operations();
		System.out.println("a+b = "+op.addition(10,5));
		System.out.println("a-b = "+op.subtraction(10,2));
		System.out.println("a*b = "+op.multiplication(8,2));
		System.out.println("a/b = "+op.divide(4,0));
        }
}


//----------------------------------- In this functionality 2 interface is used here --------------------------------------- //

interface Factorial {

	long fact(int x);

}

class factorialcalculator implements Factorial{                                          
	
	public long fact(int x)          //factorial for the given number 
	{
		int factorial = 1;
		
		for(int i=1;i<=x;i++)
		{
			factorial = factorial *i;
		}
		return factorial;
	}
	
	public static void main (String args[])
	{
		factorialcalculator f = new factorialcalculator();
		System.out.println(" "+f.fact(5));
	}
}

//---------------------------------------------------functionality 3-------------------------------------------------------------------- //

class mixedfraction extends calculator{				

	static int numerator;
	static int denominator;

        
       int common_divisor(int numerator, int denominator)
        {
        
        	int res;
        	
        	res = numerator % denominator;                    //common divisor will not be found if the denominator becomes the zero;
        	
        	return res;
        	
        }
        
	int common_numerator(int numerator, int res)
	{
	
		int n;
		n= numerator/res;
		return n;
	}
	
	int common_denominator(int denominator, int res)
	{
		int d;
		d=denominator/res;                                            
		return d;
	}
	
	int fraction(int n, int d)
	{ 
		int result;                                    //by dividing we get the quotient
		result = n/d;
		return result;
        }
        
        int result(int n, int d)
        {
        	int num;	                       //by modulo we get the reminder 
        	num = n % d;
        	return num;
        }
        
	
        public static void main(String args[]) 
        {
        	mixedfraction mixed = new mixedfraction();
		
	
		int common_num;
		int common_deno;
		int result;
		int quotient;
		int reminder;
		
		
		result = mixed.common_divisor(7,3);
		common_num = mixed.common_numerator(7,result);
		common_deno = mixed.common_denominator(3,result);
		quotient = mixed.fraction(common_num,common_deno);     //quotient
		reminder = mixed.result(common_num,common_deno);       //reminder
		
		System.out.println(mixed.ntostring(7,3));		
		System.out.println(mixed.tostring(common_num , common_deno));
		System.out.println(mixed.mytostring(quotient,reminder,common_deno));	
	
	}
	
	//first form 
	String ntostring(int numerator , int denominator)
	{
		return (String)(" " +numerator+ " L" + " " +denominator);
	}
	
	//approach 1 of mixed fraction;
	
	String tostring(int common_num , int common_deno)
	{
		System.out.println("|| approach 1 of mixed fraction ||");
		return (String) (" "+ common_num + " L" + " " + common_deno);
	}
	
	//approch 2 of mixed fraction
	
	String mytostring(int quotient, int reminder , int common_deno)
	{
		System.out.println("|| approach 2 of mixed fraction ||");
		return (String) (" " + quotient + " L" + " " + reminder + " L" + " " + common_deno);
	}
}


//------------------------------------- In this functionality 4 interface is used here ------------------------------------- //

interface complexnumber {
	Complex add(Complex other);
	Complex subtract(Complex other);
	void display();
}

class Complex implements complexnumber {			
	
 
    private int real;
    private int imaginary;

    Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public Complex add(Complex other) {                  //overriding of the method
        int realPart = this.real + other.real;
        int imaginaryPart = this.imaginary + other.imaginary;
        return new Complex(realPart, imaginaryPart);
    }
    
    //Method to subtract two complex numbers 
    public Complex subtract(Complex other) {
    	int realPart1 = this.real - other.real;
    	int imaginaryPart1 = this.imaginary - other.imaginary;
    	return new Complex(realPart1, imaginaryPart1);
    }

    // Method to display the complex number
    public void display() {                                       //overriding of the method
        System.out.println(real+"+"+imaginary+"i"); 
    }

    public static void main(String[] args) {
        Complex num1 = new Complex(3, 8); // 3 + 8i
        Complex num2 = new Complex(1, 4); // 1 + 4i

        Complex sum = num1.add(num2); // Add num1 and num2
        Complex sub = num1.subtract(num2); //subtract num1 and num2
        System.out.print("Sum: ");
           sum.display();
       System.out.print("Sub: ");
           sub.display();
    }
}

//--------------------------------------------------  functionality 5--------------------------------------------------------------------- //


class square extends calculator {					

	
    int x;
    static char a='n';

    square(int x) {
        this.x = x;
    }

    // method to calculate the square of a number
    int square_show() {
        return x * x;
    }

    public static void main(String args[]) {
        square sq = new square(5);

        // method calling
        int result = sq.square_show();
        System.out.println(sq.mytostring(result));
        System.out.println(a);
    }

    String mytostring(int result) {
        return x + "^2" + ": " + result;
    }
}

//----------------------------------------------------- functionality 6------------------------------------------------------------------ //


class exponent extends calculator {				//functionality 6

	int x;      //x is a number 
	int n;		//n denotes to exponent
	
	exponent(int x , int n) {
	this.x=x;
	this.n = n;
	}
	
	//method to calculate the value by passing the number as a exponent 
	int exponent ()
	
	{
		int result =1;
		for(int i=1;i<=n;i++)
		{
			result *= x;
		}
		
		return result;
		
	}
	
	public static void main (String args[])
	{
		exponent ex = new exponent(5,4);
		
		//method calling 
		int result = ex.exponent();
		System.out.println(ex.mytostring(result,5,4));
		
	}
	
	String mytostring(int result, int x, int n)
	{
	 return (String) (x+"^"+""+n+":"+" "+result);
	 }

}

//------------------------------------------------------ functionality 7----------------------------------------------------------------- //


class reciprocal extends calculator {					

	double x;
	double n;
	
	reciprocal(double x, double n )
	{
		this.x = x;      //the actual number to be evaluated 
		this.n = n;    //it is denoted as expoent -1 to a number which denotes as reciprocal after 
	}
	
	double reciprocal_show()
	{
	
		double result;
		
		result = n/x;
		return result ;
	}
		
	
	
	public static void main (String args[])
	{
		reciprocal reci = new reciprocal(3,1);
		
		System.out.println(reci.mtostring(3,1));
		
		System.out.println("\\form 1\\");
		System.out.println(reci.ntostring(1,3));
		
		//getting the actual result by dividing the 1/x fraction i.e, form 2
		System.out.println("\\form 2\\");
		System.out.println(reci.reciprocal_show());
	}
	
	//getting result that is form 1 
	
	String ntostring(int n , int x)
	{
		return (String) (n + " L" + " "+x);
	}
	
	String mtostring(int x, int n)
	{
		return (String) (x + "^" + "-"+n);
	}
	
}

//----------------------------------------------------functionality 8------------------------------------------------------------------- //


class pie extends calculator  {				

	char value_pie = '\u03C0';
	double pie = 3.141;
	int x;
	
	
	pie (int x)
	{
		this.x = x;
	}
	
	double showpie()
	
	{
		return x*pie;
	}
	
	double showpie_sum()
	{
		return x+pie;
	}
	
	double showpie_sub()
	{
		return x-pie;
	}
	
	double showpie_div()
	{
		return x/pie;
	}
	

	
	public static void main (String args [])
	{
		pie PIE = new pie(7);
		
		
		System.out.println(PIE.ptostring(7,PIE.value_pie,PIE.showpie()));
		System.out.println(PIE.sumtostring(7,PIE.value_pie,PIE.showpie_sum()));
		System.out.println(PIE.subtostring(7,PIE.value_pie,PIE.showpie_sub()));
		System.out.println(PIE.divtostring(7,PIE.value_pie,PIE.showpie_div()));
		
	}
	
	String ptostring(int x, char value_pie , double result)
	{
	
	return (String) (x +""+value_pie+" = "+result);
	}
	
	String sumtostring(int x, char value_pie, double result)
	{
	
	return (String) (x+"+"+value_pie+" = "+result);
	}
	
	String subtostring(int x, char value_pie, double result)
	{
	return (String) (x+"-"+value_pie+"="+result);
	}
	
	String divtostring(int x, char value_pie, double result)
	{
	return (String) (x+"/"+value_pie+"="+result);
	}
		
	//add string methods for sub and divide as well
}

//--------------------------------------------------------------The end--------------------------------------------------------- //
	
		

	
		
		
		
	  
	  
	      
	         
	         
	         





	
	
	
	
		
		
        
     
	
	
	
	
		
		
		
	
	
