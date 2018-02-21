package ksmart.project.test26.service;

import java.util.List;

public class CityAndCityFile {
	private int cityId;
	private String cityName;
	private List<CityFile> list;
		
	public CityAndCityFile() {
		super();
	}
	public CityAndCityFile(int cityId, String cityName, List<CityFile> list) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.list = list;
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
	public List<CityFile> getList() {
		return list;
	}
	public void setList(List<CityFile> list) {
		this.list = list;
	}	
}
