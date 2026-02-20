package io.github.yuri.book_search.services;

public interface IDataConvercy {
    <T> T getData(String json, Class<T> tclass);
}
