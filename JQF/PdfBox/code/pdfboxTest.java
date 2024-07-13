import org.apache.pdfbox.pdmodel.PDDocument;

import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;
import scala.collection.IndexedSeq;
import java.io.File;
import java.io.IOException;

public class PDFBoxExample {
   @Fuzz
    public static void main(String[] args) {
        File file = new File("path/to/your/pdf/file.pdf");
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        try (PDDocument document = PDDocument.load(file)) {
            System.out.println("PDF loaded successfully.");
            // 处理 PDF 文档
        } catch (IOException e) {
            e.printStackTrace();
        }
    }