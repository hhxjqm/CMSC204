import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordChecker_GFA_Test {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}
	
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("abc12"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	@Test
	public void testIsValidPasswordSuccess()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("strongPWD1"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		} 
	}
	
	
	/**
	 * Test if the password is less than 8 characters long.
	 * This test Will NOT throw a LengthException for second case.	 
	 * Because the pwd is 6 chars long, however does not meet other req and we are NOT catching them in this test case,
	 * Therefore it will execute  assertTrue("Threw some incorrect exception",false);
	 *   this line will fail, since it Asserts that you are getting the "Threw some incorrect exception" and if not it will fail
	 *   this should fail because you should be getting your exception's' custom message and not "Threw some incorrect exception"
	 */
	@Test
	public void testIsValidPasswordTooShortThrowsSomeOtherExcep()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABs"));
		}
		catch(LengthException e)
		{
			System.out.println(e.getMessage());
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides lengthException",equals(e.getMessage()));
		}
	}
	
	
}