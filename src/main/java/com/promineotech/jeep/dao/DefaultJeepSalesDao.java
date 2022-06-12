package com.promineotech.jeep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultJeepSalesDao implements JeepSalesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
    log.info("Dao fetch Jeeps model={}, trim={}", model, trim);

    String sql = "SELECT * FROM models WHERE model_id = :model_id AND trim_level = :trim_level";
    
    Map<String, Object> parms = new HashMap<>();
    parms.put("model_id", model.toString());
    parms.put("trim_level", trim);
    
    return jdbcTemplate.query(sql, parms, new RowMapper<>() {
      @Override
      public Jeep mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:on
        return Jeep.builder()
            .basePrice(rs.getBigDecimal("base_price"))
            .modelId(JeepModel.valueOf(rs.getString("model_id")))
            .modelPk(rs.getLong("model_pk"))
            .numDoors(rs.getInt("num_doors"))
            .trimLevel(rs.getString("trim_level"))
            .wheelSize(rs.getInt("wheel_size"))
            .build();
        // @formatter:off
      }});
  }

}
