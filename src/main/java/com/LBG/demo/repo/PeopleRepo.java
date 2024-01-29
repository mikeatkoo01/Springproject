package com.LBG.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.demo.domain.People;

public interface PeopleRepo extends JpaRepository<People, Integer> {

}
