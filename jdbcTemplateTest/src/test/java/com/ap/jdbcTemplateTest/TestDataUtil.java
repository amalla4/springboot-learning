package com.ap.jdbcTemplateTest;

import com.ap.jdbcTemplateTest.domain.Author;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthor() {
        return Author.builder().id(1L).name("AP Malla").age(27).build();
    }
}
