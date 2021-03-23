package com.fat.SentronRepositories;

import com.fat.SentronEntities.Modbus_historical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Modbus_historicalRespository  extends JpaRepository<Modbus_historical, Long> {
}
