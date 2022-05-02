package com.github.theCoolerSuptelov.IamSckKata_v2.Utils;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ActorRepository extends JpaRepository<Actor, UUID> {
  Actor findByEmailEquals(String email);
  List<Actor> findAll();
}