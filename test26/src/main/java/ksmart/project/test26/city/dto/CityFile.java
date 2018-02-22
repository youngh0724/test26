package ksmart.project.test26.city.dto;

public class CityFile {
	private int cityFileId;
	private int cityId;
	private String fileName;
	private String fileExt;
	private long fileSize;
		
	public CityFile() {
		super();
	}
	public CityFile(int cityFileId, int cityId, String fileName, String fileExt, long fileSize) {
		super();
		this.cityFileId = cityFileId;
		this.cityId = cityId;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.fileSize = fileSize;
	}
	public int getCityFileId() {
		return cityFileId;
	}
	public void setCityFileId(int cityFileId) {
		this.cityFileId = cityFileId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
