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
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
	
	//업로드 경로를 final로 선언하여 상수화하여 사용한다.
	private final String uploadRoot= "c:\\upload\\";
	
	public List<ArticleFile> articleFileSelectList(int articleId) {
		List<ArticleFile> list = articleDao.articleFileSelectList(articleId);
		return list;
	}
	
	//추가 기능을 수행하는 요청을 처리
	public void articleInsert(ArticleCommand articleCommand) {
		
		logger.debug("articleInsert() articleCommand = {}", articleCommand);
		
		//매개변수 ArticleCommand타입에서 Article타입을 뽑아낸다.
		Article article = new Article();
		article.setArticleTitle(articleCommand.getArticleTitle());
		
		//위에서 뽑아낸 Article타입을 매개변수로하여 Dao의 메서드를 호출하여 title을 insert한다.
		
		articleDao.insertArticle(article);
		int generated_id = article.getArticleId();
		logger.debug("articleInsert() generatedArticleId = {}", generated_id);
		
		//articleCommand타입에서 MultipartFile타입 리스트 길이만큼 반복한다.
		for(MultipartFile files : articleCommand.getFiles()) {
			ArticleFile articleFile = new ArticleFile();
					
			//겹치지 않는 값을 사용하기위해 랜덤UUID메서드를 사용하여 오리지널 파일이름을 사용하는 대신 사용한다.
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString();	//중복되지 않는 이름 랜덤....
			
			//오리지날 파일이름
			String articleFileName = files.getOriginalFilename();	
			
			//오리지널 파일이름에서 .이 마지막몇번째에 있는지 int값을 반환한다.
			int pos = articleFileName.lastIndexOf(".");
			//오리지널 파일이름에서 pos+1번째까지의 문자열을 잘라낸다.
			String fileExt = articleFileName.substring( pos + 1 );
			
			//오리지날 파일 사이즈
			long fileSize = files.getSize();	
			
			//구한값들을 매개변수로 쓸 ArticleFile 타입의 변수에 세팅한다.
			articleFile.setFileName(fileName);
			articleFile.setFileExt(fileExt);
			articleFile.setFileSize(fileSize);
			articleFile.setArticleId(generated_id);

			// 2. 파일을 저장 
			// 상수와 시킨 업로드 경로에 UUID로 랜덤값을 파일명으로하는 파일을 생성한다.
			File temp = new File(uploadRoot+fileName);
			try {
				//files내용을 새로생성한 temp파일에 복사한다.
				files.transferTo(temp);	
				//Dao에 articleFile을 insert하는 메서드를 호출하여 db에 insert해준다.
				articleDao.insertArticleFile(articleFile);
			} catch (IllegalStateException e) {
				//temp파일이 있다면 삭제시킨다.
				boolean isExists = temp.exists();				
				if(isExists) {
					temp.delete();
					logger.debug("IllegalStateException articleInsert() delete : {}", temp);
				}
				e.printStackTrace();
			} catch (IOException e) {
				boolean isExists = temp.exists();				
				if(isExists) {
					temp.delete();
					logger.debug("IOException articleInsert() delete : {}", temp);
				}
				e.printStackTrace();
			}		
		}
		
	}
	
	public Map<String, Object> articleSelectListByPage(int currentPage, int rowPerPage, String searchWord){
		
		logger.debug("articleSelectListByPage() currentPage = {}", currentPage);
		logger.debug("articleSelectListByPage() rowPerPage = {}", rowPerPage);
		logger.debug("articleSelectListByPage() searchWord = {}", searchWord);
		
		int startRow = (currentPage-1)*rowPerPage;
		Map map = new HashMap();
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		
		List<Article> list = articleDao.articleSelectPage(map);
		logger.debug("articleSelectListByPage() list = {}", list);
		int totalCount = articleDao.articleSelectTotalCount();
		logger.debug("articleSelectListByPage() totalCount = {}", totalCount);
		
		Map returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("totalCount", totalCount);
		
		return returnMap;
	}
			

}
