import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Queue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCase {
	static HomeworkAssignment homeworkAssignment;
	
	@Before
	public void setUp() throws Exception {
		homeworkAssignment = new HomeworkAssignment();
		
		Calendar assignedDate1 = Calendar.getInstance();
		assignedDate1.add(Calendar.DATE, -5);
		Calendar dueDate1 = Calendar.getInstance();
		dueDate1.add(Calendar.DATE, 10);
		Homework homework1 = new Homework("Computer", "Final Project", assignedDate1, dueDate1);
		homeworkAssignment.addHomework(homework1);
		
		Calendar assignedDate2 = Calendar.getInstance();
		assignedDate2.add(Calendar.DATE, -4);
		Calendar dueDate2 = Calendar.getInstance();
		dueDate2.add(Calendar.DATE, 13);
		Homework homework2 = new Homework("Math", "Assignment 4", assignedDate2, dueDate2);
		homeworkAssignment.addHomework(homework2);
		
		Calendar assignedDate3 = Calendar.getInstance();
		assignedDate3.add(Calendar.DATE, -3);
		Calendar dueDate3 = Calendar.getInstance();
		dueDate3.add(Calendar.DATE, 15);  //further than 2 weeks 
		Homework homework3 = new Homework("English", "Homework 7", assignedDate3, dueDate3);
		homeworkAssignment.addHomework(homework3);
		
		Calendar assignedDate4 = Calendar.getInstance();
		assignedDate4.add(Calendar.DATE, -3);
		Calendar dueDate4 = Calendar.getInstance();
		dueDate4.add(Calendar.DATE, 12);  
		Homework homework4 = new Homework("Physics", "Online Quiz 3", assignedDate4, dueDate4);
		homeworkAssignment.addHomework(homework4);
		

	}

	@Test
	//test whether the one that due date further than 2 weeks won't show
	public void test1() {
		//homeworkAssignment.printAll(homeworkAssignment.getAllHomework());
		//homeworkAssignment.printAll(homeworkAssignment.getAllInTimeSpan());
		assertEquals(4, homeworkAssignment.getAllHomework().size());
		assertEquals(3, homeworkAssignment.getAllInTimeSpan().size());
	}
	
	@Test
	//test whether assignment order is in the order of assigned date
	public void test2() {
		Queue<Homework> homeworks =  homeworkAssignment.getAllHomework();
		assertEquals("Computer", homeworks.poll().getCourseName());
		assertEquals("Math", homeworks.poll().getCourseName());
		assertEquals("English", homeworks.poll().getCourseName());
		assertEquals("Physics", homeworks.poll().getCourseName());
	}
}
