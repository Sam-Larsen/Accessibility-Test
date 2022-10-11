
/* @author Sam Larsen
 * @version 1.0
 * The AccessibilityTest class creates the AccessibiltyTest object that stores 
 * information about test on accessibility testers about their detection.
 * 
 * Accessibility Tests Analysis
 * 10/10/2022
 * Written/online sources used: none
 * Help obtained: none
 * 
 * I confirm that the above list of sources is complete AND that I have not talked 
 * to anyone else about the solution to this problem.
 */
public class AccessibilityTest {
	
	private String category;
	private String googleResult;
	private String waveResult;
	private String sortsite;
	private String aslint;
	private String testDescription;
	
	/* The six parameter constuctor for the AccessibilityTest object
	 * 
	 * @param cat    A String that contains the catagory of the test conducted
	 * @param goog   A String that represents the reusults of the Google Accessibility Checker
	 * @param wav    A String that represents the reusults of the WAVE Accessibility Checker
	 * @param sort   A String that represents the reusults of the Sortsite Accessibility Checker
	 * @param asl    A String that represents the reusults of the ASLint Accessibility Checker
	 * @param descrp A String that  decribes the error to be detected by the checkers
	 */
	public AccessibilityTest(String cat, String goog, String wav, String sort, String asl, String descrp) {
		category = cat;
		googleResult = goog;
		waveResult = wav;
		sortsite = sort;
		aslint = asl;
		testDescription = descrp;
	}
	
	
	/* The getter method for the category field
	 * @return the category String for the AccessibiltyTest
	 */
	public String getCategory() {
		return category;
	}
	
	/* The getter method for the googleResult field
	 * @return the googleResult String for the AccessibiltyTest
	 */
	public String getGoogleResult() {
		return googleResult;
	}
	
	/* The getter method for the getWaveResult field
	 * @return the getWaveResult String for the AccessibiltyTest
	 */
	public String getWaveResult() {
		return waveResult;
	}
	
	/* The getter method for the getSortSite field
	 * @return the getSortSite String for the AccessibiltyTest
	 */
	public String getSortSite() {
		return sortsite;
	}
	
	/* The getter method for the getAslint field
	 * @return the getAslint String for the AccessibiltyTest
	 */
	public String getAslint() {
		return aslint;
	}
	
	/* The getter method for the getTestDescription field
	 * @return the getTestDescription String for the AccessibiltyTest
	 */
	public String getTestDescription() {
		return testDescription;
	}
	
	/* returns the String that is easily readable for the AccessibilityTest
	 * 
	 * @return A readable String representing the information in stored in the AccessibilityTest
	 */
	public String toString() {
		return category + ": " + testDescription + ", Google Result: " + googleResult + 
				", WAVE Result: " + waveResult + ", Sortsite Result: " + sortsite +
				", ASLint Result: " + aslint;
	}
}
