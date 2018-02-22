package ksmart.project.test26.movie.dto;

public class MovieFile {
	private int movieFileId;
	private int movieId;
	//private Article article;
	private String fileName;
	private String fileExt;
	private long fileSize;
	public int getMovieFileId() {
		return movieFileId;
	}
	public void setMovieFileId(int movieFileId) {
		this.movieFileId = movieFileId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
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
