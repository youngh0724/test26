package ksmart.project.test26.movie;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart.project.test26.movie.dto.Movie;
import ksmart.project.test26.movie.dto.MovieAndMovieFile;
import ksmart.project.test26.movie.dto.MovieCommand;
import ksmart.project.test26.movie.dto.MovieFile;


@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	//movieList.jsp에서 영화 제목 movieName 을 클릭했을때 받는 요청을 처리
	public List<MovieFile> movieSelectListMovieFile(int movieId){
		
		logger.debug("movieSelectListMovieFile() movieId = {}", movieId);
		List<MovieFile> list = movieDao.movieSelectListMovieFile(movieId);
		logger.debug("movieSelectListMovieFile() list = {}", list);
		return list;
	}
	//movieList.jsp에서 영화 제목을 눌렀을때 movie_file 테이블의 정보를 조회하는 요청 처리 
	public MovieAndMovieFile movieAndMovieFileMap(int movieId){
		logger.debug("movieAndMovieFileMap() movieId = {}", movieId);
		MovieAndMovieFile movieAndMovieFile = movieDao.movieAndMovieFileMap(movieId);
		logger.debug("movieAndMovieFileMap() movieId = {}", movieAndMovieFile.getMovieId());
		logger.debug("movieAndMovieFileMap() movieAndMovieFile.getList() = {}", movieAndMovieFile.getList());		
		return movieAndMovieFile;		
	}
	//영화 목록에 첨부된 파일을 다운로드 하기 위한 메서드
	public File movieFileDownload(int movieFileId, String path) {
		logger.debug("movieFileDownload() movieFileId = {}", movieFileId);
		logger.debug("movieFileDownload() path = {}", path);
		
		MovieFile movieFile = movieDao.movieSelectOneMovieFile(movieFileId);
		
		File file = new File(path+"/movieFileUpload/", movieFile.getFileName()+"."+movieFile.getFileExt());
		if(file.isFile()) {
			logger.debug("movieFileDownload() 다운로드 실행");
			
		} else {
			logger.debug("movieFileDownload() 파일이 없습니다.");
		}
		return file;
	}
	//영화 목록에 첨부된 파일을 삭제하기 위한 메서드
	public int movieDeleteFile(int movieFileId, String path) {
		logger.debug("movieDeleteFile() movieFileId = {}", movieFileId);
		logger.debug("movieDeleteFile() path = {}", path);
		
		MovieFile movieFile = movieDao.movieSelectOneMovieFile(movieFileId);
		
		File file = new File(path+"/movieFileUpload/", movieFile.getFileName()+"."+movieFile.getFileExt());
		if(file.isFile()) {
			logger.debug("movieDeleteFile() 경로상에 파일이 존재합니다.");
			file.delete();
		} else {
			logger.debug("movieDeleteFile() 경로상에 파일이 존재하지 않습니다.");
		}
		
		movieDao.movieDeleteFile(movieFileId);
		
		return movieFile.getMovieId();
	}
	
	//영화 목록을 갯수별로 페이징 시키기 위한 메서드
	public Map<String, Object> movieSelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("movieSelectListByPage() currentPage = {}", currentPage);
		logger.debug("movieSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("movieSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<Movie> list = movieDao.movieSelectPage(map);
		logger.debug("movieSelectListByPage() list = {}", list);
		int totalCount = movieDao.movieSelectTotalCount();
		logger.debug("movieSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
	//컨트롤러에서 전체 리스트를 조회할때 사용되어지는 메서드 
	public List<Movie> movieSelcetList(){
		//dao에있는 전체 정보를 조회하는 메서드를 호출하여 list에 할당한다.
		List<Movie> list = movieDao.movieSelectList();
		//list에 들어있는 값을 확인해본다.
		logger.debug("movieSelcetList() list = {}", list);
		return list;
	}
	
	//컨트롤러에서 정볼르 입력할때 사용되어지는 메서드
	public void movieInsert(MovieCommand movieCommand, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("movieInsert() movieName = {}", movieCommand.getMovieName());
		
		//매개변수 ArticleCommand타입에서 Article타입을 뽑아낸다.
		Movie movie = new Movie();
		movie.setMovieName(movieCommand.getMovieName());
		//위에서 뽑아낸 Movie타입을 insert한다.
		movieDao.movieInsert(movie);
		
		//insert쿼리문에서 생성된 id값을 꺼내오고 확인해본다.
		int generatedId = movie.getMovieId();
		logger.debug("movieInsert() movieId = {}", movie.getMovieId());
		
		for(MultipartFile files : movieCommand.getFiles()) {
			MovieFile movieFile = new MovieFile();
			
			//겹치지 않는 값을 사용하기위해 랜덤UUID메서드를 사용하여 오리지널 파일이름을 사용하는 대신 사용한다.
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().toString().replaceAll("-", "");	//중복되지 않는 이름 랜덤....
			
			//오리지날 파일이름
			String movieFileName = files.getOriginalFilename();	
			
			//오리지널 파일이름에서 .이 마지막몇번째에 있는지 int값을 반환한다.
			int pos = movieFileName.lastIndexOf(".");
			//오리지널 파일이름에서 pos+1번째까지의 문자열을 잘라낸다.
			String fileExt = movieFileName.substring( pos + 1 );
			
			//오리지날 파일 사이즈
			long fileSize = files.getSize();	
			
			//구한값들을 매개변수로 쓸 MovieFile 타입의 변수에 세팅한다.
			movieFile.setFileName(fileName);
			movieFile.setFileExt(fileExt);
			movieFile.setFileSize(fileSize);
			movieFile.setMovieId(generatedId);
						
			File directory = new File(path+"/movieFileUpload/");
			if(!directory.exists()) {
				directory.mkdirs();
			} else {
				File temp = new File(path+"/movieFileUpload/", fileName+"."+fileExt);
				try {
					files.transferTo(temp);
					
					movieDao.movieInsertFile(movieFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	//컨트롤러에서 수정화면에 사용될 하나의 레코드값을 조회할때 사용되어지는 메서드
	public Movie movieSelectOne(int movieId) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("movieSelectOne() movieId = {}", movieId);
		//dao에 있는 컨트롤러에서 넘겨받은값과 조건이 일치하는 정보를 조회하는 메서드를 호출하여 movie에 할당한다.
		Movie movie = movieDao.movieSelectOneForUpdate(movieId);
		//movie에 들어있는 값을 확인해본다.
		logger.debug("movieSelectOne() movie = {}", movie);
		return movie;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 수정할때 사용되어지는 메서드
	public int movieUpdate(Movie movie) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("movieUpdate() movie = {}", movie);
		//dao에 있는 수정기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = movieDao.movieUpdate(movie); 
		//row에 들어있는 값을 확인해본다.
		logger.debug("movieUpdate() row = {}", row);
		return row;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 삭제할때 사용되어지는 메서드
	public int movieDelete(int movieId, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("movieDelete() movieId = {}", movieId);
	
		List<MovieFile> list = movieDao.movieSelectListMovieFile(movieId);
		
		if( list != null) {
			for(MovieFile movieFile : list) {
				File file = new File(path+"/movieFileUpload/"+movieFile.getFileName()+"."+movieFile.getFileExt());
				if(file.exists()) {
					logger.debug("movieDelete() 파일이 존재하고 있습니다.");
					movieDao.movieDeleteFile(movieFile);
					file.delete();
				} else if(!file.exists()) {
					movieDao.movieDeleteFile(movieFile);
					logger.debug("movieDelete() 파일이 존재하지 앖습니다.");
				}
			}
		}
		//dao에 있는 삭제기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = movieDao.movieDelete(movieId);
	
		//row에 들어있는 값을 확인해본다.
		logger.debug("movieDelete() row = {}", row);
		return row;
	}
	
}
