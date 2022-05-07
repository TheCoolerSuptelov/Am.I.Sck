package com.github.theCoolerSuptelov.IamSckKata_v2.Utils;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthoritiesRepository extends JpaRepository<Authorities, UUID> {
  Authorities findByTitleEquals(String title);

}