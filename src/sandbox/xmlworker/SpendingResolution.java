package sandbox.xmlworker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class SpendingResolution {
	public static final String DEST = "results/xmlworker/spendingResolution.pdf";
	public static final String DATA = "resources/xml/index.html";
	public static final String FONT = "resources/fonts/malgun.ttf";
	public static final String STYLE = "resources/xml/style.css";

	public static void main(String[] args) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4, 50, 50, 50, 50); // ���� �� ���� ����

		// PdfWriter ����
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST)); // �ٷ� �ٿ�ε�.
		// PdfWriter writer = PdfWriter.getInstance(document, new
		// FileOutputStream(DATA)); // �ٷ� �ٿ�ε�.
		// PdfWriter writer = PdfWriter.getInstance(document,
		// response.getOutputStream());
		writer.setInitialLeading(12.5f);

		// ���� �ٿ�ε� ����
		/*
		 * response.setContentType("application/pdf"); String fileName =
		 * URLEncoder.encode("�ѱ����ϸ�", "UTF-8"); // ���ϸ��� �ѱ��� �� ���ڵ� // �ʿ�
		 * response.setHeader("Content-Transper-Encoding", "binary");
		 * response.setHeader("Content-Disposition", "inline; filename=" +
		 * fileName + ".pdf");
		 */

		// Document ����
		document.open();
		XMLWorkerHelper helper = XMLWorkerHelper.getInstance();

		// CSS
		CSSResolver cssResolver = new StyleAttrCSSResolver();
		// CssFile cssFile = helper.getCSS(new
		// FileInputStream("C:/tmp/pdf.css"));
		CssFile cssFile = helper.getCSS(new FileInputStream(STYLE));
		cssResolver.addCss(cssFile);

		// HTML, ��Ʈ ����
		XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
		fontProvider.register(FONT, "MalgunGothic"); // MalgunGothic��
														// alias,
		CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);

		HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
		htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

		// Pipelines
		PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
		HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
		CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

		XMLWorker worker = new XMLWorker(css, true);
		XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));

		// ��Ʈ �������� ��Ī���� ��� "MalgunGothic"�� html �ȿ� ��Ʈ�� �����Ѵ�.
		String htmlStr = "<html><head><body style='font-family: MalgunGothic;'>" + "<p>PDF �ȿ� �� �����Դϴ�111.</p>"
				+ "<h3>�ѱ�, English, ���.</h3>" + "</body></head></html>";

		FileInputStream f = new FileInputStream(DATA);

		// System.out.println(getFileContent(f));

		String contents = getFileContent(f);
		// String contents1=getfileCotent1();

		System.out.println(contents);

		StringReader strReader = new StringReader(contents);
		xmlParser.parse(strReader);
		// xmlParser.parse(f);

		document.close();
		writer.close();
	}

	public static String getFileContent(FileInputStream fis) throws IOException {
		StringBuilder sb = new StringBuilder();
		Reader r = new InputStreamReader(fis, "UTF-8"); // or whatever encoding
		char[] buf = new char[1024];
		int amt = r.read(buf);
		while (amt > 0) {
			sb.append(buf, 0, amt);
			amt = r.read(buf);
		}
		return sb.toString();
	}

	public static String getfileCotent1() {
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(DATA));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();

		return content;
	}
 
}
