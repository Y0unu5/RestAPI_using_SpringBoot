package com.tns.placementmgmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PlacementController {
	@Autowired
	private PlacementService pservice;

	// Retrieving all the rows from table
	@GetMapping("/placements")
	public List<Placement> list() {

		return pservice.listAll();
	}
	// Retrieving specific records frm db

	@GetMapping("/placements/{id}")
	public ResponseEntity<Placement> get(@PathVariable Integer id) {
		Placement placement = pservice.get(id);

		return new ResponseEntity<Placement>(placement, HttpStatus.OK);
	}

	// Create a new Row in db
	@PostMapping("/placements")
	public void add(@RequestBody Placement placement) {
		pservice.save(placement);
	}

	// Update Operation
	@PutMapping("/placements/id")
	public ResponseEntity<Placement> update(@RequestBody Placement placement, @PathVariable Integer id) {
		try {
			Placement existplacement = pservice.get(id);
			pservice.save(placement);

			return new ResponseEntity<Placement>(placement, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// DELETE OPERATION

	@DeleteMapping("/placements/{id}")
	public void delete(@PathVariable Integer id) {
		pservice.delete(id);
	}

}
