package xml.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class dom4jTest {
	private static File file = new File("src/xml/dom4j/userList.xml");
	private static Document userElement;
	private static Element rootEle ;
	private static Scanner input = new Scanner(System.in);
	static{
		//����SAXReader��ȡXML�ļ�
		SAXReader read = new SAXReader();
		
		//����ȡ���Ķ����װ��Document������
		try {
			userElement = read.read(file);
		} catch (DocumentException e) {
			
		}
		//��ȡ���ڵ�
		rootEle = userElement.getRootElement();
		
	}
	/**
	 * ��ӷ���
	 */
	public void add(){
		//���ø��ڵ�
		Element parentEle = DocumentHelper.createElement("user");
		System.out.println("������id:");
		String id = input.next();
		Element ele = getElementByID(id);
		if(ele!=null){
			System.out.println("���û�id�Ѵ��ڣ�");
			return;
		}
		//Ϊ���ڵ��������� ������ֵ
		Attribute idEle = DocumentHelper.createAttribute(parentEle, "id", id);
		
		//�����ӽڵ�name
		Element nameEle = DocumentHelper.createElement("name");
		//Ϊ�ýڵ����Ԫ��
		System.out.println("�������û���:");
		String name = input.next();
		nameEle.setText(name);
		//�����ӽڵ�password
		Element passwordEle = DocumentHelper.createElement("password");
		System.out.println("�������û�����:");
		String password = input.next();
		passwordEle.setText(password);
		
		//���������ݰ�װ��user�ڵ���
		parentEle.add(idEle);
		parentEle.add(nameEle);
		parentEle.add(passwordEle);
		
		rootEle.add(parentEle);
		//���÷���ˢ��
		flushXML();
		System.out.println("��ӳɹ���");
	}
	
	/**
	 * ɾ��
	 */
	public void delete() {
		System.out.println("������Ҫɾ�����û�id:");
		String id = input.next();
		//ͨ��id����һ��Element ����Ԫ�ش�����ele��Ϊ��
		Element ele = getElementByID(id);
		if(ele==null){
			System.out.println("�޸��û�id��");
			return;
		}
		//ͨ�����ڵ�ɾ����user
		rootEle.remove(ele);
		//���÷���ˢ���ļ�
		flushXML();
		System.out.println("ɾ���ɹ���");
	}
	/**
	 * �޸�
	 */
	public void update() {
		System.out.println("������Ҫ�޸ĵ��û�id:");
		String id = input.next();
		//ͨ��id����һ��Element ����Ԫ�ز�������eleΪ��
		Element ele = getElementByID(id);
		if(ele==null){
			System.out.println("�޸��û�id��");
			return;
		}
		System.out.println("������Ҫ�޸ĵ��û�������");
		String upName = input.next();
		
		System.out.println("������Ҫ�޸ĵ��û����룡");
		String upPassword = input.next();
		
		//��ȡname�ӽڵ�
		Element nameEle = ele.element("name"); 
		//�޸�������
		nameEle.setText(upName);
		
		//��ȡpassword�ӽڵ�
		Element passwordEle = ele.element("password"); 
		//�޸�������
		passwordEle.setText(upPassword);		
		//���÷���ˢ���ļ�
		flushXML();
		System.out.println("�޸ĳɹ���");
		
	}
	/**
	 * ����
	 */
	public void find() {
		//���÷���ˢ���ļ�
		flushXML();
		System.out.println("������Ҫ���ҵ��û�id:");
		String id = input.next();
		//ͨ��id����һ��Element ����Ԫ�ز�������eleΪ��
		Element ele = getElementByID(id);
		if(ele==null){
			System.out.println("�޸��û�id��");
			return;
		}
		Attribute idEle = ele.attribute("id");
		String findId = idEle.getText(); 
		//��ȡname�ӽڵ�
		Element nameEle = ele.element("name");
		String findName = nameEle.getText();
		//��ȡpassword�ӽڵ�
		
		Element passwordEle = ele.element("password"); 
		String findPassword = passwordEle.getText();

		System.out.println("���û�idΪ:"+findId+"���û�����Ϊ:"+findName+"���û�����Ϊ:"+findPassword);
		
	}
	/**
	 * 
	 */
	public void userList() {
		//��ȡ�����û��б�
		List<?> userList = rootEle.elements();
		if(userList.isEmpty()){
			System.out.println("��ǰ���κ��û�");
			return;
		}
		for(Iterator<?> iter = userList.iterator();iter.hasNext();){
			Element ele = (Element) iter.next();
			Attribute idEle = ele.attribute("id");
			String findId = idEle.getText(); 
			//��ȡname�ӽڵ�
			Element nameEle = ele.element("name");
			String findName = nameEle.getText();
			//��ȡpassword�ӽڵ�
			
			Element passwordEle = ele.element("password"); 
			String findPassword = passwordEle.getText();
		 

			System.out.println("�û�idΪ:"+findId+"���û�����Ϊ:"+findName+"���û�����Ϊ:"+findPassword);
			
		}
		
	}
	private Element getElementByID(String id) {
		//��ȡ�����û��б�
		List<?> userList = rootEle.elements();
		for(Iterator<?> iter = userList.iterator();iter.hasNext();){
			Element ele = (Element) iter.next();
			Attribute idatt = ele.attribute("id"); 
			String idEle = idatt.getText();
			if(id.equals(idEle)){
				return ele;
			}
		}
		return null;
	}
	/**
	 * ˢ��XML�ĵ�����ӣ��޸ģ�ɾ����������ݴ���
	 */
	private void flushXML(){
		XMLWriter writer = null;
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		try {
			writer = new XMLWriter(new FileWriter(file),format);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			writer.write(userElement);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
