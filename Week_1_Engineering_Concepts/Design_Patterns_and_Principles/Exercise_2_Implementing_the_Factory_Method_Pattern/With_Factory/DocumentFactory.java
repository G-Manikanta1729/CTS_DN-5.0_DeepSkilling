public class DocumentFactory {

    public static DocumentProcessor getProcessor(String type) {

        if (type.equalsIgnoreCase("PDF")) {
            return new PDFProcessor();
        }

        else if (type.equalsIgnoreCase("WORD")) {
            return new WordProcessor();
        }

        else if (type.equalsIgnoreCase("EXCEL")) {
            return new ExcelProcessor();
        }

        throw new IllegalArgumentException("Invalid Document Type");

    }

}