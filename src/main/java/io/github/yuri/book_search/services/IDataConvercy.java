package io.github.yuri.book_search.services;

import java.util.List;

public interface IDataConvercy {
    <T> T getData(String json, Class<T> tclass);
    <T> List<T> getList(String json, Class<T> tclass);
}
