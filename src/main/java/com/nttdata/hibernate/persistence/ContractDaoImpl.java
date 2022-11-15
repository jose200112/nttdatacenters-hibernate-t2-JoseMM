package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Dao de contrato
 * @author Jose
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {
	
	/** Sesión de conexión a BD */
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
		
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
				
		return  session.createQuery("FROM Contract WHERE customer='" + customerId + "'").list();
	}
}
