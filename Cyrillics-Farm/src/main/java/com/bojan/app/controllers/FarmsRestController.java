package com.bojan.app.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bojan.app.service.FarmService;
import com.bojan.pojo.FarmModel;

import javassist.NotFoundException;

@RestController
public class FarmsRestController {

	@Autowired
	private FarmService farmService;

	@GetMapping("/farms")
	public List<FarmModel> getAllFarms() {
		return farmService.getAllFarms();
	}

	@GetMapping("/farms/{farmId}")
	public FarmModel findFarmById(@PathVariable("farmId") Integer farmId) throws NotFoundException {

		return farmService.findById(farmId);
	}

	@GetMapping("/farms/user/{userId}")
	public List<FarmModel> findFarmByUserId(@PathVariable("userId") Integer userId) throws NotFoundException {

		return farmService.getUserFarms(userId);
	}

	@PostMapping("/farms/create")
	public FarmModel createFarm(@Valid @RequestBody FarmModel farm) {
		return farmService.saveFarm(farm);
	}

	@PutMapping("/farms/{farmId}")
	public FarmModel updateFarm(@PathVariable("farmId") Integer farmId, @Valid @RequestBody FarmModel modelRequest)
			throws NotFoundException {
		return farmService.updateFarm(farmId, modelRequest);

	}

	@DeleteMapping("/farms/{farmId}")
	public void deleteById(@PathVariable Integer farmId) {
		farmService.deleteById(farmId);
	}

}
