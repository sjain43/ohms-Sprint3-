package com.cg.ohms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.ohms.dto.CustomerDataDTO;
import com.cg.ohms.exception.HMSException;
import com.cg.ohms.utility.DbConnection;
import com.cg.ohms.utility.ExceptionMessage;
import com.cg.ohms.utility.SqlQuery;

public class RegisterDaoImp implements IRegisterDao {
	public int validatingCustomerDetail(String email, String phone) throws HMSException {
		Connection connection = DbConnection.getConnection();
		int count = 0;
		PreparedStatement preparedstatement;
		try {
			preparedstatement = connection.prepareStatement(SqlQuery.PHONE_CHECK);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, phone);
			ResultSet resultset = preparedstatement.executeQuery();
		while (resultset.next()) {
		    ++count;
		}
		
		}
			catch (SQLException e) {
			throw new HMSException(ExceptionMessage.SQL_MSG);
		}
		return count;
	}

	public boolean dataInsertion(int userid, CustomerDataDTO user) throws HMSException {
		Connection connection = DbConnection.getConnection();
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(SqlQuery.INSERTING_VALUES);
			preparedstatement.setInt(1, userid);
			preparedstatement.setString(2, user.getFirstname());
			preparedstatement.setString(3, user.getLastname());
			preparedstatement.setString(4, user.getPhone());
			preparedstatement.setString(5, user.getEmail());
			preparedstatement.setString(6, user.getPassword());
			preparedstatement.setString(7, user.getState());
			preparedstatement.setString(8, user.getCity());
			preparedstatement.setInt(9, user.getPincode());
			preparedstatement.setString(10, user.getHomeno());
			int result = preparedstatement.executeUpdate();
			if (result == 1) {
				connection.commit();
				return true;
			} else {
				throw new HMSException(ExceptionMessage.SQL_MSG);
			}

		} catch (SQLException e) {
			throw new HMSException(ExceptionMessage.SQL_MSG);
		}

	}
}
