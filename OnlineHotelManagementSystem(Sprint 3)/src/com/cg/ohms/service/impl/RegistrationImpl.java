package com.cg.ohms.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import com.cg.ohms.dao.IRegisterDao;
import com.cg.ohms.dao.RegisterDaoImp;
import com.cg.ohms.dto.CustomerDataDTO;
import com.cg.ohms.exception.HMSException;
import com.cg.ohms.service.IRegistration;
import com.cg.ohms.utility.ExceptionMessage;

/**
 * User registration class
 * 
 * @author trainee
 *
 */
public class RegistrationImpl implements IRegistration {
	@Override
	public int userRegistration(CustomerDataDTO user) throws HMSException {
		// method for doing customer registration
		int id = (int) (ThreadLocalRandom.current().nextDouble() * 10000);
		IRegisterDao register = new RegisterDaoImp();
		register.dataInsertion(id, user);
		return id;

	}

	@Override
	public boolean userValidation(String email, String phone) throws HMSException {
		// Method for checking customer validation

		IRegisterDao register = new RegisterDaoImp();
		int count = register.validatingCustomerDetail(email,phone);
		if(count==0) {
			return true;
		}
		else {
			throw new HMSException(ExceptionMessage.USER_MSG);
		}
	}

}