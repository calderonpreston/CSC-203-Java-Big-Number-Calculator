import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This file contains JUnit tests for some sample arithmetic
 * expressions. This file tests your program "as a whole", by
 * checking its printed output.
 *
 * YOU SHOULD NOT WRITE YOUR OWN TESTS THIS WAY, OR IN THIS FILE.
 * You should test the individual UNITS in your program, i.e., call
 * your add, multiply, and exponentiate methods and test their return
 * values.
 */
public class SampleTest {
    /**
     * The actual standard output stream.
     */
    private PrintStream old;

    /**
     * The streams we're using to capture printed output.
     */
    private ByteArrayOutputStream baos;

    /**
     * Gets called before each test method. Need to do this so that we can
     * capture the printed output from each method.
     */
    @BeforeEach
    public void setUp() {
        this.old = System.out; // Save a reference to the original stdout stream.
        this.baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @Test
    public void testSampleFile() {
        BigNumArithmetic.main(new String[] { "SampleInput.txt" });
        String output = this.baos.toString().trim().replaceAll("\r\n", "\n");
        assertEquals("1 + 2 = 3\n" +
                "3 * 5 = 15\n" +
                "0 * 1 = 0\n" +
                "1 + 2 = 3\n" +
                "3 * 5 = 15\n" +
                "0 * 1 = 0", output);
    }

    @Test

    public void testSampleFile1(){
        BigNumArithmetic.main(new String[] { "SampleInput1.txt" });
        String output = this.baos.toString().trim().replaceAll("\r\n", "\n");
        assertEquals("Input format does not follow the structure: 'positive integer' '(+ or *)' 'positive integer'\n" +
                "3 * 5 = 15\n" +
                "0 * 1 = 0\n" +
                "Invalid operation: " + "10 - 5\n" +
                "Invalid operation: " + "10 % 5\n" +
                "Invalid operation: " + "10 / 5\n" +
                "99 * 9 = 891\n" +
                "123 * 0 = 0\n" +
                "Invalid character detected.\n" +
                "Invalid character detected.\n" +
                " +  = \n" +
                "Invalid character detected.\n" +
                "1 +  = 1\n" +
                "Invalid character detected.\n" +
                "Invalid character detected.\n" +
                " +  =", output);
    }

    @Test
    public void testSampleFileNull(){
        BigNumArithmetic.main(new String[] { "" });
        String output = this.baos.toString().trim().replaceAll("\r\n", "\n");
        assertEquals("File not found:", output);
    }
    /**
     * Gets called after each test method. Need to do this so that we are
     * no longer capturing all printed output and printed stuff appears
     * like normal.
     */

    @Test
    public void testEquals(){
        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();
        LinkedList l1 = new LinkedList();


        lt.add(1);
        lt.add(2);
        lt.add(3);
        lt.add(0);

        l.add(1);
        l.add(0);
        l.add(3);
        l.add(0);
        assertFalse(l.equals(l1));
        assertFalse(l1.equals(l));
        assertFalse(l.equals(lt));
        assertTrue(l.equals(l));
    }

    @Test
    public void testEquals_1(){
        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();

        lt.add(1);
        lt.add(2);
        lt.add(3);
        lt.add(0);

        l.add(1);
        l.add(0);
        l.add(3);

        assertFalse(l.equals(lt));
    }

    @Test
    public void testAdd(){
        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();

        lt.add(1);
        lt.add(2);
        lt.add(3);
        lt.add(0);

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(0);

        assertTrue(l.equals(lt));
    }

    @Test
    public void testAddReverseOrder(){
        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();

        lt.add(0);
        lt.add(3);
        lt.add(2);
        lt.add(1);

        l.addReverseOrder(1);
        l.addReverseOrder(2);
        l.addReverseOrder(3);
        l.addReverseOrder(0);

        assertTrue(l.equals(lt));
    }

    @Test
    public void testReverse(){
        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();

        lt.add(1);
        lt.add(2);
        lt.add(3);
        lt.add(0);

        l.addReverseOrder(1);
        l.addReverseOrder(2);
        l.addReverseOrder(3);
        l.addReverseOrder(0);

        l.reverse();


        assertTrue(l.equals(lt));
    }

    @Test
    public void testAddition(){

        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();

        lt.addReverseOrder(1);
        lt.addReverseOrder(2);

        l.addReverseOrder(1);
        l.addReverseOrder(2);

        assertEquals("42", LinkedList.addition(l, lt).toString());
    }

    @Test
    public void testMultiplication(){

        LinkedList l = new LinkedList();
        LinkedList lt = new LinkedList();

        lt.addReverseOrder(1);
        lt.addReverseOrder(2);

        l.addReverseOrder(1);
        l.addReverseOrder(2);

        assertEquals("441", LinkedList.multiplication(l, lt).toString());
    }

    @Test
    public void testGetValue(){
        Node n = new Node(2, null);

        assertEquals(2, n.getValue());
    }
    @Test
    public void testGetNext(){
        Node n = new Node(2, null);

        assertEquals(null, n.getNext());
    }
    @Test
    public void testSetNext(){
        Node nn = new Node(1,null);
        Node n = new Node(2, nn);

        n.setNext(null);
        assertEquals(null, n.getNext());
    }
    @Test
    public void testSetValue(){
        Node n = new Node(2, null);
        n.setValue(5);
        assertEquals(5, n.getValue());
    }
    @AfterEach
    public void tearDown() {
        System.out.flush();
        System.setOut(this.old);
    }
}
