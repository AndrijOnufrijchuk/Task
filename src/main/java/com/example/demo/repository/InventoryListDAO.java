package com.example.demo.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.InventoryListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class InventoryListDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper <InventoryListDTO> {
        @Override
        public InventoryListDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            InventoryListDTO inventoryList = new InventoryListDTO();
            inventoryList.setProductID(rs.getInt("ProductID"));
            inventoryList.setProductName(rs.getString("ProductName"));
            inventoryList.setCategoryName(rs.getString("CategoryName"));

            return inventoryList;
        }
    }

    public List <InventoryListDTO> findAll() {
        return jdbcTemplate.query("select * from InventoryList", new EmployeeRowMapper());
    }

    public Optional <InventoryListDTO> findById(int id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from InventoryList where ProductID=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper <InventoryListDTO> (InventoryListDTO.class)));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from InventoryList where ProductID=?", new Object[] {
                id
        });
    }

    public int insert(InventoryListDTO inventoryList) {
        return jdbcTemplate.update("insert into InventoryList (ProductName,CategoryName) " + "values(?,?)",
                new Object[] {
                        inventoryList.getProductName() , inventoryList.getCategoryName()
                });
    }

    public int update(InventoryListDTO inventoryList) {
        return jdbcTemplate.update("update InventoryList " + " set ProductName = ?,CategoryName = ?   " + " where ProductID = ?",
                new Object[] {
                        inventoryList.getProductName(), inventoryList.getCategoryName(),inventoryList.getProductID()
                });
    }
}
