package io.github.yuri.book_search.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.yuri.book_search.models.BookResultsDTO;

import java.util.List;

public class DataConvercy implements IDataConvercy{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> tclass) {
        try {
            return mapper.readValue(json, tclass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> tclass) {
        JavaType type = mapper.getTypeFactory()
                .constructCollectionType(List.class, tclass);

        try {
            return mapper.readValue(json, type);
        } catch (Exception e){
            throw new RuntimeException("erro na lista", e);
        }
    }
}
