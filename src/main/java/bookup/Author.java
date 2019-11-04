package bookup;

/** Stores author information */
class Author {

	private String firstName;
	private String lastName;
	private String middleInitial; // String since an author can have more than one middle initial

	public Author(String firstName, String lastName, String middleInitial) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
	}

	// firstName getter/setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName.toLowerCase();
		this.firstName.charAt(0) -= 32; // keeps firstName with first letter capitalized ex. "Mark"
	}

	// lastName getter/setter
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.lastName.charAt(0) -= 32; // keeps lastName with first letter capitalized ex. "Twain"
	}

	// middleInitial getter/setter
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial.toUpperCase();
	}

	@Override
	public String toString() {
		return firstName + " " + middleInitial + " " + lastName;
	}

}