package com.bojan.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bojan.app.entity.Farm;
import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.app.repository.FarmRepository;
import com.bojan.pojo.FarmModel;

@Service
public class FarmServiceImplementation implements FarmService {
	@Autowired
	private FarmRepository farmRepository;

	@Override
	public FarmModel saveFarm(FarmModel farm) {
		
		Farm farmEntity = new Farm();
		farmEntity.setName(farm.getName());
		farmRepository.save(farmEntity);
		return toModel(farmEntity);
	}

	@Override
	public FarmModel updateFarm(Integer farmId, FarmModel farm) throws ResourceNotFoundException {
		Optional<Farm> theFarm = farmRepository.findById(farmId);
		if (theFarm.isEmpty()) {
			throw new ResourceNotFoundException("Farm not found");
		}
		Farm farmEntity = theFarm.get();
		farmEntity.setName(farm.getName());
		farmRepository.save(farmEntity);
		return toModel(farmEntity);

	}

	@Override
	public void deleteById(Integer farmId) {
		farmRepository.deleteById(farmId);
	}

	@Override
	public FarmModel findById(Integer id) throws ResourceNotFoundException {
		Optional<Farm> farmOptional = farmRepository.findById(id);
		if (farmOptional.isEmpty()) {
			throw new ResourceNotFoundException("Farm not found");
		}
		return toModel(farmOptional.get());
	}

	@Override
	public List<FarmModel> getAllFarms() {
		List<Farm> entities = farmRepository.findAll();

		List<FarmModel> result = new ArrayList<>();
		for (Farm farm : entities) {
			result.add(toModel(farm));
		}
		return result;
	}

	@Override
	public List<FarmModel> getUserFarms(Integer userId) {
		List<Farm> entities = farmRepository.getUserFarms(userId);

		List<FarmModel> result = new ArrayList<>();
		for (Farm farm : entities) {
			result.add(toModel(farm));
		}
		return result;
	}
	
	/*
	 * Method that will do the transition between entity and model
	 */
	private FarmModel toModel(Farm entity) {
		FarmModel f = new FarmModel();
		f.setFarmId(entity.getFarmId());
		f.setName(entity.getName());
		return f;
	}

}
