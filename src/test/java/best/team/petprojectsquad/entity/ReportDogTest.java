package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReportDogTest {
    @Test
    public void testGettersAndSetters() {
        ReportDog ReportDog = new ReportDog();
        ReportDog.setId(1);
        ReportDog.setReport("Golden Retriever");
        ReportDog.setReportAccepted(true);
        ReportDog.setDateReport(LocalDate.MAX);
        ReportDog.setUserDog(null);

        assertEquals(ReportDog.getReport(), "Golden Retriever");
        assertEquals(ReportDog.getDateReport(), LocalDate.MAX);
        assertNull(ReportDog.getUserDog());
        assertTrue(ReportDog.isReportAccepted());
        assertEquals(ReportDog.getId(), 1);
    }

    @Test
    public void testConstructor() {
        ReportDog ReportDog = new ReportDog("report", LocalDate.MAX, "234");

        assertEquals(ReportDog.getPhotoId(), "234");
        assertEquals(ReportDog.getReport(), "report");
        assertEquals(ReportDog.getDateReport(), LocalDate.MAX);
    }

}