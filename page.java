package com.doj.spring4.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dinesh Rajput
 *
 */
@RestController
@RequestMapping("/service")
public class SpringRestController {
	

	
	static{
		
/*		for(int i=0;i<=100;i++){
			dataList.add(new Data("name_"+i,"age_"+i));
		}
		
		
		int k = dataList.size() % 15;
		if(k == 0){
			k = dataList.size() / 15;
		} else {
			k = dataList.size() / 15;
			k = k+1;
		}
		int p = 0;
		for(int i=0;i<=k;i++){
			linkList.add(new Link("page_"+i,"<a href='http://localhost:8080/Spring4HelloWorld/offset/"+p+"/limit/"+p+15+"/'></a>"));
			p = p+15;
		}
		*/
	}
	
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String sayHello(@PathVariable String name) {
		String result="Hello "+name+" to dineshonjava.com!!!";  
		return result;
	}
	
	@RequestMapping(value = "/offset/{offset}/limit/{limit}", method = RequestMethod.GET)
	public ReturnData pagination(@PathVariable String offset, @PathVariable String limit) {
		
		System.out.println(offset +"__"+ limit);
		ReturnData rd;
		
		synchronized(this){
			List<Data> dataList = new ArrayList<Data>();
			List<Link> linkList = new ArrayList<Link>();;
			
			for(int i=0;i<=99;i++){
				dataList.add(new Data("name_"+i,"age_"+i));
			}
			
			System.out.println(dataList.size());
			int k = (dataList.size() % 15);
			if(k == 0){
				k = dataList.size() / 15;
			} else {
				k = dataList.size() / 15;
				k = k+1;
			}
			int p = 0;
			for(int i=1;i<=k;i++){
				int l = p+15;
				if(i == k){
					l = dataList.size();
				}
				linkList.add(new Link("page_"+i,"<a href='http://localhost:8080/Spring4HelloWorld/offset/"+p+"/limit/"+(p+15)+"/'></a>"));

				p = p+15;
			}
			
			rd = new ReturnData(dataList,linkList);
			
			for(Data d : dataList){
				System.out.println(d.toString());
			}
			
			for(Link d : linkList){
				System.out.println(d.toString());
			}
			
		}
		
		
		
		return rd;
	}
	
	
}

class Link{
	
	private String url;
	private String pageNo;
	
	public Link( String pageNo, String url) {
		super();
		this.url = url;
		this.pageNo = pageNo;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	@Override
	public String toString() {
		
		System.out.println();
		return "Link [url=" + url + ", pageNo=" + pageNo + "]";
	}
	
	
	
	
	
}
class Data{
	
	private String name;
	private String age;
	
	
	public Data(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Data [name=" + name + ", age=" + age + "]";
	}
	
	
}


class ReturnData{
	
	private List<Data> data;
	private List<Link> link;
	
	public ReturnData(List<Data> data, List<Link> link) {
		super();
		this.data = data;
		this.link = link;
	}
	
}
