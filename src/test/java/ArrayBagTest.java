import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBagTest {

    @Test
    void addTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        Building b2=new Building("Jhon","111 Main St");
        ar.add(b1);
        assertTrue(ar.contains(b1));
        assertFalse(ar.contains(b2));
    }
    @Test
    void removeTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        Building b2=new Building("Jhon","111 Main St");
        ar.add(b1);
        ar.add(b2);
        ar.remove();
        assertAll(
                ()-> assertFalse(ar.contains(b2)),
                ()-> assertTrue(ar.contains(b1))
        );

        ar.add(b2);
        ar.remove(0);
        assertAll(
                ()-> assertFalse(ar.contains(b1)),
                ()-> assertTrue(ar.contains(b2))
        );

        ar.add(b1);
        ar.remove(b2);
        assertAll(
                ()->assertFalse(ar.contains(b2)),
                ()->assertTrue(ar.contains(b1))
        );
    }
    @Test
    void getTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        Building b2=new Building("Jhon","111 Main St");
        ar.add(b1);
        ar.add(b2);
        assertTrue(b1.equals(ar.get(0)));
        assertTrue(b2.equals(ar.get(1)));
    }
    @Test
    void sizeTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        Building b2=new Building("Jhon","111 Main St");
        ar.add(b1);
        assertEquals(1,ar.size());
        ar.add(b2);
        assertEquals(2,ar.size());
        ar.remove(b1);
        assertEquals(1,ar.size());
    }

    @Test
    void isEmptyTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        assertTrue(ar.isEmpty());
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        assertFalse(ar.isEmpty());
    }
    @Test
    void containsTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        assertFalse(ar.contains(b1));
        ar.add(b1);
        assertTrue(ar.contains(b1));
    }

    @Test
    void clearTest(){
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        ar.add(b1);
        assertFalse(ar.isEmpty());
        ar.clear();
        assertTrue(ar.isEmpty());
    }
    @Test
    void createTest(){
        ArrayBag<Building> ar=new ArrayBag<>();
        assertTrue(ar.isEmpty());
        assertEquals(0,ar.size());
    }
    @Test
    void getFrequecyOf(){
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        assertEquals(1,ar.getFrequencyOf(b1));
        ar.add(b1);
        assertEquals(2,ar.getFrequencyOf(b1));
    }
}