package web.dto;

public class Question {
	
	private	int questionno;
	private int userno;
	private String question;
	private String questionpic;
	private String questitle;
	private String answer;
	private String userid;
	
	@Override
	public String toString() {
		return "Question [questionno=" + questionno + ", userno=" + userno + ", question=" + question + ", questionpic="
				+ questionpic + ", questitle=" + questitle + ", answer=" + answer + ", userid=" + userid + "]";
	}
	public int getQuestionno() {
		return questionno;
	}
	public void setQuestionno(int questionno) {
		this.questionno = questionno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionpic() {
		return questionpic;
	}
	public void setQuestionpic(String questionpic) {
		this.questionpic = questionpic;
	}
	public String getQuestitle() {
		return questitle;
	}
	public void setQuestitle(String questitle) {
		this.questitle = questitle;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
