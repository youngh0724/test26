package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class IdolCommand {
	private int idolId;
	private String idolName;
	private List<MultipartFile> files;
	
	public int getIdolId() {
		return idolId;
	}
	public void setIdolId(int idolId) {
		this.idolId = idolId;
	}
	public String getIdolName() {
		return idolName;
	}
	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	

	
}
