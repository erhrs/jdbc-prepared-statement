package jdbc_prepared_statement_crud_operation_dto;
/*
 * @HARSH YADAV
 * THIS IS COUNTRY BEAN CLASS WHERE I HAVE TAKEN 4 ATTRIBUTES 
 * 
 */
/*
 * alt + shift + s + s = to override string method
 */
public class Country {
	private int countryId;
	private String countryName;
	private String countryCapital;
	private int countryStates;
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public int getCountryStates() {
		return countryStates;
	}
	public void setCountryStates(int countryStates) {
		this.countryStates = countryStates;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryCapital=" + countryCapital
				+ ", countryStates=" + countryStates + "]";
	}
	
	
	
	

}
