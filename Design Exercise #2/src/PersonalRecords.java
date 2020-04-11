import java.util.ArrayList;

//define kill, death, assist
class KDA {
	private int kill = 0, death = 0, assist = 0;

	public KDA() {

	}

	public KDA(int kill, int death, int assist) {
		this.kill = kill;
		this.death = death;
		this.assist = assist;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}
}

public class PersonalRecords {
	private ArrayList<KDA> records = new ArrayList<KDA>();

	public void addNewGame() {
		records.add(new KDA());
	}
	
	public void addNewGame(KDA kda) {
		records.add(kda);
	}

	public void addKill() {
		KDA kda = records.get(records.size() - 1);// only can modify current game round
		kda.setKill(kda.getKill() + 1);
	}

	public void addDeath() {
		KDA kda = records.get(records.size() - 1);// only can modify current game round
		kda.setDeath(kda.getDeath() + 1);
	}

	public void addAssist() {
		KDA kda = records.get(records.size() - 1);// only can modify current game round
		kda.setAssist(kda.getAssist() + 1);
	}

	// query game round
	public KDA queryRecord(int round) {
		try {
			KDA kda = records.get(round - 1);
			return kda;
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		return null;
	}

	public KDA getCurrentGameKDA() {
		return records.get(records.size() - 1);
	}
	
	public ArrayList<KDA> getAllRecords() {
		return records;
	}
	
	public int getAllKills() {
		int total = 0;
		for (KDA kda : records) {
			total+=kda.getKill();
		}
		return total;
	}
	
	public int getAllDeath() {
		int total = 0;
		for (KDA kda : records) {
			total+=kda.getDeath();
		}
		return total;
	}
	
	public int getAllAssist() {
		int total = 0;
		for (KDA kda : records) {
			total+=kda.getAssist();
		}
		return total;
	}
}
