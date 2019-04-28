package watchlist.watchlist.data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import watchlist.watchlist.users.User;

/**
 * This class generates data used for the User-Service test
 * 
 * @author Belinda Schühle
 *
 */
public class UserDataGenerator implements DataGeneratable<User> {

	public UserDataGenerator() {
	}

	@Override
	public DataHolder<User> generate() {

		Calendar calendarOne = new GregorianCalendar(2001, 6, 16);
		Calendar calendarTwo = new GregorianCalendar(1997, 10, 23);
		Calendar calendarThree = new GregorianCalendar(2001, 4, 16);
		Date dateOne = calendarOne.getTime();
		Date dateTwo = calendarTwo.getTime();
		Date dateThree = calendarThree.getTime();

		return DataHolder.of(
				new User(0L, "Daniela", "Simoes", dateOne, "danielamsimoes01@gmail.com", "test0102",
						"test0102password"),
				new User(1L, "Belinda", "Stifani", dateTwo, "belinda.stifani@gmail.com", "bruce0102",
						"bruce0102password"),
				new User(2L, "Belinda", "Schuehle", dateThree, "beli.schuehle@gmail.com", "dabi0102",
						"dabi0102password"));
	}

}