package com.balmes.cursos.service;


import com.balmes.cursos.exceptions.ResourceNotFoundException;
import com.balmes.cursos.model.Estudiant;
import com.balmes.cursos.repository.EstudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantService implements CrudService<Estudiant> {
	@Autowired
	private EstudiantRepository repository;

	@Override
	public List findAll() {
		return repository.findAll();
	}

	@Override
	public Estudiant save(Estudiant estudiant) {
		return repository.save((Estudiant) estudiant);
	}

	@Override
	public Estudiant get(long id) {
		Optional<Estudiant> student = repository.findById(id);

		return student.get();
	}

	@Override
	public Estudiant update(Estudiant student, long id) throws ResourceNotFoundException {

		Optional<Estudiant> oldStudent = repository.findById(student.getEstudiantId());

		if (!oldStudent.isPresent()) {
			throw new ResourceNotFoundException("Resource Not Found!!!!");
		} else {
			Estudiant studentToUpdate = oldStudent.get();
			studentToUpdate.setEstudiantNom(student.getEstudiantNom());
			studentToUpdate.setEstudiantCognom(student.getEstudiantCognom());
			Estudiant updatedStudent = repository.save(studentToUpdate);
			return updatedStudent;
		}
	}

	@Override
	public void deleteById(long id) {
		repository.delete(new Estudiant(id));
	}

	@Override
	public void delete(Estudiant entity) {
		repository.delete(entity);
	}
}
