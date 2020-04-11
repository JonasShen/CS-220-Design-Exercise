import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;



public class TestClass {
	static PersonalRecords personRecords;

	@Before
	public void setUp() {
		personRecords = new PersonalRecords();
		personRecords.addNewGame(new KDA(2, 3, 3));
		personRecords.addNewGame(new KDA(1, 3, 4));
		personRecords.addNewGame(new KDA(2, 2, 3));
	}

	@Test
	public void testExistingRecords() {
		assertEquals(3, personRecords.getAllRecords().size());
		assertEquals(2, personRecords.queryRecord(1).getKill());
		assertEquals(3, personRecords.queryRecord(2).getDeath());
		assertEquals(3, personRecords.queryRecord(3).getAssist());
		assertEquals(5, personRecords.getAllKills());
		assertEquals(8, personRecords.getAllDeath());
		assertEquals(10, personRecords.getAllAssist());
	}
	
	@Test
	public void testAddNewGame() {
		personRecords.addNewGame();
		personRecords.addAssist();
		personRecords.addAssist();
		personRecords.addDeath();
		personRecords.addKill();
		assertEquals(2, personRecords.getCurrentGameKDA().getAssist());
		assertEquals(1, personRecords.getCurrentGameKDA().getDeath());
		assertEquals(1, personRecords.getCurrentGameKDA().getKill());
	}
	
	@Test
	public void testThrowErr() {
		try {
			personRecords.queryRecord(5);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
}
