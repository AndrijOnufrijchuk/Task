package com.example.demo.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.InventoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class InventoryListRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper <InventoryList> {
        @Override
        public InventoryList mapRow(ResultSet rs, int rowNum) throws SQLException {
            InventoryList inventoryList = new InventoryList();
            inventoryList.setProductID(rs.getInt("ProductID"));
            inventoryList.setProductName(rs.getString("ProductName"));
            inventoryList.setCategoryName(rs.getString("CategoryName"));

            return inventoryList;
        }
    }

    public List < InventoryList > findAll() {
        return jdbcTemplate.query("select * from InventoryList", new EmployeeRowMapper());
    }

    public Optional < InventoryList > findById(int id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from InventoryList where ProductID=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper < InventoryList > (InventoryList.class)));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from InventoryList where ProductID=?", new Object[] {
                id
        });
    }

    public int insert(InventoryList inventoryList) {
        return jdbcTemplate.update("insert into InventoryList (ProductName,CategoryName) " + "values(?,?)",
                new Object[] {
                        inventoryList.getProductName() , inventoryList.getCategoryName()
                });
    }

    public int update(InventoryList inventoryList) {
        return jdbcTemplate.update("update InventoryList " + " set ProductName = ?,CategoryName = ?   " + " where ProductID = ?",
                new Object[] {
                        inventoryList.getProductName(), inventoryList.getCategoryName(),inventoryList.getProductID()
                });
    }
}
