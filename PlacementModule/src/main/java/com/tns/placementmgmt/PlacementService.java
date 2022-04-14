package com.tns.placementmgmt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlacementService {

	@Autowired
	private PlacementRepository repository;

	public List<Placement> listAll() {

		return repository.findAll();
	}

	public Placement get(Integer id) {

		return repository.findById(id).get();
	}

	public void save(Placement placement) {
		repository.save(placement);

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
