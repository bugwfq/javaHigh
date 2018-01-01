package xml.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {
	public static void main(String[] args) {
		//��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//����������
		DocumentBuilder builder = null;
		//��ȡdom��
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File("src/xml/dom/userlist.xml"));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��ȡ���ڵ�
		Element rootElement = document.getDocumentElement();
		NodeList userNodes = rootElement.getElementsByTagName("user");
		for(int i = 0 ; i < userNodes.getLength();i ++){
			//user�ڵ�
			Element user = (Element)userNodes.item(i);
			NamedNodeMap idNameNode = user.getAttributes();
			Node idNode = idNameNode.item(0);
			if(idNode != null){
				System.out.println(idNode.getTextContent());
			}
			//��ȡ����user����
			NodeList userChilds = user.getChildNodes();
			for(int j = 0 ; j < userChilds.getLength(); j++){
				//user����
				Node userChild = userChilds.item(j);
				//�жϽڵ��Ƿ���id
				if(userChild.getNodeName().equals("id")){
					String idValue = userChild.getTextContent();
					user.removeChild(userChild);
					user.setAttribute("id", idValue);
				}else if(userChild.getNodeName().equals("addr")){
					
					Element addrEle = (Element)userChild;
					NamedNodeMap codeNode = addrEle.getAttributes();
					String idName = codeNode.item(0).getNodeName();
					String idValue = codeNode.item(0).getTextContent();
					addrEle.removeAttribute(idName);
					Element newNode = document.createElement(idName);
					newNode.setTextContent(idValue);
					addrEle.appendChild(newNode);
				}
			}
		}
		//����д���ļ�����
		TransformerFactory xmlfactory = TransformerFactory.newInstance(); 
		//�ļ�д����
		Transformer transformer;
		try {
			transformer = xmlfactory.newTransformer();
			//��ȡdom��
			DOMSource source = new DOMSource(document);  
			//����д����
	        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src/xml/dom/userlist-new.xml"))); 
	        //����д��Ľ��
	        StreamResult result = new StreamResult(pw);  
	        transformer.transform(source, result);  
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}  
		
		
	}
}
