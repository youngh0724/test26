package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MovieCommand {
	private int movieId;
	private String movieName;
	private List<MultipartFile> files;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}	


	

}
