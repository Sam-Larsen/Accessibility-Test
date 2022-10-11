import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/* @author Sam Larsen
 * @version 1.0
 * @see AccessibilityTest
 * The AccessibilityResults class uses the AccessibiltiyTest class to create a
 * list of tests and implements many methods to calculate stats over a large data set.
 * 
 * Accessibility Tests Analysis
 * 10/10/2022
 * Written/online sources used: none
 * Help obtained: none
 * 
 * I confirm that the above list of sources is complete AND that I have not talked 
 * to anyone else about the solution to this problem.
 */

public class AccessibilityResults {
	
	private ArrayList<AccessibilityTest> TestList;
	
	/* One argument constructor for the AccessibiltyResults class
	 * 
	 * @param filename the name of the file to draw data to fill the new AccessibilityResults Object
	 */
	public AccessibilityResults(String filename) {
		TestList = new ArrayList<>();
		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				TestList.add(new AccessibilityTest(sc.next(), sc.next(), 
						sc.next(), sc.next(), sc.next(), sc.nextLine()));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found!");
		}
	}
	
	
	/* Calculates the number of tests in the AccessibilityResults object
	 * 
	 * @return The number of AccessibilityTests in the AccessibilityResults Object
	 */
	public int numTests() {
		return TestList.size();
	}
	
	
	/* Prints out the results of a search of the Tests in the AccessibilityResults object given a String
	 * 
	 * @ param search The keyword string used to seach the tests
	 */
	public void showTestResults(String search) {
		int i = 0;
		for(AccessibilityTest a: TestList) {
			if(a.toString().toLowerCase().contains(search.toLowerCase())) {
				System.out.println(a.toString());
				i++;
			}
		}
		System.out.println("Total tests matching: " + i);
	}
	
	/* Prints out the tests whose category matches the String passed
	 * 
	 * @ param search the String passed to search the Tests for a matching catagory.
	 */
	public void showByCategory(String search) {
		int i = 0;
		for(AccessibilityTest a: TestList) {
			if(a.getCategory().toLowerCase().contains(search.toLowerCase())) {
				System.out.println(a.toString());
				i++;
			}
		}
		System.out.println("Total tests in category: " + i);
	}
	
	/* Prints out all test where all Checkers Failed to detect the error.
	 * 
	 */
	public void showAllFailed() {
		int i = 0;
		String s = "notfound";
		for(AccessibilityTest a: TestList) {
			if(a.getAslint().equals(s) && a.getGoogleResult().equals(s) && 
					a.getSortSite().equals(s) && a.getWaveResult().equals(s)) {
				System.out.println(a.toString());
				i++;
			}
		}
		System.out.println("Total tests failed: " + i);
	}
	
	
	/* returns the number of tests that the passed checker found of the
	 * passed catagory.
	 * 
	 * @ param checker a String that is contained by the checkers name,
	 * 				   such that the String can be incomplete, as in, goog
	 * 				   would evaluate to Google in the program. 
	 * 
	 * @ param   cat   a String that is contained by the catagory used to
	 * 				   search for passed tests, such that, "key", would
	 * 				   locate all Keyboard errors.
	 * 
	 * @ return 	   The int number of tests that the submitted checker
	 * 				   successfully detected.
	 */
	public int numPass(String checker, String cat) {
		int i = 0;
		
		for(AccessibilityTest a: TestList) {
			if(a.getCategory().toLowerCase().contains(cat.toLowerCase())){	
				if ("google".contains(checker.toLowerCase()) 
						&& (a.getGoogleResult().equals("error_paid")
						|| a.getGoogleResult().equals("error"))){
					i++;
				}
				else if ("wave".contains(checker.toLowerCase()) 
						&& (a.getWaveResult().equals("error_paid")
						|| a.getWaveResult().equals("error"))) {
					i++;
				}
				else if ("aslint".contains(checker.toLowerCase()) 
						&& (a.getAslint().equals("error_paid")
						|| a.getAslint().equals("error"))) {
					i++;
				}
				else if ("sortsite".contains(checker.toLowerCase()) 
						&& (a.getSortSite().equals("error_paid")
						|| a.getSortSite().equals("error"))) {
					i++;
				}
			}
		}
		
		return i;
	}
}
