package action;

import org.hibernate.SessionFactory;

import po.ExamPaper;
import service.PaperService;

public class AutoCommitThread extends Thread{
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		paperAction.commitExamPaper();
		
	}
	
	PaperAction paperAction;

	public PaperAction getPaperAction() {
		return paperAction;
	}

	public void setPaperAction(PaperAction paperAction) {
		this.paperAction = paperAction;
	}
	
}

