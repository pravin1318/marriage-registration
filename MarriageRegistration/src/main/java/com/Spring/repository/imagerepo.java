package com.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.model.imageentity;
@Repository
public interface imagerepo extends JpaRepository<imageentity, Long> {	

}
