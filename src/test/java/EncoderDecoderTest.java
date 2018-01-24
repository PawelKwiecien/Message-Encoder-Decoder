import org.junit.Test;
import pl.pawelkwiecien.EncoderDecoder;

import static org.junit.Assert.*;

public class EncoderDecoderTest {

    public static EncoderDecoder encoderDecoder = new EncoderDecoder();

    @Test
    public void encoderTest_01() {
        String input = "xyz";
        int key = 25;
        assertEquals("345", encoderDecoder.encode(input, key));
    }

    @Test
    public void encoderTest_02() {
        String input = "xyz";
        int key = 50;
        assertEquals("LMN", encoderDecoder.encode(input, key));
    }

    @Test
    public void encoderTest_03() {
        String input = "xyz";
        int key = 75;
        assertEquals("efg", encoderDecoder.encode(input, key));
    }

    @Test
    public void encoderTest_04() {
        String input = "xyz";
        int key = 100;
        assertEquals("~!\"", encoderDecoder.encode(input, key));
    }

    @Test
    public void encoderTest_05() {
        String input = "xyz";
        int key = 125;
        assertEquals("9:;", encoderDecoder.encode(input, key));
    }



    @Test
    public void decoderTest_01() {
        String input = "345";
        int key = 25;
        assertEquals("xyz", encoderDecoder.decode(input,key));
    }

    @Test
    public void decoderTest_02() {
        String input = "LMN";
        int key = 50;
        assertEquals("xyz", encoderDecoder.decode(input,key));
    }

    @Test
    public void decoderTest_03() {
        String input = "efg";
        int key = 75;
        assertEquals("xyz", encoderDecoder.decode(input,key));
    }

    @Test
    public void decoderTest_04() {
        String input = "~!\"";
        int key = 100;
        assertEquals("xyz", encoderDecoder.decode(input,key));
    }

    @Test
    public void decoderTest_05() {
        String input = "9:;";
        int key = 125;
        assertEquals("xyz", encoderDecoder.decode(input,key));
    }

}
