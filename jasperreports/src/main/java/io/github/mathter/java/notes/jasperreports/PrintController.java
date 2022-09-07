package io.github.mathter.java.notes.jasperreports;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("/jasperreports")
public class PrintController {
    @RequestMapping(value = "print", method = RequestMethod.GET, produces = "application/pdf")
    private byte[] print() throws JRException {
        return this.content();
    }

    private byte[] content() throws JRException {
        return JasperExportManager.exportReportToPdf(this.jasperPrint());
    }

    private JasperPrint jasperPrint() throws JRException {
        final JRDataSource jrDataSource = new JREmptyDataSource();
        return JasperFillManager.fillReport(this.jasperReport(), null, jrDataSource);
    }

    private JasperReport jasperReport() throws JRException {
        return JasperCompileManager.compileReport(this.jasperDesign());
    }

    private JasperDesign jasperDesign() throws JRException {
        return JRXmlLoader.load(this.getJrxml());
    }

    private InputStream getJrxml() {
        return PrintController.class.getResourceAsStream("/report.jrxml");
    }
}
