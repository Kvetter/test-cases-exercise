import org.junit.Assert;

public class MyArrayListWithBugsTest {

    private MyArrayListWithBugs list;

    @org.junit.Before
    public void setUp() throws Exception {
        list = new MyArrayListWithBugs();
    }

    @org.junit.Test
    public void addToEmptyList() throws Exception {
        String item = "Item to Add";
        list.add(item);
        Assert.assertEquals(1, list.size());
    }

    @org.junit.Test
    public void getObjectFromList() throws Exception {
        addToEmptyList();
        Assert.assertEquals("Item to Add", (String) list.get(0));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void getObjectFromEmptyList() throws Exception {
        list.get(0);
    }

    @org.junit.Test
    public void addObjectAtGivenIndex() throws Exception {
        addToEmptyList();
        list.add(0, "Test item");
        Assert.assertEquals(2, list.size());
    }
    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void addObjectAtLastIndexPlusOne() throws Exception {
        addToEmptyList();
        list.add(2, "Test item");
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void addObjectAtGivenIndexToEmptyList() throws Exception {
        list.add(0, "Test item");
    }

    @org.junit.Test
    public void removeIndexFromList() throws Exception {
        addToEmptyList();
        String obj = (String) list.remove(0);
        Assert.assertEquals(obj, "Item to Add");
        Assert.assertEquals(0, list.size());
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void removeIndexFromEmptyList() throws Exception {
        String obj = (String) list.remove(0);
        Assert.assertEquals(obj, "Item to Add");
        Assert.assertEquals(0, list.size());
    }

}
