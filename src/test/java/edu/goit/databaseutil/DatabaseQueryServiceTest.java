package edu.goit.databaseutil;

import org.junit.jupiter.api.*;

class DatabaseQueryServiceTest {

    private static DatabaseQueryService databaseQueryService;
    @BeforeAll
    static void setUp() {
        DatabaseInitService.main(new String[0]);
        DatabasePopulateService.main(new String[0]);
        databaseQueryService = new DatabaseQueryService();
    }

    @Test
    void findMaxSalaryWorker() {
        String expected = "[Worker(ID=24, name=Ella Torres, birthday=1991-05-19, level=Senior, salary=14500)]";
        String actual = databaseQueryService.findMaxSalaryWorker().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findLongestProject() {
        String expected = "[ProjectWithDuration(ID=16, startDate=2022-02-01, finishDate=2023-04-01, durMonths=10)]";
        String actual = databaseQueryService.findLongestProject().toString();
        Assertions.assertEquals(expected, actual);
            }

    @Test
    void findMaxProjectClient() {
        String expected = "[MaxProjectClient(ID=7, name=David Martin, projectCount=4), MaxProjectClient(ID=3, name=William Davis, projectCount=4)]";
        String actual = databaseQueryService.findMaxProjectClient().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findYoungestOldestWorker() {
        String expected = "[YOWorker(type=YOUNGEST, name=Grace King, birthday=1983-10-08), YOWorker(type=OLDEST, name=Matthew Young, birthday=1999-03-22), YOWorker(type=OLDEST, name=Ryan Wright, birthday=1999-03-22), YOWorker(type=OLDEST, name=David Perez, birthday=1999-03-22)]";
        String actual = databaseQueryService.findYoungestOldestWorker().toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printProjectPrice() {
        Assertions.assertNotNull(databaseQueryService.printProjectPrice());
    }
}