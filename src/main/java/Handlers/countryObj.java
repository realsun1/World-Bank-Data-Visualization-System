package Handlers;


public class countryObj {

	private String countryName;
	private String countryCode;
	private Integer validStart;
	private Integer validEnd;
	private String[] invalidAnalysis;
	
	countryObj(String countryName,String countryCode,Integer validStart, Integer validEnd, String[] invalidAnalysis) {  
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.validStart = validStart;
		this.validEnd = validEnd;
		this.invalidAnalysis = invalidAnalysis;

	}

	public String getCountryName() {
		return countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}



	public Integer getValidStart() {
		return validStart;
	}


	public Integer getValidEnd() {
		return validEnd;
	}



	public String[] getInvalidAnalysis() {
		return invalidAnalysis;
	}


}
