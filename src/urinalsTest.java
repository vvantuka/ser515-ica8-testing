package src;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void testCheckString_happyPath(){
        System.out.println("=====Vishnu Vantukala == TEST FOUR EXECUTED=====");
        String str = "10001001";
        assertEquals(urinal.checkString(str), true);
    }

    @Test
    void testCheckString_badPath(){
        System.out.println("=====Vishnu Vantukala == TEST FIVE EXECUTED=====");
        String str = "abcdef010";
        assertEquals(urinal.checkString(str), false);
    }

    @Test
    void testreadFile_happyPath() throws IOException{
        System.out.println("=====Vishnu Vantukala == TEST SIX EXECUTED=====");
        String filePath = new File("").getAbsolutePath();

        ArrayList<String> ar_test = new ArrayList<>();
        ar_test.add("dummy_value_in_file");

        assertEquals(urinal.readFile(filePath + "/test_files/dummy_file_for_junit.dat"), ar_test);

    }

    @Test
    void testreadFile_badPath_throws_IOException(){
        System.out.println("=====Vishnu Vantukala == TEST SEVEN EXECUTED=====");
        assertThrows(IOException.class, () -> urinal.readFile("non-existent-file"));
    }

    @Test
    void testreadFile_badPath_empty_file() throws IOException{
        System.out.println("=====Vishnu Vantukala == TEST EIGHT EXECUTED=====");
        String filePath = new File("").getAbsolutePath();
        ArrayList<String> ar_test = new ArrayList<>();

        assertEquals(urinal.readFile(filePath + "/test_files/dummy_empty_file.dat"), ar_test);
    }

    @Test
    void testWriteFile_happyPath(@TempDir Path directory) throws IOException {
        System.out.println("=====Vishnu Vantukala == TEST EIGHT EXECUTED=====");
        String filePath = new File("").getAbsolutePath();
        File file = new File(directory + "/dummy_file_to_write.txt");
        urinal.writeFile("dummy_value", file);

        assertTrue(file.exists());
    }

    @Test
    void testWriteFile_badPath_throws_NULLPointerException(){
        System.out.println("=====Vishnu Vantukala == TEST NINE EXECUTED=====");
        File file = null;
        assertThrows(NullPointerException.class, () -> urinal.writeFile("dummy_text_to_write", file));
    }
}