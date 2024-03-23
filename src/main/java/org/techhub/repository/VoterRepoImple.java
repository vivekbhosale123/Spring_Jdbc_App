package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.model.Voter;
@Repository("voterRepoImple")
public class VoterRepoImple implements VoterRepo {
	@Autowired
	JdbcTemplate template;
	List<Voter> list;
	Voter voter;
	public boolean isAddVoter(final Voter v) {
		int val = template.update("insert into Voter values('0',?,?,?,?)", new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, v.getName());
				ps.setString(2, v.getEmail());
				ps.setString(3, v.getContact());
				ps.setInt(4, v.getAge());
			}
		});
		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Voter> isViewAll() {
		List<Voter> list = template.query("select * from Voter", new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Voter v = new Voter();
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setEmail(rs.getString(3));
				v.setContact(rs.getString(4));
				v.setAge(rs.getInt(5));
				return v;
			}

		});
		return list;
	}
	@Override
	public boolean isDelete(final int id) {
		int val = template.update("delete from Voter where id=?", new Object[] { id });
		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isUpdate(final Voter voter) {
		int val = template.update("update Voter set name=?,email=?,contact=?,age=? where id=?",
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, voter.getName());
						ps.setString(2, voter.getEmail());
						ps.setString(3, voter.getContact());
						ps.setInt(4, voter.getAge());
						ps.setInt(5, voter.getId());
					}
				});
		if (val > 0) {
			return true;
		} else {
			return false;
		}
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Voter isSearch(int id) {
		voter = (Voter) template.queryForObject("select * from Voter where id=?", new Object[] { id }, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Voter v = new Voter();
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setEmail(rs.getString(3));
				v.setContact(rs.getString(4));
				v.setAge(rs.getInt(5));
				return v;
			}
		});
		return voter;
	}
}
