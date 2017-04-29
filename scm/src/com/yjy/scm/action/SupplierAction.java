package com.yjy.scm.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjy.scm.entity.Page;
import com.yjy.scm.entity.Supplier;
import com.yjy.scm.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierAction {
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("/insert") //json数据
	public @ResponseBody Object insert(Supplier supplier){
		System.out.println("---action.supplier:"+supplier);
		int i = 0;
		try {
			i = supplierService.insertEntity(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	//根据主键修改供应商的信息
	@RequestMapping(value="/update")
	public @ResponseBody Object update(Supplier supplier){
		System.out.println("---action.update.supplier:"+supplier);
		int i = 0;
		try {
			i = supplierService.updateEntity(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	@RequestMapping("/deleteList")
	public @ResponseBody Object deleteList(String [] pks){
		System.out.println("---doAjax.deleteList:"+pks);
		int i = 0;
		try {
			i = supplierService.deleteList(pks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	//通过关键字分页查询
	@RequestMapping("/selectPage")
	public @ResponseBody Object selectPage(Page<Supplier> page){
		Page p = supplierService.selectPage(page);
		System.out.println(page);
		System.out.println("1----page:"+page.getPageMap().size());
		return p.getPageMap();
	}
	
	//通过关键字分页查询(动态)
	@RequestMapping("/selectPageUseDyc")
	public @ResponseBody Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
		page.setParamEntity(supplier);
		System.out.println(page);
		Page p = supplierService.selectPageUseDyc(page);
		System.out.println("2--page:"+p);
		for (Object key : p.getPageMap().keySet()) {  
            System.out.println("key = " + key.toString() + "; value = " + p.getPageMap().get(key));  
        }  
		return p.getPageMap();
	}
	
	//测试json数据
	@RequestMapping("/doAjax")
	public @ResponseBody Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}
}
