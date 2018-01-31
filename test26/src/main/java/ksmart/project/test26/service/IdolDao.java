package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	@Autowired
	private SqlSessionTemplate sst;
	public List<Idol> selectIdolList(){
		return sst.selectList("ksmart.project.test26.service.IdolMapper.selectIdolList");
	}
}
