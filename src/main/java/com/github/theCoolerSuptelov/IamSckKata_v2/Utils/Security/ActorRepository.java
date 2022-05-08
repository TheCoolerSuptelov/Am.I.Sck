package com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security;

import com.github.theCoolerSuptelov.IamSckKata_v2.Utils.Security.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ActorRepository extends JpaRepository<Actor, UUID> {
  Actor findByEmailEquals(String email);
  List<Actor> findAll();
}