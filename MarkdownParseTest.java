import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testBreakFile0() throws IOException {
        Path fileName = Path.of("break0.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile1() throws IOException {
        Path fileName = Path.of("break1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile2() throws IOException {
        Path fileName = Path.of("break2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something().com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile3() throws IOException {
        Path fileName = Path.of("break3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile9() throws IOException {
        Path fileName = Path.of("break9.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakLab1() throws IOException {
        Path fileName = Path.of("labbreak1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("url.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakLab2() throws IOException {
        Path fileName = Path.of("labbreak2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("b.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakLab3() throws IOException {
        Path fileName = Path.of("labbreak3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(" https://www.twitter.com ","https://cse.ucsd.edu/"), MarkdownParse.getLinks(contents));
    }
}