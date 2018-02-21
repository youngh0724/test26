package ksmart.project.test26.service;

import java.util.List;

public class CountryAndCountryFile {
	private int countryId;
	private String countryName;
	private List<CountryFile> list;
		
	public CountryAndCountryFile() {
		super();
	}
	public CountryAndCountryFile(int countryId, String countryName, List<CountryFile> list) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.list = list;
	}
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
	public List<CountryFile> getList() {
		return list;
	}
	public void setList(List<CountryFile> list) {
		this.list = list;
	}	
}
