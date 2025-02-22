package com.example.multiModule.common.spring.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generators extends RandomStringUtils{
    private static final String PHONE_BASE = "7900";
    private static final List<String> NAME_BASE = new ArrayList<>();
    private static final List<String> SURNAME_BASE = new ArrayList<>();
    private static final Random random = new Random();

    static {
        try {
            for (String line : Files.readAllLines(
                    Paths.get("D:\\Idea_Projects\\multyBaseApp\\multi-module-common\\src\\main\\resources\\fios.csv"))){
                SURNAME_BASE.add(line.split(";")[0]);
                NAME_BASE.add(line.split(";")[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateRandomFio(){
        return SURNAME_BASE.get(random.nextInt(SURNAME_BASE.size())) +
                " " + NAME_BASE.get(random.nextInt(NAME_BASE.size()));
    }

    public static String generateRandomPhoneNumber() {
        return PHONE_BASE + Generators.randomNumeric(7);
    }
}
