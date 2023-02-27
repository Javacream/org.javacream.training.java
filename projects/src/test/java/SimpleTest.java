import org.javacream.training.java.publishing.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    public void testOk(){
        String message = "Hello";
        String expected = "HELLO";
        String result = message.toUpperCase();
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testNot(){
        String message = "Hello";
        String expected = "hello";
        String result = message.toUpperCase();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void demoBook(){
        Book b1 = new Book("ISBN1", "Title", 19.99);
        var b2 = new Book("ISBN1", "Title", 19.99);//Type Inference, die linke Seite ist vom Typ durch die rechte vollständig definiert
        //b2 = "Hello";
    }


}
