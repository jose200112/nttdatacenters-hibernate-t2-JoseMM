package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Dao de contrato
 * @author Jose
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {
	
	/** Sesi�n de conexi�n a BD */
	private Session session;
	
	/**
	 * Metodo constructor
	 * @param session (session)
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByCustomer(Long customerId) {
		
		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
				
		return  session.createQuery("FROM Contract WHERE customer='" + customerId + "'").list();
	}
}
