package interceptor;

import po.ExamPaper;
import action.PaperAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AutoCommitInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		
		//开启线程来提交试卷
		final PaperAction action = (PaperAction) arg0.getAction();
		
		Thread t = new Thread(){
			@Override
			public void run() {
				try {
					//等待试卷的考试时间那么长的时间
					int time = action.getPaperService().getExamTimeByPaperId(action.getPaperId());
					this.sleep(time*60*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//获得试卷
				ExamPaper paper = action.getPaperService().getPaperById(action.getPaperId());
				if("考试中".equals(paper.getState())){
					action.getPaperService().commitPaper(action.getPaperId(), action.getIndex(), action.getAnswers());
				}
			}
		};
		
		t.start();
		
		return arg0.invoke();
	}

}
