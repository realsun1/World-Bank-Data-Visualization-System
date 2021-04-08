/**
* This class creates the country object
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package dataModels;


public class countryObj {

	/*
	 * these are the instance variables of the class
	 */
	private String countryName;
	private String countryCode;
	private Integer validStart;
	private Integer validEnd;
	private String[] invalidAnalysis;
	
	/*
	 * this is the constructor of the class
	 * @param countryName This is the first parameter of the class
	 * @param countryCode This is the second parameter of the class
	 * @param validStart This is the third parameter of the class
	 * @param validEnd This is the fourth parameter of the class
	 * @param invalidAnalysis This is the fifth parameter of the class
	 */
	public countryObj(String countryName,String countryCode,Integer validStart, Integer validEnd, String[] invalidAnalysis) {  
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.validStart = validStart;
		this.validEnd = validEnd;
		this.invalidAnalysis = invalidAnalysis;

	}

	/*
	 * this is a getter method to get the country name
	 * @return countryName This gets the country name
	 */
	public String getCountryName() {
		return countryName;
	}

	/*
	 * this is a getter method to get the country code
	 * @return countryCode This gets the country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/*
	 * this is a getter method to get the valid start
	 * @return validStart This gets the valid start
	 */
	public Integer getValidStart() {
		return validStart;
	}

	/*
	 * this is a getter method to get the valid end
	 * @return validEnd This gets the valid end
	 */
	public Integer getValidEnd() {
		return validEnd;
	}

	/*
	 * this is a getter method to get the invalid analysis
	 * @return invalidAnalysis This gets the invalid analysis
	 */
	public String[] getInvalidAnalysis() {
		return invalidAnalysis;
	}


}
