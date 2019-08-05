package FrameListStudentMain;

public class Student {
	private String firstName;
	private String lastName;
	private String indexNumber;
	private String yearOfStudies;
	private String levelOfStudies;

	public Student(String firstName, String lastName, String num, String y, String level) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.indexNumber = num;
		this.yearOfStudies = y;
		this.levelOfStudies = level;
	}

	public Student() {

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public String getYearOfStudies() {
		return yearOfStudies;
	}

	public int yearInt() {
		if (this.yearOfStudies.equals("1")) {
			return 1;
		} else if (this.yearOfStudies.equals("2")) {
			return 2;
		} else if (this.yearOfStudies.equals("3")) {
			return 3;
		} else {
			return 4;
		}
	}

	public int levelInt() {
		if (this.levelOfStudies.equals("Undergraduate studies")) {
			return 1;
		} else if (this.levelOfStudies.equals("Master studies")) {
			return 2;
		} else {
			return 3;
		}
	}

	public String getLevelOfStudies() {
		return levelOfStudies;
	}

}
