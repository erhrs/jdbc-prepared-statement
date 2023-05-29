package jdbc_prepared_statement_crud_operation_controller;

import java.util.List;
import java.util.Scanner;
import jdbc_prepared_statement_crud_operation_dto.Country;
import jdbc_prepared_statement_crud_operation_service.CountryService;
/*
 * alt + shift + s + s = to override string method
 */
public class CountryController {
	public static void main(String[] args) {
		Country country = new Country();
		CountryService countryservice = new CountryService();
		while(true) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Country CRUD operations")
		System.out.println("Enter the task to perform 1. Insert Country details \n2. Delete country by CountryId");
		int ch = sc.nextInt();
		switch(ch) {
		case 1:{
			System.out.println("Entry the country id");
			int id = sc.nextInt();
			country.setCountryId(id);
			
			System.out.println("Enter the country name");
			String name = sc.next();
			name= name+ sc.nextLine();
			country.setCountryName(name);
			
			System.out.println("Enter the country capital");
			String capital = sc.nextLine();
			country.setCountryCapital(capital);
			
			System.out.println("Enter the number of states");
			int states = sc.nextInt();
			country.setCountryStates(states);
			
			countryservice.saveCountryService(country);
			
			System.out.println("data stored in the table.....");
		};
		break;
		case 2:{
			System.out.println("Enter id to delete");
			int id = sc.nextInt();
			countryservice.deleteByIdService(id);
			
		};
		break;
		case 3:{
			List<Country> countries = countryservice.displayAllCountryService();
			
			for (Country country2 : countries) {
				System.out.println(country2);
			};
			break;
			
		}
		case 4:{
			System.out.println("Enter Id");
			int id = sc.nextInt();
			countryservice.getCountryByIdService(id);
			
		}
		}
	}
	}

}
