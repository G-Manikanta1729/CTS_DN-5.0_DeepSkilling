public class Main {

    public static void main(String[] args) {

        PDFProcessor pdf =
                new PDFProcessor();

        WordProcessor word =
                new WordProcessor();

        ExcelProcessor excel =
                new ExcelProcessor();

        pdf.process();
        word.process();
        excel.process();
    }
}