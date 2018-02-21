package ksmart.project.test26.service;

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


@Service
@Transactional
public class CityService {
	@Autowired
	private CityDao cityDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	public List<CityFile> citySelectListCityFile(int cityId){
		
		logger.debug("citySelectListCityFile() cityId = {}", cityId);
		List<CityFile> list = cityDao.citySelectListCityFile(cityId);
		logger.debug("citySelectListCityFile() list = {}", list);
		return list;
	}
	
	public CityAndCityFile cityAndCityFileMap(int cityId){
		logger.debug("cityAndCityFileMap() cityId = {}", cityId);
		CityAndCityFile cityAndCityFile = cityDao.cityAndCityFileMap(cityId);
		logger.debug("cityAndCityFileMap() cityId = {}", cityAndCityFile.getCityId());
		logger.debug("cityAndCityFileMap() cityAndCityFile.getList() = {}", cityAndCityFile.getList());		
		return cityAndCityFile;		
	}
	
	
	
	public void cityFileDownload(int cityFileId, String path) {
		logger.debug("cityFileDownload() cityFileId = {}", cityFileId);
		logger.debug("cityFileDownload() path = {}", path);
		
		
		
	}
	
	public Map<String, Object> citySelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("citySelectListByPage() currentPage = {}", currentPage);
		logger.debug("citySelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("citySelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<City> list = cityDao.citySelectPage(map);
		logger.debug("citySelectListByPage() list = {}", list);
		int totalCount = cityDao.citySelectTotalCount();
		logger.debug("citySelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
	
	//컨트롤러에서 전체 리스트를 조회할때 사용되어지는 메서드 
	public List<City> citySelcetList(){
		//dao에있는 전체 정보를 조회하는 메서드를 호출하여 list에 할당한다.
		List<City> list = cityDao.citySelectList();
		//list에 들어있는 값을 확인해본다.
		logger.debug("citySelcetList() list = {}", list);
		return list;
	}
	
	//컨트롤러에서 정볼르 입력할때 사용되어지는 메서드
	public void cityInsert(CityCommand cityCommand, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("cityInsert() cityName = {}", cityCommand.getCityName());
		
		//매개변수 ArticleCommand타입에서 Article타입을 뽑아낸다.
		City city = new City();
		city.setCityName(cityCommand.getCityName());
		//위에서 뽑아낸 City타입을 insert한다.
		cityDao.cityInsert(city);
		
		//insert쿼리문에서 생성된 id값을 꺼내오고 확인해본다.
		int generatedId = city.getCityId();
		logger.debug("cityInsert() cityId = {}", city.getCityId());
		
		for(MultipartFile files : cityCommand.getFiles()) {
			CityFile cityFile = new CityFile();
			
			//겹치지 않는 값을 사용하기위해 랜덤UUID메서드를 사용하여 오리지널 파일이름을 사용하는 대신 사용한다.
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().toString().replaceAll("-", "");	//중복되지 않는 이름 랜덤....
			
			//오리지날 파일이름
			String cityFileName = files.getOriginalFilename();	
			
			//오리지널 파일이름에서 .이 마지막몇번째에 있는지 int값을 반환한다.
			int pos = cityFileName.lastIndexOf(".");
			//오리지널 파일이름에서 pos+1번째까지의 문자열을 잘라낸다.
			String fileExt = cityFileName.substring( pos + 1 );
			
			//오리지날 파일 사이즈
			long fileSize = files.getSize();	
			
			//구한값들을 매개변수로 쓸 CityFile 타입의 변수에 세팅한다.
			cityFile.setFileName(fileName);
			cityFile.setFileExt(fileExt);
			cityFile.setFileSize(fileSize);
			cityFile.setCityId(generatedId);
						
			File directory = new File(path+"/cityFileUpload/");
			if(!directory.exists()) {
				directory.mkdirs();
			} else {
				File temp = new File(path+"/cityFileUpload/", fileName+"."+fileExt);
				try {
					files.transferTo(temp);
					
					cityDao.cityInsertFile(cityFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	//컨트롤러에서 수정화면에 사용될 하나의 레코드값을 조회할때 사용되어지는 메서드
	public City citySelectOne(int cityId) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("citySelectOne() cityId = {}", cityId);
		//dao에 있는 컨트롤러에서 넘겨받은값과 조건이 일치하는 정보를 조회하는 메서드를 호출하여 city에 할당한다.
		City city = cityDao.citySelectOneForUpdate(cityId);
		//city에 들어있는 값을 확인해본다.
		logger.debug("citySelectOne() city = {}", city);
		return city;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 수정할때 사용되어지는 메서드
	public int cityUpdate(City city) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("cityUpdate() city = {}", city);
		//dao에 있는 수정기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = cityDao.cityUpdate(city); 
		//row에 들어있는 값을 확인해본다.
		logger.debug("cityUpdate() row = {}", row);
		return row;
	}
	
	//컨트롤러에서 넘겨받은 정보로 db정보를 삭제할때 사용되어지는 메서드
	public int cityDelete(int cityId, String path) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("cityDelete() cityId = {}", cityId);
	
		List<CityFile> list = cityDao.citySelectListCityFile(cityId);
		
		if( list != null) {
			for(CityFile cityFile : list) {
				File file = new File(path+"/cityFileUpload/"+cityFile.getFileName()+"."+cityFile.getFileExt());
				if(file.exists()) {
					logger.debug("cityDelete() 파일이 존재하고 있습니다.");
					cityDao.cityDeleteFile(cityFile);
					file.delete();
				} else if(!file.exists()) {
					cityDao.cityDeleteFile(cityFile);
					logger.debug("cityDelete() 파일이 존재하지 앖습니다.");
				}
			}
		}
		//dao에 있는 삭제기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = cityDao.cityDelete(cityId);
	
		//row에 들어있는 값을 확인해본다.
		logger.debug("cityDelete() row = {}", row);
		return row;
	}
	
}
