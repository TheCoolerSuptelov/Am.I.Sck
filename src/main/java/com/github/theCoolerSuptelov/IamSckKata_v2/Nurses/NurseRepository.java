package com.github.theCoolerSuptelov.IamSckKata_v2.Nurses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NurseRepository extends JpaRepository<Nurse, UUID> {
}