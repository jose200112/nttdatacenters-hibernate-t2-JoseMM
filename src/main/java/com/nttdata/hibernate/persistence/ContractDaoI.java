package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * 
 * @author jose
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract>{
	
	/**
	 * Devuelve una lista de los contratos de un cliente
	 * @param customerId clienteId
	 * @return list
	 */
	public List<Contract> searchByCustomer(Long customerId);
}
