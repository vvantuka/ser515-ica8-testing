package src;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;


public class urinalsTest {
    urinals urinal;

    @TempDir
    Path directory;

    @Test
    void demoTestMethod(){
        System.out.println("=====Vishnu Vantukala == TEST ONE EXECUTED=====");
        assertTrue(true);
    }

    @Test
    void testGoodString_happyPath(@TempDir Path directory){
        System.out.println("=====Vishnu Vantukala == TEST TWO EXECUTED=====");
        String str = "10001";
        assertEquals(urinal.goodString(str, new File(directory + "/dummy")), true);
    }

    @Test
    void testGoodString_badPath(@TempDir Path directory){
        System.out.println("=====Vishnu Vantukala == TEST THREE EXECUTED=====");
        String str = "10011";
        assertEquals(urinal.goodString(str, new File(directory + "/dummy")), false);
    }
}