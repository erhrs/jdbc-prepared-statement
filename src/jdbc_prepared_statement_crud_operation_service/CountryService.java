package jdbc_prepared_statement_crud_operation_service;

import java.util.List;

import jdbc_prepared_statement_crud_operation_dao.CountryDao;
import jdbc_prepared_statement_crud_operation_dto.Country;

public class CountryService {
	
	CountryDao countrydao = new CountryDao();
	
	public void saveCountryService(Country country) {
		countrydao.saveCountry(country);
	}
	
	public void deleteByIdService(int id) {
		if(countrydao.getById(id)!=null) {
			countrydao.deleteById(id);
			System.out.println("Country Deleted Successfully");
		}
		else {
			System.err.println("Id not found");
		}
		countrydao.deleteById(id);
		
	}
	public List<Country> displayAllCountryService(){
		return countrydao.DisplyAll();
	}
	public Country getCountryByIdService(int countryid) {

			return countrydao.getById(countryid);
	}
	public int updateCapitalService(int id, String capital) {
		return countrydao.updateCapital(id, capital);
	}

}
