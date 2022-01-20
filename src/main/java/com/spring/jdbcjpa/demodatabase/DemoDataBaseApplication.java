package com.spring.jdbcjpa.demodatabase;

import com.spring.jdbcjpa.demodatabase.entity.Person;
import com.spring.jdbcjpa.demodatabase.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.util.Date;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoDataBaseApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;

//	class PersonRowMapper implements RowMapper<Person>{
//
//		@Override
//		public Person mapRow(ResultSet rs,int rowNum) {
//			Person person=new Person();
//			person.setId(rs.getInt("id"));
//			person.setName(rs.getString("name"));
//		}
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoDataBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		personJdbcDao.createTablePerson();
		logger.info("All data in table -> {}", personJdbcDao.findAll());
		logger.info("data for a id -> {}",personJdbcDao.findById(10002));
		logger.info("records deleted -> {}",personJdbcDao.deleteById(10002));
		Person person = new Person();
		person.setId(1);
		Date date = new Date(2022-01-07);
		person.setBirthDate(date);
		person.setLocation("Rourkela");
		person.setName("Neil");
		logger.info("After data insertion -> {}",personJdbcDao.insertData(person));
	}


}
