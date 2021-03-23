package com.fat.SentronRepositories;

import com.fat.SentronEntities.Modbus_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Modbus_dataRepository extends JpaRepository<Modbus_data, Long> {
}
