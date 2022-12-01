package Journal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenDetailJourn implements IJournal {

	@Override
	public void outPut_Msg (String message) {
		String className = new Exception().getStackTrace()[2].getClassName().toString();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		System.out.println(message+" : "+className+" - "+format.format(calendar.getTime()));
		
		
		
		}
}
