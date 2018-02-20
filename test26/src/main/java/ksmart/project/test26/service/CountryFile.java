package ksmart.project.test26.service;

public class CountryFile {
	private int countryFileId;
	private int countryId;
	private String fileName;
	private String fileExt;
	private long fileSize;
		
	public CountryFile() {
		super();
	}
	public CountryFile(int countryFileId, int countryId, String fileName, String fileExt, long fileSize) {
		super();
		this.countryFileId = countryFileId;
		this.countryId = countryId;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.fileSize = fileSize;
	}
	public int getCountryFileId() {
		return countryFileId;
	}
	public void setCountryFileId(int countryFileId) {
		this.countryFileId = countryFileId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
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
