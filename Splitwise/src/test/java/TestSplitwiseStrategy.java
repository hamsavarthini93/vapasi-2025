import org.tw.splitwise.PropertiesNotFoundException;
import org.tw.splitwise.SplitWiseStrategy;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSplitwiseStrategy {

    @Test
    public void testRunSplitter() throws PropertiesNotFoundException {
        Properties props = new Properties();
        props.setProperty("expense.1.paidBy", "A");
        props.setProperty("expense.1.amount", "100");
        props.setProperty("expense.1.sharedMembers", "A,B,C,D");
        props.setProperty("expense.2.paidBy", "B");
        props.setProperty("expense.2.amount", "500");
        props.setProperty("expense.2.sharedMembers", "C,D");
        props.setProperty("expense.4.paidBy", "D");
        props.setProperty("expense.3.amount", "300");
        props.setProperty("expense.3.sharedMembers", "A,B");
        SplitWiseStrategy.runSplitter(props);
    }

    @Test
    public void testNoPropertiesInFile() {
        Properties props = new Properties();
        assertThrows(PropertiesNotFoundException.class, () -> SplitWiseStrategy.runSplitter(props));
    }

    @Test
    public void testNoPaidByPropertyinFile() throws PropertiesNotFoundException {
        Properties props = new Properties();
        props.setProperty("expense.1.amount", "100");
        props.setProperty("expense.1.sharedMembers", "A,B,C,D");
        props.setProperty("expense.2.amount", "500");
        props.setProperty("expense.2.sharedMembers", "C,D");
        props.setProperty("expense.3.amount", "300");
        props.setProperty("expense.3.sharedMembers", "A,B");
        assertEquals("Required properties are not found in the file", SplitWiseStrategy.runSplitter(props));
    }

    @Test
    public void testNoAmountPropertyinFile() throws PropertiesNotFoundException {
        Properties props = new Properties();
        props.setProperty("expense.1.paidBy", "A");
        props.setProperty("expense.1.sharedMembers", "A,B,C,D");
        props.setProperty("expense.2.paidBy", "B");
        props.setProperty("expense.2.sharedMembers", "C,D");
        props.setProperty("expense.4.paidBy", "D");
        props.setProperty("expense.3.sharedMembers", "A,B");
        assertEquals("Required properties are not found in the file", SplitWiseStrategy.runSplitter(props));
    }

    @Test
    public void testNoSharedMembersPropertyinFile() throws PropertiesNotFoundException {
        Properties props = new Properties();
        props.setProperty("expense.1.paidBy", "A");
        props.setProperty("expense.1.amount", "100");
        props.setProperty("expense.2.paidBy", "B");
        props.setProperty("expense.2.amount", "500");
        props.setProperty("expense.4.paidBy", "D");
        props.setProperty("expense.3.amount", "300");
        assertEquals("Required properties are not found in the file", SplitWiseStrategy.runSplitter(props));
    }

    @Test
    public void testNoPropertiesFileFound() {
        InputStream input = null;
        assertThrows(IOException.class, () -> SplitWiseStrategy.checkFileExists(input));
    }


}
