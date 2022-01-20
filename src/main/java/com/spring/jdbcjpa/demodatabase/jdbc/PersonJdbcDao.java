package com.spring.jdbcjpa.demodatabase.jdbc;

import com.spring.jdbcjpa.demodatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {


    @Autowired
    JdbcTemplate jdbcTemplate;


    //Select * from Person
    public List<Person> findAll(){

        return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
    }
    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
    }
    public int deleteById(int id){
       return jdbcTemplate.update("delete from person where id=?",new Object[]{id});
//        return findAll();
    }

    public List<Person> insertData(Person person) {
        jdbcTemplate.update("insert into person (id, name, location, birth_date ) values(?,?,?,?)",
                new Object[]{person.getId(),person.getName(),person.getLocation(),person.getBirthDate()});
        return findAll();
    }
}
