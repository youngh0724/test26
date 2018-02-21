package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CityCommand {
	private int cityId;
	private String cityName;
	private List<MultipartFile> files;
		
	public CityCommand() {
		super();
	}
	public CityCommand(int cityId, String cityName, List<MultipartFile> files) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.files = files;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
}
