package com.example.demo.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class CategoryRepo  {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class EmployeeRowMapper implements RowMapper <CategoryDTO> {
        @Override
        public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoryDTO category = new CategoryDTO();
            category.setCategoryID(rs.getInt("CategoryID"));
            category.setCategoryName(rs.getString("CategoryName"));

            return category;
        }
    }

    public List <CategoryDTO> findAll() {
        return jdbcTemplate.query("select * from Categories", new EmployeeRowMapper());
    }

    public Optional <CategoryDTO> findById(int id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from Categories where CategoryID=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper <CategoryDTO> (CategoryDTO.class)));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Categories where id=?", new Object[] {
                id
        });
    }

    public int insert(CategoryDTO category) {
        return jdbcTemplate.update("insert into Categories (CategoryName) " + "values(?)",
                new Object[] {
                        category.getCategoryName()
                });
    }

    public int update(CategoryDTO category) {
        return jdbcTemplate.update("update Categories " + " set CategoryName = ? " + " where CategoryID = ?",
                new Object[] {
                        category.getCategoryName(), category.getCategoryID()
                });
    }
}
