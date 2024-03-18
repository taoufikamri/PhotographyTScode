package application;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.aspose.words.Document;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordEditor {

    public static void main(String[] args) {
//        editWordDocument("C:\\Users\\taouf\\Documents\\Contrat_photo.docx", "C:\\Users\\taouf\\Documents\\Contrat_photo_Edit.docx", "HEJJAL ", "AHAHAH");
    }

    public static void editWordDocument(String inputFilePath, String outputFilePath, String[] search,String[] replace, String[] searchMm, String[] replaceMm) {
        try (XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath))) {
        	//String searchNomMr, String replaceNomMr, String searchPrenomMr, String replacePrenomMr,
//            //nom
//        	for (XWPFParagraph paragraph : document.getParagraphs()) {
//                for (XWPFRun run : paragraph.getRuns()) {
//                    String text = run.getText(0);
//
//                    if (text != null && text.contains(searchNomMr)) {
//                        text = text.replace(searchNomMr, replaceNomMr);
//                        run.setText(text, 0);
//                    }
//                }
//            }

            for (int i = 0; i<replace.length; i++){
            	for (XWPFParagraph paragraph : document.getParagraphs()) {
                    for (XWPFRun run : paragraph.getRuns()) {
                        String text = run.getText(0);

                        if (text != null && text.contains(search[i])) {
                            text = text.replace(search[i], replace[i]);
                            run.setText(text, 0);
                        }
                    }
                }
            }

            for (int i = 0; i<replaceMm.length; i++){
            	for (XWPFParagraph paragraph : document.getParagraphs()) {
                    for (XWPFRun run : paragraph.getRuns()) {
                        String text = run.getText(0);

                        if (text != null && text.contains(searchMm[i])) {
                            text = text.replace(searchMm[i], replaceMm[i]);
                            run.setText(text, 0);
                        }
                    }
                }
            }


            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                document.write(fos);
                System.out.println("Word document edited and saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document document;
		try {
			document = new Document(outputFilePath);
			document.save(outputFilePath+".pdf");
			System.out.println("Word document converted to pdf successfully.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
