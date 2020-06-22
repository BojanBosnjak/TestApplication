package com.bojan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bojan.app.entity.Farm;

public interface FarmRepository extends JpaRepository<Farm, Integer> {
	public Farm findByName(String name);

	@Query("select f from Farm f where f.user.userId =:userId")
	public List<Farm> getUserFarms(Integer userId);
	

		
}
