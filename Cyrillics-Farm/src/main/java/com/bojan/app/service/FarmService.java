package com.bojan.app.service;

import java.util.List;

import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.pojo.FarmModel;


public interface FarmService {
	FarmModel saveFarm(FarmModel farm);

	FarmModel updateFarm(Integer farmId, FarmModel farm) throws ResourceNotFoundException;

	void deleteById(Integer farmId);

	List<FarmModel> getAllFarms();

	FarmModel findById(Integer id) throws ResourceNotFoundException;
	List<FarmModel> getUserFarms(Integer userId);
}
