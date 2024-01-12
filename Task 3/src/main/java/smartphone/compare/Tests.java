package smartphone.compare;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void testLoadPhonesFromFile() {
        List<SmartPhone> phones = Main.loadPhonesFromFile("phones.data");

        Assertions.assertNotNull(phones);
        Assertions.assertFalse(phones.isEmpty());

        // Assuming there are at least two phones in the file
        SmartPhone phone1 = phones.get(0);
        SmartPhone phone2 = phones.get(1);

        Assertions.assertNotNull(phone1);
        Assertions.assertNotNull(phone2);

        Assertions.assertNotEquals(phone1, phone2);
    }


}

