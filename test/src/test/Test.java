package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import sun.misc.Regexp;

public class Test {

	public static void main(String[] args) {

//		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//		for (int i = 0; i < urls.length; i++) {
//			System.out.println(urls[i].toExternalForm());
//		}
		
//		System.out.println(System.getProperty("java.ext.dirs"));
//		ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader()
//				.getParent();
//		System.out.println("the parent of extension classloader : "
//				+ extensionClassloader.getParent());

//		System.out.println(System.getProperty("java.class.path"));
//
//		System.out.println(System.class.getClassLoader());
//		
//		String s = "中文";
//
//		try {
//			byte[] b = s.getBytes("GB2312");
//			System.out.println(new String(b, "GBK"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Properties props = new Properties();
//		try {
//			props.load(new FileInputStream("src/test/barcodeitems.properties"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String info = props.getProperty("6927006133133");
//		try {
//			info = new String(info.getBytes("ISO-8859-1"), "gbk");// ISO-8859-1
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(info);
		
//		try {
//			InputStream in = new BufferedInputStream(new FileInputStream("src/test/barcodeitems.properties"));
//
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			int len = -1;
//			byte[]  b = new byte[1024];
//			while((len = in.read(b)) != -1) {
//				out.write(b, 0, len);
//			}
//			System.out.println(out.toString("GBK"));
//			out.close();
//			in.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String s = "\\u5317\\u4EAC\\u5E02";
//		System.out.println(decodeUnicode(s));
		
//		try {
//			String s = "\u5317\u4EAC\u5E02";
////			String s = "北京市";//unicode [-2, -1, 83, 23, 78, -84, 94, 2] //utf-8 [-27, -116, -105, -28, -70, -84, -27, -72, -126]
//			byte[] b = s.getBytes("utf-8");          // [-28, -72, -83, -27, -101, -67, -27, -116, -105, -28, -70, -84, -27, -72, -126]  
//			        // [-28, -72, -106, -25, -107, -116, -28, -72, -83, -27, -101, -67, -27, -116, -105, -28, -70, -84, -27, -72, -126]
////			System.out.println(s);                                            //&#x4E2D;&#x56FD;&#x5317;&#x4EAC;&#x5E02; //B1B1  5317  E5 8C 97  北
////			System.out.println(new String(b, "utf-8"));
////			URLDecoder.decode("xxxxxx", "UTF-8");
//			System.out.println(URLDecoder.decode("&#x5317;&#x4EAC;&#x5E02;", "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		String s = "哈子12ab c";
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < s.length(); i++) {
////			System.out.println(s.charAt(i));
//			sb.append(s.charAt(i) + "\n");
//		}
//		System.out.println(sb.toString());
		
//		Document doc = getDocument();
//		System.out.println(doc);
//		org.dom4j.Document doc = load();
//		Element root = doc.getRootElement();
//		QName qname = new QName("pwd");
//		Element pwdElement = root.element("AccountPwd");
//		String pwd = pwdElement.attributeValue("pwd");
//		Element userIdElement = root.element("AccountDisplayName");
//		String userId = userIdElement.attributeValue("name");
//		System.out.println(userId);
//		System.out.println(pwd);
//		List<Element> elements = root.elements();
//		for (Element element : elements) {
//			String text = element.getText();
//			System.out.println(text);
//		}
//		System.out.println(doc);
		
//		System.out.println(System.nanoTime());
//		String regex = "^\\d+\\.zip$";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher("z123456.zip");
//		System.out.println(m.matches());
//		0x3 << MODE_SHIFT;
//		System.out.println(0x3 << 30);
		
		
//		for (int i = 1; i <= 600; i++) {
//			System.out.println("<dimen name=\"w_" + i + "_600\">" + Math.round((540.0 / 600) * i) + "dp</dimen>");
//		}
		
//		System.out.println("" + System.currentTimeMillis() + Math.round(Math.random() * 100));
//		System.out.println(System.currentTimeMillis());
		
//		Pattern p = Pattern.compile("^M\\d+$");
//		Matcher m = p.matcher("M2");
//		System.out.println(m.matches());
		
		
//		String s = "fas,fasd,,,,ht,,,grse";
//		String[] arr = s.split(",");
////		System.out.println(arr.length);
//		
//		
//		String ss = JSONObject.toJSONString(arr);
//		System.out.println(ss);
		
//		AjaxResultObject a = new AjaxResultObject();
//		a.setStatus(AjaxResultObject.STATUS_FAIL);
//		a.setResult("中文");
//		String s = a.toJson();
//		System.out.println(s);
		
//		String path = "D:\\test\\aaa\\";
//		File dir = new File(path);
//		if (!dir.exists()|| !dir.isDirectory()) {
//			dir.mkdir();
//		}
		
//		int count = 100000;
//		Map<Integer, String> map = new HashMap<Integer, String>();
//		for (int i = 0; i <= count; i++) {
//			map.put(i, String.valueOf(i));
//		}
//		long a = System.currentTimeMillis();
//		System.out.println(map.get(count / 2));
//		long b = System.currentTimeMillis();
//		System.out.println("time: " + (b - a));
//		System.out.println(includeChnSymbol("！"));
//		float p = 1.0f;
//		for (int j = 0; j <= 50; j = j + 2) {
//			float f = 1.0f;
//			for (int i = 1; i < 50 - j + 2; i++) {
//				f = f * ((365.0f - j / 2 - i) / (365.0f - j / 2));
//			}
//			p = p * (1.0f - f);
//			System.out.println(1.0f - f);
//		}
//		System.out.println("p: " + p);
		System.out.println("\07");
		System.out.println("ssss");
	}
	
	private static boolean includeChnSymbol(String s) {
		String regex = "[，。？！~……：；、@#￥“”（）《》——]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	
	private boolean includeChnSymbol(char c) {
		String regex = "[，。？！~……：；、@#￥“”（）《》——]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(String.valueOf(c));
		return m.matches();
	}
	
	public static Document getDocument() {
		Document doc = null;

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("D:\\test\\mdm_auto_account.xml"));
			DocumentBuilderFactory domBuilderFacotry = DocumentBuilderFactory
					.newInstance();
			try {
				DocumentBuilder domBuilder = domBuilderFacotry
						.newDocumentBuilder();
				try {
					doc = domBuilder.parse(new InputSource(in));
				} catch (IOException ex1) {
					ex1.printStackTrace();
				} catch (SAXException ex1) {
					ex1.printStackTrace();
				}
			} catch (ParserConfigurationException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return doc;
	}
	
	public static org.dom4j.Document load() {
		org.dom4j.Document doc = null;
		SAXReader saxReader = new SAXReader();
		// 读取XML文档对象
		try {
			doc = saxReader.read(new FileInputStream("D:\\test\\mdm_auto_account.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	
	private static String decodeUnicode(String dataStr) {
		final StringBuffer buffer = new StringBuffer();
		if(dataStr.startsWith("\\u"))
		{
			int start = 0;
			int end = 0;
			while (start > -1) 
			{
				end = dataStr.indexOf("\\u", start + 2);
				String charStr = "";
				charStr = dataStr.substring(start + 2, start + 2 + 4);
				char letter = (char) Integer.parseInt(charStr, 16);
				buffer.append(new Character(letter).toString()
						+ (end == -1 ? dataStr.substring(start + 2 + 4)
								: dataStr.substring(start + 2 + 4, end)));
				start = end;
			}
		}
		else
		{
			return null;
		}
		return buffer.toString();
	}
}
