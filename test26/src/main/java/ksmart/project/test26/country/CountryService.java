package ksmart.project.test26.country;

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

import ksmart.project.test26.country.dto.Country;
import ksmart.project.test26.country.dto.CountryAndCountryFile;
import ksmart.project.test26.country.dto.CountryCommand;
import ksmart.project.test26.country.dto.CountryFile;


@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryDao countryDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	//countryList.jsp에서 countryName을 클릭시 들어오는 요청 처리
	public List<CountryFile> countrySelectListCountryFile(int countryId){
		
		logger.debug("countrySelectListCountryFile() countryId = {}", countryId);
		List<CountryFile> list = countryDao.countrySelectListCountryFile(countryId);
		logger.debug("countrySelectListCountryFile() list = {}", list);
		return list;
	}
	
	//countryList.jsp에서 countryName을 클릭시 들어오는 요청 처리 중 country_file테이블의 정보를 조회하는 요청 처리
	public CountryAndCountryFile countryAndCountryFileMap(int countryId){
		logger.debug("countryAndCountryFileMap() countryId = {}", countryId);
		CountryAndCountryFile countryAndCountryFile = countryDao.countryAndCountryFileMap(countryId);
		logger.debug("countryAndCountryFileMap() countryId = {}", countryAndCountryFile.getCountryId());
		logger.debug("countryAndCountryFileMap() countryAndCountryFile.getList() = {}", countryAndCountryFile.getList());		
		return countryAndCountryFile;		
	}
	
	//countryDetail.jsp에서 다운로드 클릭시 들어오는 요청 처리
	public File countryFileDownload(int countryFileId, String path) {
		logger.debug("countryFileDownload() countryFileId = {}", countryFileId);
		logger.debug("countryFileDownload() path = {}", path);
		
		CountryFile countryFile = countryDao.countrySelectOneCountryFile(countryFileId);
		
		File file = new File(path+"/countryFileUpload/", countryFile.getFileName()+"."+countryFile.getFileExt());
		if(file.isFile()) {
			logger.debug("countryFileDownload() 다운로드 실행");
			
		} else {
			logger.debug("countryFileDownload() 파일이 없습니다.");
		}
		return file;
	}
	
	//countryDetail.jsp에서 삭제 클릭시 들어오는 요청 처리
	public int countryDeleteFile(int countryFileId, String path) {
		
		//매개변수 값을 확인
		logger.debug("countryDeleteFile() countryFileId = {}", countryFileId);
		logger.debug("countryDeleteFile() path = {}", path);
		
		//countryFile타입 객체에 매개변수 값에 해당하는 정보를 할당
		CountryFile countryFile = countryDao.countrySelectOneCountryFile(countryFileId);
		
		//countryFile객체의 정보를 이용하여 파일 객체를 생성 할당한다.
		File file = new File(path+"/countryFileUpload/", countryFile.getFileName()+"."+countryFile.getFileExt());
		
		//실제 경로상에 파일이 존재하는지 확인한다.
		if(file.isFile()) {
			logger.debug("countryDeleteFile() 경로상에 파일이 존재합니다.");
			//경로상의 실제 파일을 삭제한다.
			file.delete();
		} else {
			logger.debug("countryDeleteFile() 경로상에 파일이 존재하지 않습니다.");
		}
		
		//db에서 파일의 정보를 삭제한다.
		countryDao.countrtyDeleteFile(countryFileId);
		
		//countryFile객체의 아이디값을 리턴시켜준다.
		return countryFile.getCountryId();
	}
	
	//countryList.jsp에서 사용될 list정보를 받아오는 요청 처리
	public Map<String, Object> countrySelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("countrySelectListByPage() currentPage = {}", currentPage);
		logger.debug("countrySelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("countrySelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<Country> list = countryDao.countrySelectPage(map);
		logger.debug("countrySelectListByPage() list = {}", list);
		int totalCount = countryDao.countrySelectTotalCount();
		logger.debug("countrySelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
	//컨트롤러에서 전체 리스트를 조회할때 사용되어지는 메서드 
	public List<Country> countrySelcetList(){
		//dao에있는 전체 정보를 조회하는 메서드를 호출하여 list에 할당한다.
		List<Country> list = countryDao.countrySelectList();
		//list에 들어있는 값을 확인해본다.
		logger.debug("countrySelcetList() list = {}", list);
		return list;
	}
	
	//countryInserForm 입력폼에서 입력받은 값을 db에 입력하는 메서드
	public void countryInsert(CountryCommand countryCommand, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("countryInsert() countryName = {}", countryCommand.getCountryName());
		
		//매개변수 ArticleCommand타입에서 Article타입을 뽑아낸다.
		Country country = new Country();
		country.setCountryName(countryCommand.getCountryName());
		//위에서 뽑아낸 Country타입을 insert한다.
		countryDao.countryInsert(country);
		
		//insert쿼리문에서 생성된 id값을 꺼내오고 확인해본다.
		int generatedId = country.getCountryId();
		logger.debug("countryInsert() countryId = {}", country.getCountryId());
		
		for(MultipartFile files : countryCommand.getFiles()) {
			CountryFile countryFile = new CountryFile();
			
			//겹치지 않는 값을 사용하기위해 랜덤UUID메서드를 사용하여 오리지널 파일이름을 사용하는 대신 사용한다.
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().toString().replaceAll("-", "");	//중복되지 않는 이름 랜덤....
			
			//오리지날 파일이름
			String countryFileName = files.getOriginalFilename();	
			
			//오리지널 파일이름에서 .이 마지막몇번째에 있는지 int값을 반환한다.
			int pos = countryFileName.lastIndexOf(".");
			//오리지널 파일이름에서 pos+1번째까지의 문자열을 잘라낸다.
			String fileExt = countryFileName.substring( pos + 1 );
			
			//오리지날 파일 사이즈
			long fileSize = files.getSize();	
			
			//구한값들을 매개변수로 쓸 CountryFile 타입의 변수에 세팅한다.
			countryFile.setFileName(fileName);
			countryFile.setFileExt(fileExt);
			countryFile.setFileSize(fileSize);
			countryFile.setCountryId(generatedId);
						
			//지정한 경로의 디렉토리 객체 생성
			File directory = new File(path+"/countryFileUpload/");
			//디렉토리가 실제 경로에 존재하는지 검사
			if(!directory.exists()) {
				//존재하지 않는다면 생성한다.
				directory.mkdirs();
			} else {
				
				//지정한 경로에 파일명의 File타입 객체 생성
				File temp = new File(path+"/countryFileUpload/", fileName+"."+fileExt);
				try {
					//업로드 파일을 객체에 내용 복사(이동)
					files.transferTo(temp);
					//db에 파일 정보 입력
					countryDao.countryInsertFile(countryFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	//컨트롤러에서 수정화면에 사용될 하나의 레코드값을 조회할때 사용되어지는 메서드
	public Country countrySelectOne(int countryId) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("countrySelectOne() countryId = {}", countryId);
		//dao에 있는 컨트롤러에서 넘겨받은값과 조건이 일치하는 정보를 조회하는 메서드를 호출하여 country에 할당한다.
		Country country = countryDao.countrySelectOneForUpdate(countryId);
		//country에 들어있는 값을 확인해본다.
		logger.debug("countrySelectOne() country = {}", country);
		return country;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 수정할때 사용되어지는 메서드
	public int countryUpdate(Country country) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("countryUpdate() country = {}", country);
		//dao에 있는 수정기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = countryDao.countryUpdate(country); 
		//row에 들어있는 값을 확인해본다.
		logger.debug("countryUpdate() row = {}", row);
		return row;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 삭제할때 사용되어지는 메서드
	public int countryDelete(int countryId, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("countryDelete() countryId = {}", countryId);
	
		List<CountryFile> list = countryDao.countrySelectListCountryFile(countryId);
		
		if( list != null) {
			for(CountryFile countryFile : list) {
				File file = new File(path+"/countryFileUpload/"+countryFile.getFileName()+"."+countryFile.getFileExt());
				if(file.exists()) {
					logger.debug("countryDelete() 파일이 존재하고 있습니다.");
					countryDao.countryDeleteFile(countryFile);
					file.delete();
				} else if(!file.exists()) {
					countryDao.countryDeleteFile(countryFile);
					logger.debug("countryDelete() 파일이 존재하지 앖습니다.");
				}
			}
		}
		//dao에 있는 삭제기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = countryDao.countryDelete(countryId);
	
		//row에 들어있는 값을 확인해본다.
		logger.debug("countryDelete() row = {}", row);
		return row;
	}
	
}
