
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PasswordCheckerTestPublic {
	ArrayList<String> passwordsArray;
	String password = "Hello";
	String passwordConfirm = "hello";
	String allCaps = "HELLO";
	String withDigit = "Hello6";

	@BeforeEach
	void setUp() throws Exception {
		String[] p = {"334455BB", "Im2cool4U"};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(p));
	}

	@AfterEach
	void tearDown() throws Exception {
		passwordsArray = null;
	}

	//@Test
	void testComparePasswords() {
		Throwable exception = assertThrows(UnmatchedException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.comparePasswords(password, passwordConfirm);				
			}
		});
		
		assertEquals("Passwords do not match", exception.getMessage());
	}
	
	//@Test 
	void testComparePasswordsWithReturn() {
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn(password, passwordConfirm));
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn(password, password));
	}	
	
	//@Test
	void testUppereAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Beautiful"));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	void testInValidLength() {
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength(password);
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}
	
	@Test
	public void testGetInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		assertEquals(results.size(), 2);
		assertEquals(results.get(0), "334455BB -> The password must contain at least one lower case alphabetic character");
		assertEquals(results.get(1), "Im2cool4U -> The password must contain at least one special character");
	}

}