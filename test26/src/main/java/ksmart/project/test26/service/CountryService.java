package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryDao countryDao;
	
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	
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
	
	//컨트롤러에서 정볼르 입력할때 사용되어지는 메서드
	public int countryInsert(Country country) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("countryInsert() countryName = {}", country.getCountryName());
		//dao에있는 정보를 입력하는 메서드를 호출하여 실행결과(db에 변동이 일어난 행수)를 row에 할당한다. 
		int row = countryDao.countryInsert(country);
		//row에 들어있는 값을 확인해본다.
		logger.debug("countryInsert() row = {}", row);
		return row;
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
	public int countryDelete(int countryId) {
		//컨트롤러에서 넘겨받은 값을 확인해본다.
		logger.debug("countryDelete() countryId = {}", countryId);
		//dao에 있는 삭제기능의 메서드를 호출하고 결과(db에 변동이 일어난 행수)를 row에 할당한다.
		int row = countryDao.countryDelete(countryId);
		//row에 들어있는 값을 확인해본다.
		logger.debug("countryDelete() row = {}", row);
		return row;
	}
	
}
