package com.example.tcsassignment1.repository;

import com.example.tcsassignment1.entity.DevelopersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends JpaRepository<DevelopersEntity, Long> {
}
