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
		//利用SAXReader读取XML文件
		SAXReader read = new SAXReader();
		
		//将获取到的对象封装入Document对象中
		try {
			userElement = read.read(file);
		} catch (DocumentException e) {
			
		}
		//获取根节点
		rootEle = userElement.getRootElement();
		
	}
	/**
	 * 添加方法
	 */
	public void add(){
		//设置父节点
		Element parentEle = DocumentHelper.createElement("user");
		System.out.println("请输入id:");
		String id = input.next();
		Element ele = getElementByID(id);
		if(ele!=null){
			System.out.println("该用户id已存在！");
			return;
		}
		//为父节点设置属性 和属性值
		Attribute idEle = DocumentHelper.createAttribute(parentEle, "id", id);
		
		//设置子节点name
		Element nameEle = DocumentHelper.createElement("name");
		//为该节点添加元素
		System.out.println("请输入用户名:");
		String name = input.next();
		nameEle.setText(name);
		//设置子节点password
		Element passwordEle = DocumentHelper.createElement("password");
		System.out.println("请输入用户密码:");
		String password = input.next();
		passwordEle.setText(password);
		
		//将所有内容包装到user节点中
		parentEle.add(idEle);
		parentEle.add(nameEle);
		parentEle.add(passwordEle);
		
		rootEle.add(parentEle);
		//调用方法刷新
		flushXML();
		System.out.println("添加成功！");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		System.out.println("请输入要删除的用户id:");
		String id = input.next();
		//通过id返回一个Element 若该元素存在则ele不为空
		Element ele = getElementByID(id);
		if(ele==null){
			System.out.println("无该用户id！");
			return;
		}
		//通过根节点删除该user
		rootEle.remove(ele);
		//调用方法刷新文件
		flushXML();
		System.out.println("删除成功！");
	}
	/**
	 * 修改
	 */
	public void update() {
		System.out.println("请输入要修改的用户id:");
		String id = input.next();
		//通过id返回一个Element 若该元素不存在则ele为空
		Element ele = getElementByID(id);
		if(ele==null){
			System.out.println("无该用户id！");
			return;
		}
		System.out.println("请输入要修改的用户姓名！");
		String upName = input.next();
		
		System.out.println("请输入要修改的用户密码！");
		String upPassword = input.next();
		
		//获取name子节点
		Element nameEle = ele.element("name"); 
		//修改新名字
		nameEle.setText(upName);
		
		//获取password子节点
		Element passwordEle = ele.element("password"); 
		//修改新名字
		passwordEle.setText(upPassword);		
		//调用方法刷新文件
		flushXML();
		System.out.println("修改成功！");
		
	}
	/**
	 * 查找
	 */
	public void find() {
		//调用方法刷新文件
		flushXML();
		System.out.println("请输入要查找的用户id:");
		String id = input.next();
		//通过id返回一个Element 若该元素不存在则ele为空
		Element ele = getElementByID(id);
		if(ele==null){
			System.out.println("无该用户id！");
			return;
		}
		Attribute idEle = ele.attribute("id");
		String findId = idEle.getText(); 
		//获取name子节点
		Element nameEle = ele.element("name");
		String findName = nameEle.getText();
		//获取password子节点
		
		Element passwordEle = ele.element("password"); 
		String findPassword = passwordEle.getText();

		System.out.println("该用户id为:"+findId+"该用户名称为:"+findName+"该用户密码为:"+findPassword);
		
	}
	/**
	 * 
	 */
	public void userList() {
		//获取所有用户列表
		List<?> userList = rootEle.elements();
		if(userList.isEmpty()){
			System.out.println("当前无任何用户");
			return;
		}
		for(Iterator<?> iter = userList.iterator();iter.hasNext();){
			Element ele = (Element) iter.next();
			Attribute idEle = ele.attribute("id");
			String findId = idEle.getText(); 
			//获取name子节点
			Element nameEle = ele.element("name");
			String findName = nameEle.getText();
			//获取password子节点
			
			Element passwordEle = ele.element("password"); 
			String findPassword = passwordEle.getText();
		 

			System.out.println("用户id为:"+findId+"该用户名称为:"+findName+"该用户密码为:"+findPassword);
			
		}
		
	}
	private Element getElementByID(String id) {
		//获取所有用户列表
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
	 * 刷新XML文档将添加，修改，删除，后的数据存入
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
