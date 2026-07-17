package com.ll.wiseSaying;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void 더하기() {
        assertEquals(30, 30);
    }

    public static void clear() {
        String path = System.getProperty("user.dir") + "/src/main/java/com/ll/wiseSaying/db/wiseSaying/";
        File file = new File(path + "data.json");
        if (file.exists()) {
            file.delete();
        }
    }

    public static String run(String input) {
        Scanner scanner = TestUtil.getScanner(input);
        ByteArrayOutputStream out = TestUtil.setOutToByteArray();

        try {
            App.run(scanner);
        } catch (NoSuchElementException e) {

        }

        TestUtil.clearSetOutToByteArray(out);
        return out.toString();
    }
}