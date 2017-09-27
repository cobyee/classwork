package attendance;

public class Student implements Attendee{

	private String firstName;
	private String lastName;
	private boolean present = false;
	
	public Student(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean mathces(String first, String last) {
		if(first.toLowerCase().equals(firstName.toLowerCase())) {
			if(last.toLowerCase().equals(lastName.toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}

	public boolean matches(String last) {
		if(last.toLowerCase().equals(lastName.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public String getReportString() {
		String line = lastName;
		if(lastName.length() > 20) {
			if(firstName.length() > 20) {
				line = lastName.substring(0,17) + "..." + firstName.substring(0,17) + "..." + isPresent();
				return line;
			}
		}
		String r = line;
		while(r.length() < 20) {
			r += " ";
		}
		r += firstName;
		while(r.length() < 40) {
			r += " ";
		}
		if(present) {
			r += "Present" + "\n";
		}
		else {
			r += "Absent" + "\n";
		}
		return r;
	}
}