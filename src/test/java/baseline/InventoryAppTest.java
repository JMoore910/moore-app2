package baseline;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class InventoryAppTest {
    //  Create static final objects for Classes to implement
    static final LoadInventory loader = new LoadInventory();
    static final SaveInventory save = new SaveInventory();
    static Inventory testInventory = new Inventory();

    static String removeSerial = "B-123-XXX-D11";


    @Test
    void test_add() {
        //  Tests add and search methods
        //  add items to the inventory
        testInventory.addItem(new InventoryItem("Beans", "A-XX1-B12-123",       10000.10, 1));
        testInventory.addItem(new InventoryItem("Shoes", "C-123-456-789",         900.10, 2));
        testInventory.addItem(new InventoryItem("Carts", "B-123-XXX-D11",       10090.10, 1));
        testInventory.addItem(new InventoryItem("Tags" , "A-AA2-B12-123",     1111111.10, 3));
        testInventory.addItem(new InventoryItem("Tares", "Z-XX1-B12-123",       10000.10, 1));
        testInventory.addItem(new InventoryItem("Tests", "X-XX1-B12-123",       10000.10, 1));
        //      check that the item at its serial in the map is equal to the expected item input
        assertTrue(testInventory.searchList(removeSerial,"Carts"));
    }

    @Test
    void test_remove() {
        //  Tests remove and search methods
        testInventory.removeItem(new InventoryItem("Carts", "B-123-XXX-D11",       10090.10, 1));
        assertFalse(testInventory.searchList(removeSerial,"Carts"));
    }

    @Test
    void test_sorts() {
        //  Item at serial "A-AA2-B12-123" should be at head of list of serials
        testInventory.sortBySerial();
        assertEquals("A-AA2-B12-123",testInventory.getSerials().get(0));
        testInventory.sortByName();
        assertEquals("A-XX1-B12-123",testInventory.getSerials().get(0));
        testInventory.sortByValue();
        assertEquals("C-123-456-789",testInventory.getSerials().get(0));
    }


    @Test
    void test_save_load() throws IOException {
        //  First save to each format to test load methods later
        save.saveFormat("data//test.txt",testInventory);
        save.saveFormat("data//test.json",testInventory);
        save.saveFormat("data//test.html",testInventory);


        Inventory tsv = loader.loadFormat("data//test.txt");
        Inventory json = loader.loadFormat("data//test.json");
        Inventory html = loader.loadFormat("data//test.html");

        //  Start with TSV and this will test all TSV related load/save methods
        assertEquals(testInventory.getMap().get("A-XX1-B12-123").getName(),tsv.getMap().get("A-XX1-B12-123").getName());
        assertEquals(testInventory.getMap().get("A-XX1-B12-123").getName(),json.getMap().get("A-XX1-B12-123").getName());
        assertEquals(testInventory.getMap().get("A-XX1-B12-123").getName(),html.getMap().get("A-XX1-B12-123").getName());
    }

    @Test
    void test_clear_list() {
        testInventory.clearList();
        //  After clearing the list assert the map is empty of all items
        assertTrue(testInventory.getMap().isEmpty());
    }


    @Test
    void test_check_name_valid() {
        //  Simply put in a valid name for an item
        assertTrue(testInventory.checkName("Cartons"));
    }

    @Test
    void test_check_name_invalid() {
        //  Simply put in an invalid name for an item
        assertFalse(testInventory.checkName("CartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCarts"
                +"CartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCarts"
                +"CartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCarts"
                +"CartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCartsCarts"
        ));
    }

    @Test
    void test_check_serial_valid() {
        //  Assert a valid serial true
        assertTrue(testInventory.checkSerial("F-1DX-111-FGC"));
    }


    @Test
    void test_check_serial_invalid() {
        //  Assert an invalid serial false
        assertFalse(testInventory.checkSerial("1-1DX-111-FGC"));
    }

    @Test
    void test_check_value_valid() {
        //  Assert a valid value true
        assertTrue(testInventory.checkValue("100000000000000000000000.01"));
    }

    @Test
    void test_check_value_invalid() {
        //  Assert a valid value true
        assertFalse(testInventory.checkValue("0.00"));
    }

}
