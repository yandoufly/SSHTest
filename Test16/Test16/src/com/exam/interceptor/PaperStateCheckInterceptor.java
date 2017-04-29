package com.exam.interceptor;


import com.exam.action.PaperAction;
import com.exam.entities.ExamPaper;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 试卷状态检查拦截器
 */
public class PaperStateCheckInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		
		//检查试卷是否已经提交
		PaperAction action = (PaperAction) arg0.getAction();
		ExamPaper paper = action.getPaperService().getPaperById(action.getPaperId());
		String state = paper.getState();
		
		if("已完成".equals(state)){
			return "timeOut";
		}
		
		return arg0.invoke();
	}

}
