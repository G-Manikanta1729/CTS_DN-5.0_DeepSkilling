public class Main {

    public static void main(String[] args) {

        DocumentProcessor pdf =
                DocumentFactory.getProcessor("PDF");

        pdf.process();

        DocumentProcessor word =
                DocumentFactory.getProcessor("WORD");

        word.process();

        DocumentProcessor excel =
                DocumentFactory.getProcessor("EXCEL");

        excel.process();

    }

}