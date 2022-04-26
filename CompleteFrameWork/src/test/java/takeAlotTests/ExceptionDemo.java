package takeAlotTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.testng.annotations.Test;

public class ExceptionDemo {

	//When executing Java code, different errors can occur:
	//coding errors made by the programmer, errors due to wrong input, or other unforeseeable things.
	//
	//When an error occurs, Java will normally stop and generate an error message.
	//The technical term for this is: Java will throw an exception (throw an error).



	//Java try and catch
	//The try statement allows you to define a block of code to be tested for errors while it is being executed.
	//
	//The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
	//
	//The try and catch keywords come in pairs:
	//
	//Syntax
	//try {
	// // Block of code to try
	//}
	//catch(Exception e) {
	// // Block of code to handle errors
	//}
	
	@Test
	public void ArithmeticException_Demo() {
		int c = 0;
		try {
			int a = 30;
			int b = 0;
			c= a/b; //cannot devide by 0
			
		}catch(Exception e) {
			System.out.println("Can't divide a number by 0");
			e.printStackTrace();
		}
		System.out.println("Result = " + c);
	}
	
	@Test
	public void NullPointer_Demo(){

	{
	try {
	String a = null; //null value
	System.out.println(a.charAt(0));
	} catch(Exception e) {
	System.out.println("NullPointerException..");
	e.printStackTrace();
	}
	}
	}
	
	@Test
	public void StringIndexOutOfBound_Demo(){
	{
	try {
	String a = "This is like chipping "; // length is 22
	char c = a.charAt(24); // accessing 25th element
	System.out.println(c);
	}
	catch(StringIndexOutOfBoundsException e) {
	System.out.println("StringIndexOutOfBoundsException");
	e.printStackTrace();
	}
	}
	}

	@Test
	public void File_notFound_Demo() {
	try {
	// Following file does not exist
	File file = new File("E://file.txt");

	FileReader fr = new FileReader(file);
	} catch (FileNotFoundException e) {
	//} catch (Exception e) {
	System.out.println("File does not exist");
	e.printStackTrace();
	}
	}



	@Test
	public void NumberFormat_Demo(){



	try {
	// "akki" is not a number
	int num = Integer.parseInt ("akki") ;

	System.out.println(num);
	} catch(NumberFormatException e) {
	System.out.println("Number format exception");
	e.printStackTrace();
	}
	}

	@Test
	public void ArrayIndexOutOfBound_Demo(){
	try{
	int a[] = new int[5];
	a[6] = 9; // accessing 7th element in an array of
	// size 5
	}
	catch(ArrayIndexOutOfBoundsException e){
	System.out.println ("Array Index is Out Of Bounds");
	e.printStackTrace();
	}
	}
}
