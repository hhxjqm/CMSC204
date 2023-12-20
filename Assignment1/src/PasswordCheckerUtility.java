/*
	 * Class: CMSC204
	 * Program: Assignment 1
	 *  Instructor: Khandan Monshi
	 * Description: ()
	 * Due: 9/13/2020
	 * I pledge that I have completed the programming assignment independently.
	   I have not copied the code from a student or any source.
	   I have not given my code to any student.
	   Print your Name here: Huan Shiuan Huang
*/

import java.util.ArrayList;

/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class PasswordCheckerUtility {

	/**
	 * Compare equality of two passwords
	 * @param password - - password string to be checked for length
	 * @param passwordConfirm - - passwordConfirm string to be checked against password for length
	 * @throws UnmatchedException - thrown if not same (case sensitive)
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm)throws UnmatchedException{
		if (!(password.equals(passwordConfirm)))
			throw new UnmatchedException();
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password - - password string to be checked for length
	 * @param passwordConfirm - - passwordConfirm string to be checked against password for length
	 * @return true if both same (case sensitive)
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {
		if (password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	
	/**
	 * Checks the password length requirement - The password must be at least 6 characters long
	 * @param password - - password string to be checked for length
	 * @return true if meet min length requirement
	 * @throws LengthException - thrown if does not meet min length requirement
	 */
	public static boolean isValidLength(java.lang.String password) throws LengthException{
		//throw exception if password is less than 6 characters
		if (password.length() < 6)
			throw new LengthException();
		else 
			return true;
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password - - password string to be checked for alpha character requirement
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException - thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException{
		boolean upper = false;
		
		//if there is upper case in the password
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i)))
				upper = true;
		}
		
		if(!upper)
			throw new NoUpperAlphaException();
		else
			return true;
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain a lowercase alpha character
	 * @param password - - password string to be checked for lowercase requirement
	 * @return true if meet lowercase requirement
	 * @throws NoLowerAlphaException - thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException{
		boolean lower = false;
		
		//if there is lower case in the password
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i)))
				lower = true;
		}
		
		//throw exception if the requirement not meet
		if(!lower)
			throw new NoLowerAlphaException();
		else
			return true;
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password - - password string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException - thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException{
		boolean digit = false;
		
		//if there is digit in the password
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i)))
				digit = true;
		}
		//throw exception if the requirement not meet
		if(!digit)
			throw new NoDigitException();
		else
			return true;
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password - - password string to be checked for SpecialCharacter requirement
	 * @return true if meet SpecialCharacter requirement
	 * @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException{
		boolean special = false;
		//if there is special character in the password
		for(int i = 0; i < password.length(); i++) {
			if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i)))
				special = true;
		}
		//throw exception if the requirement not meet
		if(!special)
			throw new NoSpecialCharacterException();
		else
			return true;
	}
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password - - password string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException - thrown if does not meet Sequence requirement
	 */
	public static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException{

		//check if there is more than 2 characters are same, throw exception
		for (int i = 0; i < password.length() - 2; i++) {
			//throw exception if the requirement not meet
			if(password.charAt(i) == password.charAt(i+1) && password.charAt(i+1) == password.charAt(i+2))
				throw new InvalidSequenceException();
		}
		return true;
	}
	
	
	/**
	 * Return true if valid password (follows all rules from above), returns false if an invalid password
	 * @param password - - string to be checked for validity
	 * @return true if valid password (follows all rules from above), set up to return false if an invalid password, but throws an exception instead.
	 * @throws LengthException - thrown if length is less than 6 characters
	 * @throws NoDigitException - thrown if no digit
	 * @throws NoUpperAlphaException - thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
	 * @throws NoSpecialCharacterException - thrown if more than 2 of same character.
	 * @throws InvalidSequenceException - thrown if no special character.
	 */
	public static boolean isValidPassword(java.lang.String password)
			throws LengthException, NoDigitException, NoUpperAlphaException,NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException{
		
		//check if all the requirement meet
		if(isValidLength(password) && hasUpperAlpha(password)
				&&hasLowerAlpha(password)
				&&hasDigit(password)
				&&hasSpecialChar(password)
				&&hasSameCharInSequence(password))
			return true;
		else
			return false;
	}
	
	/**
	 * Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
	 * @param password - - password string to be checked for Sequence requirement
	 * @return true if password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(java.lang.String password) {
		//check if the password is weak password
		if (password.length() >= 6 && password.length()<=9)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if password is valid but not between 6 -9 characters
	 * @param password - - string to be checked if weak password
	 * @return true if length of password is between 6 and 9 (inclusive).
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException{
		//Check password if it was weak
		if (password.length() >= 6 && password.length()<=9)
			throw new WeakPasswordException();
		else
			return false;
	}
	
	/**
	 * Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	 * @param passwords - - list of passwords read from a file
	 * @return invalidPasswords - ArrayList of invalid passwords in the correct format
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords){
		ArrayList<String> invalidPassword = new ArrayList<>();

		//test all element in the array list
        for (String str : passwords) {
            try {
                isValidPassword(str);
                
            } catch (Exception ex) {
                invalidPassword.add (str + " -> " + ex.getMessage());
            }
        }

        return invalidPassword;
	}
}
