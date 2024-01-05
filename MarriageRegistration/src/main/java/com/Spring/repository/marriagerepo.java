package com.Spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.model.Marriagedata;
@Repository
public interface marriagerepo extends JpaRepository<Marriagedata, Long>{
	
	List<Marriagedata> getByFlag(long flag);
	

}
