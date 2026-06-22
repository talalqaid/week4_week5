import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBagTest {

    @Test
    void addTest() {
        LinkedBag<Building> ar=new LinkedBag<>();
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        assertTrue(ar.contains(b1));
    }
    @Test
    void removeTest() {
        LinkedBag<Building> ar=new LinkedBag<>();
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
        ar.remove(b1);
        assertAll(
                ()->assertFalse(ar.contains(b1)),
                ()->assertTrue(ar.contains(b2))
        );


    }
    @Test
    void getTest() {
        LinkedBag<Building> ar=new LinkedBag<>();
        Building b1=new Building("Peter","111 Main St");
        Building b2=new Building("John","111 Main St");
        ar.add(b1);
        ar.add(b2);
        assertTrue(b1.equals(ar.get(1)));
    }
    @Test
    void sizeTest() {
        ArrayBag<Building> ar=new ArrayBag<>();
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        assertEquals(1,ar.size());
        ar.add(b1);
        assertEquals(2,ar.size());
        ar.remove(b1);
        assertEquals(1,ar.size());

    }

    @Test
    void isEmptyTest() {
        LinkedBag<Building> ar=new LinkedBag<>();
        assertTrue(ar.isEmpty());
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        assertFalse(ar.isEmpty());
    }
    @Test
    void containsTest() {
        LinkedBag<Building> ar=new LinkedBag<>();
        Building b1=new Building("Peter","111 Main St");
        assertFalse(ar.contains(b1));
        ar.add(b1);
        assertTrue(ar.contains(b1));
    }

    @Test
    void clearTest(){
        LinkedBag<Building> ar=new LinkedBag<>();
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        ar.add(b1);
        ar.clear();
        assertTrue(ar.isEmpty());
    }
    @Test
    void createTest(){
        LinkedBag<Building> ar=new LinkedBag<>();
        assertTrue(ar.isEmpty());
        assertEquals(0,ar.size());
    }
    @Test
    void getFrequecyOf(){
        LinkedBag<Building> ar=new LinkedBag<>();
        Building b1=new Building("Peter","111 Main St");
        ar.add(b1);
        assertEquals(1,ar.getFrequencyOf(b1));
        ar.add(b1);
        assertEquals(2,ar.getFrequencyOf(b1));
    }
}