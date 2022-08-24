package com.exam.Exception;

import java.util.function.Supplier;

public class QuestionNotExistException {
    public QuestionNotExistException(String s) throws Exception {
        throw new Exception(s);
    }
}
