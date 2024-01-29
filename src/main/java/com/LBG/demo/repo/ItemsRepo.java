package com.LBG.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.demo.domain.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
