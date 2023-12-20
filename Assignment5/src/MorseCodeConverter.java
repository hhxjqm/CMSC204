import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree(); 
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order:
"h s v i f u e l r a p w j b d x n c k y t z g q m o"
Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between the right most child of the left tree (j) and the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		String result = "";
		for (String str : tree.toArrayList()) {
			result += str + " ";
		}
		return result;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (กฎ กฎ). Each word is delimited by a กฎ/กฏ.
Example:
code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
string returned = "Hello World"
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String en = "";
		
		//Store the code in a format
		String[] word = code.split("/");
		String[][] letter = new String[word.length][];
		
		//Store the letter in an array
		for(int i = 0; i < word.length; i++) {
			letter[i] = word[i].split(" ");
		}		
		
		//Concert code into English letter
		for(int i = 0; i < letter.length; i++) {
			for(int j = 0; j < letter[i].length; j++) {
				en += tree.fetch(letter[i][j]);
			}
			if(i < letter.length-1)
				en += " ";
		}
		return en;
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (กฎ กฎ). Each word is delimited by a กฎ/กฏ.
Example:
a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
string returned = "Hello World"
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner input = new Scanner(codeFile);
		String text = "";
		
		//read all line in the file
        while (input.hasNextLine()) {
            text += input.nextLine();
        }
        return convertToEnglish(text);
	}
}
