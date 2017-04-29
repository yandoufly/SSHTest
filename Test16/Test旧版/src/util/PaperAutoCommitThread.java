package util;

import po.ExamPaper;
import service.PaperService;

/**
 * 自动提交线程类
 * @author student
 *
 */
public class PaperAutoCommitThread extends Thread{
	
	ExamPaper paper;
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		paper.setState("已完成");
		paperService.updatePaper(paper);
	}
	
	PaperService paperService;
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	public ExamPaper getPaper() {
		return paper;
	}
	public void setPaper(ExamPaper paper) {
		this.paper = paper;
	}
}
