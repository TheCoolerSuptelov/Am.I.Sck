package com.github.theCoolerSuptelov.IamSckKata_v2.ServicesLog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicesLogRepository extends JpaRepository<ServicesLog, UUID> {
}