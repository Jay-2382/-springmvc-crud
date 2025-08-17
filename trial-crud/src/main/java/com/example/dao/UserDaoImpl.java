//package com.example.dao;
//
//import com.example.model.User;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public void save(User user) {
//        jdbcTemplate.update("INSERT INTO users(name, email) VALUES (?, ?)",
//                            user.getName(), user.getEmail());
//    }
//
//    public void update(User user) {
//        jdbcTemplate.update("UPDATE users SET name=?, email=? WHERE id=?",
//                            user.getName(), user.getEmail(), user.getId());
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
//    }
//
//    public User get(int id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
//            new Object[]{id}, new UserRowMapper());
//    }
//
//    public List<User> list() {
//        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
//    }
//
//    class UserRowMapper implements RowMapper<User> {
//        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//            User u = new User();
//            u.setId(rs.getInt("id"));
//            u.setName(rs.getString("name"));
//            u.setEmail(rs.getString("email"));
//            return u;
//        }
//    }
//}

package com.example.dao;

import com.example.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO users(name, email, country) VALUES (?, ?, ?)",
                user.getName(), user.getEmail(), user.getCountry());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(
                "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?",
                user.getName(), user.getEmail(), user.getCountry(), user.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public User get(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE id = ?",
                new Object[] { id },
                new UserRowMapper());
    }

    @Override
    public List<User> list() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    @Override
    public List<User> listSortedByName() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name ASC", new UserRowMapper());
    }

    @Override
    public List<User> listSortedByCountry() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY country ASC", new UserRowMapper());
    }

    @Override
    public List<User> searchByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM users WHERE name ILIKE ?",
                new Object[] { "%" + name + "%" },
                new UserRowMapper());
    }

    @Override
    public List<User> searchByCountry(String country) {
        return jdbcTemplate.query(
                "SELECT * FROM users WHERE country ILIKE ?",
                new Object[] { "%" + country + "%" },
                new UserRowMapper());
    }

    class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setCountry(rs.getString("country")); 
            return u;
        }
    }
}
