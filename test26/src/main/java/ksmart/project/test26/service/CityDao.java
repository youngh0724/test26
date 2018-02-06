package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
   @Autowired
   private SqlSessionTemplate sst;
   
   // DELETE
   public void deleteCity(int city_id) {
      sst.delete("ksmart.project.test26.service.CityMapper.deleteCityName",city_id);
   }
   
   // INSERT
   public void insertCity(City city) {
      sst.insert("ksmart.project.test26.service.CityMapper.insertCityName",city);
   }
   
   // SELECT ONE
   public City getCity(int city_id) {
      return sst.selectOne("ksmart.project.test26.service.CityMapper.selectCityOne",city_id);
   }
   
   // UPDATE
   public int updateCity(City city) {
      return sst.update("ksmart.project.test26.service.CityMapper.updateCityName",city);
   }
   
   // SELECT
   public List<City> selectCityList(){
      return sst.selectList("ksmart.project.test26.service.CityMapper.selectCityList");
   }
   
   
}
