package com.m2u.interview.file.map;

public interface DataFileMap<T>  {
    Class<T> getParameterClass();
    T populate(String message);
}
