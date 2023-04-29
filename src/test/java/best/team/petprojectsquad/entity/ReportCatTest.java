package best.team.petprojectsquad.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReportCatTest {

    @Test
    public void testGettersAndSetters() {
        ReportCat reportCat = new ReportCat();
        reportCat.setId(1);
        reportCat.setReport("Golden Retriever");
        reportCat.setReportAccepted(true);
        reportCat.setDateReport(LocalDate.MAX);
        reportCat.setUserCat(null);

        assertEquals(reportCat.getReport(), "Golden Retriever");
        assertEquals(reportCat.getDateReport(), LocalDate.MAX);
        assertNull(reportCat.getUserCat());
        assertTrue(reportCat.isReportAccepted());
        assertEquals(reportCat.getId(), 1);
    }

    @Test
    public void testConstructor() {
        ReportCat reportCat = new ReportCat("report", LocalDate.MAX, "234");

        assertEquals(reportCat.getPhotoId(), "234");
        assertEquals(reportCat.getReport(), "report");
        assertEquals(reportCat.getDateReport(), LocalDate.MAX);
    }

}