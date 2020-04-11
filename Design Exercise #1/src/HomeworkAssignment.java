import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

//define homework data type
class Homework{
	private String courseName, description;
	private Calendar assignedDate, dueDate;
	
	public Homework(String courseName, String description, Calendar assignedDate, Calendar dueDate) {
		this.courseName = courseName;
		this.description = description;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Calendar assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
}

public class HomeworkAssignment {
	Queue<Homework> homeworks =  new LinkedList<>();
	Calendar timeSpan;
	
	public void addHomework(Homework homework) {
		homeworks.add(homework);
		
		//by default the time span to finish all tasks is 14 days later
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 14);
		this.timeSpan = calendar;
	}
	
	//finished the top priority one
	public void finished() {
		homeworks.remove();
	}
	
	//next homework
	public Homework next() {
		return homeworks.peek();
	}
	
	//all
	public Queue<Homework> getAllHomework() {
		return homeworks;
	}
	
	//time span
	public void setTimeSpan(Integer days) {
		timeSpan.add(Calendar.DATE, days);
	}
	
	//get all in a time span
	public Queue<Homework> getAllInTimeSpan() {
		Queue<Homework> hw =  new LinkedList<>();
		for (Homework homework : homeworks) {
			if(homework.getDueDate().compareTo(timeSpan) == -1) //compareTo() returns -1 if the time of this Calendar object is less than the passed object.
				hw.add(homework);
		}
		return hw;
	}
	
	//print info
	public void printAll(Queue<Homework> homeworks) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMdd,yyyy");	
		
		for (Homework homework : homeworks) {
			System.out.println(homework.getCourseName()
					+"--"+homework.getDescription()
					+"\tAssigned on: "+sdf.format(homework.getAssignedDate().getTime()) 
					+"\tDue Date: "+sdf.format(homework.getDueDate().getTime()));
		}		
	}
	
	
}
