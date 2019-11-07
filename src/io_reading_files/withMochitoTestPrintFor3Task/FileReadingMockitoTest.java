import org.junit.Before;
import org.junit.Test;
import printing.Printer;

import static org.mockito.Mockito.*;

public class FileReadingMockitoTest {

  private FileReading fileReading;
  private Printer printer;

  @Before
  public void init() {
    printer = mock(Printer.class);
    fileReading = new FileReading(printer);
  }

@Test
  public void sortedNamesbyAgeOlder17Correct() {
    fileReading.sortedNamesbyAgeOlder17("task3.csv");
    verify(printer,times(2)).print(any());

  }
}