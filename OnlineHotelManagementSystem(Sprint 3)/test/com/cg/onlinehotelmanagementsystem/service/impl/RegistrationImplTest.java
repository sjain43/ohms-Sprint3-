package com.cg.onlinehotelmanagementsystem.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;
import com.cg.ohms.dto.CustomerDataDTO;
import com.cg.ohms.exception.HMSException;
import com.cg.ohms.service.IRegistration;
import com.cg.ohms.service.impl.RegistrationImpl;
import com.cg.ohms.utility.UserAddressValidator;
import com.cg.ohms.utility.UserDataValidator;

public class RegistrationImplTest {
	UserAddressValidator userAdd = new UserAddressValidator();
	UserDataValidator userData = new UserDataValidator();
	IRegistration register = new RegistrationImpl();

	@Test(expected = HMSException.class)
	public void testUserValidationFailed() throws HMSException, SQLException {
		boolean duplicate = register.userValidation("jains@gmail.com", "8104911278");
	}
	@Test
	public void testUserValidation() throws HMSException, SQLException {
		boolean genuine = register.userValidation("jai@gmail.com", "8104911270");
		assertTrue(genuine);
	}

	@Test
	public void testValidUserFirstName() throws HMSException {
		boolean name = userData.isValidUserFirstName("shubham");
		assertTrue(name);
	}

	@Test(expected = HMSException.class)
	public void testValidUserFirstNameFailed() throws HMSException {
		boolean name = userData.isValidUserFirstName("shubha12");
	}

	@Test
	public void testValidUserSurName() throws HMSException {
		boolean sirname = userData.isValidUserSurName("jain");
		assertTrue(sirname);
	}

	@Test
	public void testValidEmail() throws HMSException {
		boolean email = userData.isValidEmail("shubham@gmail.com");
		assertTrue(email);
	}

	@Test(expected = HMSException.class)
	public void testValidEmailFailed() throws HMSException {
		boolean email = userData.isValidEmail("shubham@");
	}

	@Test
	public void testisValidPhone() throws HMSException {
		boolean phone = userData.isValidPhone("8104911275");
		assertTrue(phone);
	}

	@Test(expected = HMSException.class)
	public void testValidPhoneFailed() throws HMSException {
		boolean phone = userData.isValidPhone("81049112@s");
	}

	@Test(expected = HMSException.class)
	public void testsValidPhoneFailed() throws HMSException {
		boolean phone = userData.isValidPhone("81049112755");
	}

	@Test
	public void testUserValidCity() throws HMSException {
		boolean city = userAdd.isValidCity("jaipur");
		assertTrue(city);
	}

	@Test(expected = HMSException.class)
	public void testUserValidCityFailed() throws HMSException {
		boolean city = userAdd.isValidCity("jaipur@1");
	}

	@Test
	public void testValidPincode() throws HMSException {
		boolean pincode = userAdd.isValidPincode("322001");
		assertTrue(pincode);
	}

	@Test(expected = HMSException.class)
	public void testValidPincodeFailed() throws HMSException {
		boolean pincode = userAdd.isValidPincode("3220011");
	}

	@Test
	public void testValidHomeno() throws HMSException {
		boolean homeno = userAdd.isValidHomeno("15b");
		assertTrue(homeno);
	}
}
