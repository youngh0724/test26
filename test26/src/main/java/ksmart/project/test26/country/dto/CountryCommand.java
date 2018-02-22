package ksmart.project.test26.country.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CountryCommand {
	private int countryId;
	private String countryName;
	private List<MultipartFile> files;
		
	public CountryCommand() {
		super();
	}
	public CountryCommand(int countryId, String countryName, List<MultipartFile> files) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.files = files;
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
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
}
