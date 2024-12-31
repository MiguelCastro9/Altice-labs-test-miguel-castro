package dev.miguel;

import dev.miguel.model.LabSeq;
import dev.miguel.service.LabSeqService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class LabSeqTest {

    @Inject
    LabSeqService labSeqService;

    @Test
    void testLabSeqExecutionTime() {
        Integer n = 100000;
        Long startTime = System.currentTimeMillis();
        LabSeq result = labSeqService.labSeq(n);
        Long endTime = System.currentTimeMillis();
        Long executionTime = endTime - startTime;
        System.out.println("Execution time for n=" + n + ": " + executionTime + "ms");
        assertTrue(executionTime < 10000);
    }

    @Test
    void testLabSeqResult() {
        Integer n = 20;
        LabSeq result = labSeqService.labSeq(n);
        assertEquals(21, result.getResult());
    }

    @Test
    void testLabSeqExceptionMessage() {
        Integer n = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> labSeqService.labSeq(n));
        assertEquals("The value of n must be between 0 and 100000.", exception.getMessage());
    }
}
