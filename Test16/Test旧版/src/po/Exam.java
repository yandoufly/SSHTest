package po;
/**
 * 考试
 * @author student
 *
 */
public class Exam {

	int examId;
	
	//考试的名称：比如 XXXXX期末考试
	String examName;
	//考试的时间：单位分钟
	int examTime;
	//考试的题量;
	int examQuestionCount;
	//考试的总分;
	int examTotalScore;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}
	public int getExamQuestionCount() {
		return examQuestionCount;
	}
	public void setExamQuestionCount(int examQuestionCount) {
		this.examQuestionCount = examQuestionCount;
	}
	public int getExamTotalScore() {
		return examTotalScore;
	}
	public void setExamTotalScore(int examTotalScore) {
		this.examTotalScore = examTotalScore;
	}
	
}
