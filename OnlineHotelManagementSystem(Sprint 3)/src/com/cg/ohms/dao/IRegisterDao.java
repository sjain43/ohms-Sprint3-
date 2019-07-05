package com.cg.ohms.dao;


import com.cg.ohms.dto.CustomerDataDTO;
import com.cg.ohms.exception.HMSException;

public interface IRegisterDao {

	public int validatingCustomerDetail(String email,String phone) throws HMSException;
	public boolean dataInsertion(int userid, CustomerDataDTO user) throws HMSException;
}
