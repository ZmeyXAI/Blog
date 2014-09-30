package com.comspicuum.mvc.dao.plain;

import com.comspicuum.mvc.dao.ContactDao;
import com.comspicuum.mvc.domain.Contact;

import java.sql.*;
import java.util.*;

public class PlainContactDao implements ContactDao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306", "test", "test");

	}

	private void closeConnection(Connection connection) {
		if (connection == null) return;
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<Contact>();
		Connection connection = null;
		try {
			connection = getConnection();

			PreparedStatement statement = connection.prepareStatement("select * from contact");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setBirhtDate(resultSet.getDate("birth_date"));
				result.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Contact> findByFirstName(String FirstName) {
		return null;
	}

	@Override
	public void insert(Contact contact) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into contact (first_name, last_name, birth_date) values (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setDate(3, contact.getBirhtDate());
			statement.execute();

			ResultSet generetedKeys = statement.getGeneratedKeys();
			if (generetedKeys.next()) {
				contact.setId(generetedKeys.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void delete(Long contactId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from contact where id=?");
			statement.setLong(1, contactId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void update(Contact contact) {

	}
}
