package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Clase del Dao de cliente
 * 
 * @author Jose
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {
	/** Sesi�n de conexi�n a BD */
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session (sesion)
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByNameAndSurnames(final String name, final String firstSurname,
			final String secondSurname) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve los clientes en funci�n del nombre y apellidos.
		return session.createQuery("FROM Customer WHERE name='" + name + "' and first_Surname='" + firstSurname + "'"
				+ " and second_Surname='" + secondSurname + "'").list();
	}

}
