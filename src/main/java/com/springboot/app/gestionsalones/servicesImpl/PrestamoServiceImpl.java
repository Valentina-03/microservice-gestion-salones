package com.springboot.app.gestionsalones.servicesImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.gestionsalones.entities.Prestamo;
import com.springboot.app.gestionsalones.repositories.PrestamoRepository;
import com.springboot.app.gestionsalones.services.PrestamoService;

@Service
public class PrestamoServiceImpl implements PrestamoService
{
	@Autowired
	PrestamoRepository data;
	
	@Override
	@Transactional (readOnly = true)
	public List<Prestamo> findAll(){
		return (List<Prestamo>) data.findAll();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Prestamo findById (Integer id) {
		return data.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Prestamo save (Prestamo nuevo) {
		return data.save(nuevo);
	}
	
	@Override
	@Transactional
	public void update (Prestamo nuevo) {
		Prestamo actual = data.findById(nuevo.getId_prestamo()).orElse(null);
		if(actual != null) {
			//actual.setDetalle(nuevo.getDetalle());
			actual.setNovedad(nuevo.getNovedad());
			actual.setObservaciones(nuevo.getObservaciones());
			
			data.save(actual);
		}
	}
	
	@Override
	@Transactional
	public void deleteById (Integer id) {
		data.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Prestamo actual) {
		data.delete(actual);		
	}
}