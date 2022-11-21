import java.util.ArrayList;

public class MultiJourn implements IJournal {
	ArrayList<IJournal> journals = new ArrayList<IJournal>();
	
	public void addJournal(IJournal j) {
		journals.add(j);
	}
	
	@Override
	public void outPut_Msg (String message) {
		for(IJournal j : journals) {
			j.outPut_Msg(message);
		}	
	}

}
