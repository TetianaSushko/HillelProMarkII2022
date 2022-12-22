package com.hillel.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hillel.service.ConverterService;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.Map;


public class YamlConverterServiceImpl implements ConverterService {

    @Override
    public String convert(String data) throws JsonProcessingException {
        Yaml yaml = new Yaml(new Constructor(Map[].class));
        Map[] obj = yaml.load(data);
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
