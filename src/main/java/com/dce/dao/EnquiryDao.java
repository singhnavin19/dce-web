package com.dce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.dce.entity.Admission;
import com.dce.entity.Enquiry;

@Component
public class EnquiryDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	JdbcTemplate jdbctemplate;

	public String insert(Enquiry studentenquiry) {

		String nextID = this.getNextIDno("tenquiry");
		studentenquiry.setTempId(
				studentenquiry.getFirstName().substring(0, 2).toUpperCase() + (nextID == null ? "1" : nextID));
		studentenquiry.setDateOfEnquiry(new Date());
		StringBuffer query = new StringBuffer();
		this.enquiryInsertQuery(query);
		this.namedParameterJdbcTemplate.update(query.toString(), new BeanPropertySqlParameterSource(studentenquiry));

		return studentenquiry.getTempId();
	}

	private void enquiryInsertQuery(StringBuffer query) {
		query.append("INSERT INTO tenquiry (");
		query.append("first_name, ");
		query.append("middle_name, ");
		query.append("last_name, ");
		query.append("gender, ");
		query.append("qualification, ");
		query.append("profession, ");
		query.append("address, ");
		query.append("mobile_no, ");
		query.append("email_id, ");
		query.append("course, ");
		query.append("fess,remarks, ");
		query.append("dateOfEnquiry,temp_id");
		query.append(" ) VALUES ( ");
		query.append(" :firstName, ");
		query.append(" :middleName, ");
		query.append(" :lastName, ");
		query.append(" :gender, ");
		query.append(" :qualification, ");
		query.append(" :profession, ");
		query.append(" :address, ");
		query.append(" :mobileNo, ");
		query.append(" :emailId, ");
		query.append(" :course, ");
		query.append(" :fess, :remarks, ");
		query.append(" :dateOfEnquiry, :tempId )");
	}

	public void update(Enquiry studentEnquiry) {
		StringBuilder query = new StringBuilder();

		query.append("UPDATE tenquiry ");
		query.append("set first_name =:firstName, ");
		query.append("middle_name =:middleName, ");
		query.append("last_name =:lastName, ");
		query.append("gender =:gender, ");
		query.append("qualification =:qualification, ");
		query.append("profession =:profession, ");
		query.append("address =:address, ");
		query.append("mobile_no =:mobileNo, ");
		query.append("email_id =:emailId, ");
		query.append("course =:course, ");
		query.append("fess =:fess,remarks =:remarks ");
		query.append("WHERE temp_id =:tempId");

		this.namedParameterJdbcTemplate.update(query.toString(), new BeanPropertySqlParameterSource(studentEnquiry));
	}

	public List<Admission> fetch(Admission admission) {
		StringBuffer query = new StringBuffer();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tempID", admission.getTempId() + "%");

		query.append("SELECT * FROM tenquiry ");
		query.append("WHERE temp_id like :tempId");
		List<Admission> liststudentEnquiry = this.namedParameterJdbcTemplate.query(query.toString(), param,
				new RowMapper<Admission>() {

					@Override
					public Admission mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admission admission = new Admission();
						admission.setFirstName(rs.getString(1));
						admission.setMiddleName(rs.getString(2));
						admission.setLastName(rs.getString(3));
						admission.setGender(rs.getString(4));
						admission.setQualification(rs.getString(5));
						admission.setProfession(rs.getString(6));
						admission.setAddress(rs.getString(7));
						admission.setMobileNo(rs.getString(8));
						admission.setEmailId(rs.getString(9));
						admission.setCourse(rs.getString(10));
						admission.setFess(rs.getDouble(11));
						admission.setDateOfEnquiry(rs.getDate(12));
						admission.setTempId(rs.getString(13));

						return admission;
					}
				});

		return liststudentEnquiry;
	}

	public void delete(String id) {
		StringBuffer query = new StringBuffer();

		query.append("DELETE FROM tenquiry ");
		query.append("WHERE first_name=?");
	}

	public String getNextIDno(String tableName) {
		StringBuilder query = new StringBuilder();
		Object[] inputs = new Object[] { 0 };

		query.append("select max(srno)+1 from ");
		query.append(tableName);
		query.append(" where srno>? ");

		return this.jdbctemplate.queryForObject(query.toString(), inputs, String.class);
	}

	public Enquiry getEnquiryByTempID(String tempId) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> param = new HashMap<>();

		param.put("tempId", tempId);
		query.append("SELECT * FROM tenquiry ");
		query.append("WHERE temp_id =:tempId ");

		List<Enquiry> temp = this.namedParameterJdbcTemplate.query(query.toString(), param,
				new BeanPropertyRowMapper<Enquiry>(Enquiry.class));
		if (temp != null && !temp.isEmpty()) {

		}
		return temp.get(0);
	}

}
