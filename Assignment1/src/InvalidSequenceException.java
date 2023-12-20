
public class InvalidSequenceException extends Exception{
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
}
