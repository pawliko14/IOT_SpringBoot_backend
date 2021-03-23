package com.fat.SentronServices;

import com.fat.SentronEntities.Modbus_data;
import com.fat.SentronRepositories.Modbus_dataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Modbus_dataService {

    @Autowired
    private Modbus_dataRepository modbus_dataRepository;

    public List<Modbus_data> getAll() {
        return  modbus_dataRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Modbus_data> getElementAtIndex(long index) {
        return  modbus_dataRepository.findById(index);
    }



}

