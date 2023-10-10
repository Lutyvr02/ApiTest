import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestJson {

    @ParameterizedTest
    @CsvSource(
            {
                    "{\"Id\":1},{\"Id\":1}",
                    "{\"Content\":\"Luciano3\"},{\"Content\":\"Luciano3\"}",
                    "{\"ItemType\":1},{\"ItemType\":1}",
                    "{\"Checked\":false},{\"Checked\":false}",
                    "{\"ProjectId\":null},{\"ProjectId\":null}",
                    "{\"ParentId\":null},{\"ParentId\":null}",
                    "{\"Path\":\"\"},{\"Path\":\"\"}",
                    "{\"Collapsed\":false},{\"Collapsed\":false}",
                    "{\"DateString\":null},{\"DateString\":null}",
                    "{\"DateStringPriority\":0},{\"DateStringPriority\":0}",
                    "{\"DueDate\":\"\"},{\"DueDate\":\"\"}",
                    "{\"Recurrence\":null},{\"Recurrence\":null}",
                    "{\"ItemOrder\":null},{\"ItemOrder\":null}",
                    "{\"Priority\":4},{\"Priority\":4}",
                    "{\"LastSyncedDateTime\":\"/Date(1696954338479)/\"},{\"LastSyncedDateTime\":\"/Date(1696954338479)/\"}",
                    "{\"DueDateTime\":null},{\"DueDateTime\":null}",
                    "{\"CreatedDate\":\"/Date(1696954338450)/\"},{\"CreatedDate\":\"/Date(1696954338450)/\"}",
                    "{\"LastCheckedDate\":null},{\"LastCheckedDate\":null}",
                    "{\"LastUpdatedDate\":\"/Date(1696954338450)/\"},{\"LastUpdatedDate\":\"/Date(1696954338450)/\"}",
                    "{\"Deleted\":false},{\"Deleted\":false}",
                    "{\"Notes\":\"\"},{\"Notes\":\"\"}",
                    "{\"InHistory\":false},{\"InHistory\":false}",
                    "{\"SyncClientCreationId\":null},{\"SyncClientCreationId\":null}",
                    "{\"DueTimeSpecified\":true},{\"DueTimeSpecified\":true}",
                    "{\"OwnerId\":730872},{\"OwnerId\":730872}"
            }
    )
    public void testCompareJsons(String expectedJson, String actualJson) {
        Main main = new Main(); // Supongo que Main es la clase con el método compareJsons
        boolean actualResult = main.compareJsons(expectedJson, actualJson);
        Assertions.assertTrue(actualResult, "Los JSON no coinciden: " + expectedJson + " vs. " + actualJson);
    }
}