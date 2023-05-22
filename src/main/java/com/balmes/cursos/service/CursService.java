package com.balmes.cursos.service;

import com.balmes.cursos.exceptions.ResourceNotFoundException;
import com.balmes.cursos.model.Curs;
import com.balmes.cursos.model.Estudiant;
import com.balmes.cursos.repository.CursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CursService implements CrudService<Curs> {
	@Autowired
	private CursRepository repositori;


	@Override
	public List<Curs> findAll() {
		return repositori.findAll();
	}

	@Override
	public Curs save(Curs curs) {
		return repositori.save(curs);
	}

	@Override
	public Curs get(long id) {
		Optional<Curs> curs = repositori.findById(id);

		return curs.get();
	}

	@Override
	public Curs update(Curs curs, long id) throws ResourceNotFoundException {
		Optional<Curs> oldCurs = repositori.findById(curs.getCursId());

		if (!oldCurs.isPresent()) {
			throw new ResourceNotFoundException("Resource Not Found!!!!");
		} else {
			Curs cursToUpdate = oldCurs.get();
			cursToUpdate.setTitolCurs(curs.getTitolCurs());
			cursToUpdate.setDescCurs(curs.getDescCurs());
			cursToUpdate.setUrlCurs(curs.getUrlCurs());
			cursToUpdate.setEstudiants(curs.getEstudiants());
			Curs updatedStudent = repositori.save(cursToUpdate);
			return updatedStudent;
		}
	}

	@Override
	public void deleteById(long id) {
		repositori.deleteById(id);
	}

	@Override
	public void delete(Curs entity) {
		repositori.delete(entity);
	}
}
