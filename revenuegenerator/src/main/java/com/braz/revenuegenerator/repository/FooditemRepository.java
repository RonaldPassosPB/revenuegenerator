package com.braz.revenuegenerator.repository;

import com.braz.revenuegenerator.Model.Fooditem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FooditemRepository extends JpaRepository<Fooditem, Long> {
}
