package xml.SAX;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXTest {
	public static void main(String[] args) {
		//����һ������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//����������
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XMLHandler hanndler = new XMLHandler();
		try {
			parser.parse(new File("src/xml/SAX/userList.xml"),hanndler);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
/**
 * �̳�DefaultHandler�ಢʵ�����еķ������ǽ����Ĺؼ�
 */
class XMLHandler extends DefaultHandler{
	Attributes attributes;//��¼��ǰ��ǩ��������Ϣ
	String qName;//��¼��ǰ�ı�ǩ��
	/**
	 * ��ʼ�������ڵ�
	 */
	@Override
	public void startDocument() throws SAXException {
		
	}
	@Override
	/**
	 * �������ڵ����
	 */
	public void endDocument() throws SAXException {
		
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("user")){
			if(attributes.getLength()!=0){
				System.out.print("user[id="+attributes.getValue(0));
			}
		}else if(qName.equals("username")){
			System.out.print(",username=");
		}else if(qName.equals("password")){
			System.out.print(",password=");
		}
		
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("password")){
			System.out.println("]");
		}
	
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch,start,length).trim());
	}
}