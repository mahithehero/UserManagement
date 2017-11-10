package com.mahi.rest.service;

/**
 * @author Mahendra
 * This interface operates as generic interface
 * which handles the CRUD operations on the service class
 */
import java.io.Serializable;
import java.util.List;

public interface CRUDService<E> {

	E save(E entity);

	E getById(Serializable id);

	List<E> getAll();

	void delete(Serializable id);
}
