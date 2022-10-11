/* @author Sam Larsen
 * @version 1.0
 * 
 * A Tester for the AccessibilityResults Class
 * 
 * Accessibility Tests Analysis
 * 10/10/2022
 * Written/online sources used: none
 * Help obtained: none
 * 
 * I confirm that the above list of sources is complete AND that I have not talked 
 * to anyone else about the solution to this problem.
 */
public class AccessibilityResultsTester {
	
	public static void main(String[] args) {
		AccessibilityResults a11y = new AccessibilityResults("a11yCheckersResults.txt");
		System.out.println("a11y number of tests: " + a11y.numTests());
		a11y.showTestResults("Colour");
		a11y.showByCategory("key");
		a11y.showAllFailed();
		System.out.println("HTML tests passed by ASLint: "+ a11y.numPass("lint", "htm"));
	}
	
}
