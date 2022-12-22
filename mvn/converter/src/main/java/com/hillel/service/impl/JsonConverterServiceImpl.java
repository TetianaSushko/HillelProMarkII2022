package com.hillel.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hillel.service.ConverterService;
import com.hillel.service.exception.JsonConvertationFault;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class JsonConverterServiceImpl implements ConverterService {
    @Override
    public String convert(String data) {
        try {
            return new Yaml().dump(
                    new ObjectMapper().readValue(data, Map[].class)
            );
        } catch (JsonProcessingException e) {
            throw new JsonConvertationFault();
        }
    }
}
