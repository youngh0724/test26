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
public class IdolService {
	private final int LINE_PER_PAGE = 5;
	@Autowired
	private IdolDao idolDao;
	private final String uploadRoot= "c:\\temp\\";
	//입력값과 리턴값을 확인하기위해 로거기능 사용
	private static final Logger logger = LoggerFactory.getLogger(IdolService.class);
	
		public Map<String, Object> idolSelectListByPage(int currentPage, int rowPerPage, String searchWord){
			
			logger.debug("idolSelectPage() map.startRow = {}", currentPage);
			logger.debug("idolSelectPage() map.rowPerPage = {}", rowPerPage);
			logger.debug("idolSelectPage() map.searchWord = {}", searchWord);
			
			int startRow = (currentPage-1)*rowPerPage;
			Map map = new HashMap();
			map.put("startRow", startRow);
			map.put("rowPerPage", rowPerPage);
			map.put("searchWord", searchWord);
			
			List<Idol> list = idolDao.idolSelectPage(map);
			logger.debug("idolSelectListByPage() list = {}", list);
			int totalCount = idolDao.idolSelectTotalCount();
			logger.debug("idolSelectListByPage() totalCount = {}", totalCount);
			
			Map returnMap = new HashMap();
			returnMap.put("list", list);
			returnMap.put("totalCount", totalCount);
			
			return returnMap;
		}	
		
	
	public List<Idol> idolSelectList(int startRow){
		List<Idol> list = idolDao.idolSelectList();
		logger.debug("idolSelectList() list = {}", list);
		return list;
		
	}
	
	public int idolInsert(IdolCommand idolCommand)  {
		logger.debug("idolInsert() idolName = {}", idolCommand.getIdolName());
		int row = idolDao.idolInsert(idolCommand);
		int generated_id = idolCommand.getIdolId();
		logger.debug("articleInsert() generatedIdolId = {}", generated_id);
		//idolCommand타입에서 MultipartFile타입 리스트 길이만큼 반복
		for(MultipartFile files : idolCommand.getFiles()) {
			IdolFile idolFile = new IdolFile();
			
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString(); // 중복되지 않는 이름으로 랜덤생성
			
			//오리지널 파일 이름
			String idolFileName = files.getOriginalFilename();
			
			//오리지널 파일이름뒤의.이 마지막몇번쨰에 있는지 int값을 반환한다.
			int pos = idolFileName.lastIndexOf(".");
			//오리지널 파일이름에서 pos+1번째까지 문자열을 잘라냄
			String fileExt = idolFileName.substring(pos+1); //확장자
			
			//오리지널 파일 사이즈
			long fileSize = files.getSize();
			
			//매개변수로 쓸 값들을 셋팅
			idolFile.setIdolFileName(fileName);
			idolFile.setIdolFileExt(fileExt);
			idolFile.setIdolFileSize(fileSize);
			idolFile.setIdolId(generated_id);
			
			//2. 파일 저장
			//업로드 경로에 UUID를 통해 랜덤으로 파일명 생성
			File temp = new File(uploadRoot+fileName);
			try {
				//랜덤으로 생성된 파일을 temp에 생성
				files.transferTo(temp);
				//idolFileInsert메소드를 호출
				idolDao.idolInsertFile(idolFile);
			}catch(Exception e) {
				//temp 중복시 삭제
				boolean isExists = temp.exists();
				if(isExists) {
					temp.delete();
					logger.debug("Exception IdolInsert() delete : {}", temp);
				}
				e.printStackTrace();
			}
		}
		logger.debug("idolInsert() row = {}", row);
		return row;
	}
	
	public Idol idolSelectOne(int idolId) {
		logger.debug("idolSelectOne() idolId = {}", idolId);
		Idol idol = idolDao.idolSelectOneForUpdate(idolId);
		logger.debug("idolSelectOne() idol = {}", idol);
		return idol;
	}
	
	public int idolUpdate(Idol idol) {
		logger.debug("idolUpdate() idol = {}", idol);
		int row = idolDao.idolUpdate(idol); 
		logger.debug("idolUpdate() row = {}", row);
		return row;
	}
	
	public int idolDelete(int idolId) {
		logger.debug("idolDelete() idolId = {}", idolId);
		int row = idolDao.idolDelete(idolId);
		logger.debug("idolDelete() row = {}", row);
		return row;
	}
	
}
 