import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void break1() throws IOException{
        Path fileName = Path.of("test-break-1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void break2() throws IOException{
        Path fileName = Path.of("test-break-2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something().com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void break3() throws IOException{
        Path fileName = Path.of("test-break-3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
}