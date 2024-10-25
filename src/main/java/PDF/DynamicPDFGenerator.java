package PDF;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

public class DynamicPDFGenerator {

  public static void main(String[] args) {
    String outputPdf = "reporte_dinamico.pdf";  // Nombre del PDF generado // Cambia el nombre del archivo según sea necesario

    try {
      PdfWriter writer = new PdfWriter(outputPdf);
      PdfDocument pdf = new PdfDocument(writer);
      Document document = new Document(pdf, PageSize.A4);
      document.setMargins(20, 20, 20, 20);

      // Agregar cabecera personalizada
      document.add(createHeader());

      // Insertar un espacio entre el encabezado y la tabla
      document.add(new Paragraph("\n"));  // Añadir un párrafo vacío para el espacio

      // Crear la tabla dinámica con 7 columnas
      Table table = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

      // Añadir encabezados de la tabla
      String[] headers = {"Descripcion", "Entidad Tercero", "Numero Identificacion", "Cargo/Abono", "Saldo Contable"};
      for (String header : headers) {
        table.addHeaderCell(new Cell().add(new Paragraph(header).setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));
      }

      // Llenar la tabla con datos de ejemplo (puedes reemplazar estos datos con los reales)
      String[][] data = {
              {"GESTIÓN DE CONTRA CARGOS", "Cetco S.A", "20100123763", "1.00", "9,029.45"},
              {"Credito por abono", "Cetco S.A", "20100123763", "2.00", "9,031.45"},
              {"DEPÓSITO BANCARIO", "Cetco S.A", "20100123763", "3.00", "9,034.45"},
              {"AJUSTE DE CRÉDITO", "Cetco S.A", "20100123763", "4.01", "9,038.46"},
              {"PAGO DE DEUDA", "Cetco S.A", "20100123763", "-5.00", "9,033.46"},
              {"AJUSTE POR REVERSO DE LOTES", "Cetco S.A", "20100123763", "-6.00", "9,027.46"},
              {"DÉBITO POR FACTURAS", "Cetco S.A", "20100123763", "-7.00", "9,020.46"},
              {"EXTORNO DE RECARGA", "Cetco S.A", "20100123763", "-8.00", "9,012.46"},
              {"ZP XXXXXXXXX INDXX", "Cetco S.A", "20100123763", "-9.00", "9,003.46"},
              {"ZP XXXXXXXXX INDXX", "GRACIELA BURGA", "0016580221", "-4.05", "8,999.41"},
              {"ZP XXXXXXXXX INDXX", "ROSA TAN", "0016570205", "-6.05", "8,993.36"},
              {"ZP XXXXXXXXX INDXX", "SILVIA VELASQUEZ", "0016689138", "-6.05", "8,987.31"},
              {"ZP XXXXXXXXX INDXX", "MARYURI URBINA", "0047092914", "-6.05", "8,981.26"},
              {"ZP XXXXXXXXX INDXX", "MARIANELA GOMEZ", "0016685976", "-3.05", "8,978.21"},
              {"ZP XXXXXXXXX INDXX", "LADY VELASCO", "0007641804", "-6.05", "8,972.16"},
              {"ZP XXXXXXXXX INDXX", "EDITH FRIAS", "0016513260", "-6.05", "8,966.11"},
              {"ZP XXXXXXXXX INDXX", "MARIA DE LA PIEDRA", "0008590785", "-4.05", "8,962.06"},
              {"ZP XXXXXXXXX INDXX", "YESENIA HILARIO", "0045574386", "-3.05", "8,959.01"},
              {"ZP XXXXXXXXX INDXX", "KARIN RIOS", "0045958167", "-4.05", "8,954.96"},
              {"ZP XXXXXXXXX INDXX", "HILLARY MATTOS", "00476905541", "-3.05", "8,951.91"},
              {"ZP XXXXXXXXX INDXX", "NELLY VENTURA", "0017617572", "-4.05", "8,947.86"},
              {"ZP XXXXXXXXX INDXX", "CARMEN ECAN", "0017589001", "-6.05", "8,941.81"},
              {"ZP XXXXXXXXX INDXX", "BETTY TUCTO", "0071624280", "-4.05", "8,937.76"},
              {"ZP XXXXXXXXX INDXX", "JACINTA QUIROZ", "0016512194", "-6.05", "8,931.71"},
              {"ZP XXXXXXXXX INDXX", "JUDITH GUILLERMO", "0072088339", "-6.05", "8,925.66"},
              {"ZP XXXXXXXXX INDXX", "MAGALI CONDOR", "0070302190", "-6.05", "8,919.61"}
      };

      // Agregar los datos a la tabla
      for (String[] row : data) {
        for (String cellData : row) {
          table.addCell(cellData);
        }
      }

      document.add(table);
      document.close();

      System.out.println("PDF generado exitosamente: " + outputPdf);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Crear la cabecera personalizada como una tabla
  private static Table createHeader() {
    Table header = new Table(UnitValue.createPercentArray(new float[]{1, 1, 1})).useAllAvailableWidth();

    // Primera fila: Datos de la entidad bancaria y extracto
    header.addCell(new Cell(1, 2).add(new Paragraph("Datos entidad Bancaria").setBold()));
    header.addCell(new Cell().add(new Paragraph("EXTRACTO").setBold()));

    header.addCell(new Cell().add(new Paragraph("SERVITEBCA PERU")));
    header.addCell(new Cell().add(new Paragraph("")));
    header.addCell(new Cell().add(new Paragraph("RUC: 20517372294")));
    header.addCell(new Cell().add(new Paragraph("Desde: 01/09/2024")));
    header.addCell(new Cell().add(new Paragraph("Hasta: 30/09/2024")));

    // Segunda fila: Datos del cliente y número de cuenta
    header.addCell(new Cell(1, 2).add(new Paragraph("Datos Cliente").setBold()));
    header.addCell(new Cell().add(new Paragraph("TIPO DE CUENTA: Cuenta de dinero electronico")));
    header.addCell(new Cell().add(new Paragraph("CETCO S.A.")));
    header.addCell(new Cell().add(new Paragraph("RUC: 20100123763")));
    header.addCell(new Cell().add(new Paragraph("Número Cuenta: 200-3005698985")));

    // Tercera fila: Saldos inicial y final
    header.addCell(new Cell(1, 2).add(new Paragraph("SALDO INICIAL: 9,028.45")));
    header.addCell(new Cell().add(new Paragraph("SALDO FINAL: 15,494.94")));

    header.addCell(new Cell(1, 2).add(new Paragraph("Moneda: Soles")));
    return header;
  }
}
