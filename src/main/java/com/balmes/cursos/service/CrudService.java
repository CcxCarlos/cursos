package com.balmes.cursos.service;

import com.balmes.cursos.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

	List<T> findAll();

	T save(T t);
	
	T get(long id);

	T update(T t, long id) throws ResourceNotFoundException;

	void deleteById(long id);

	void delete(T entity);


}
