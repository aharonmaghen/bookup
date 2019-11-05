package bookup;

/** Stores author information */
class Author {

	private String name;

	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Author)) {
			throw new IllegalArgumentException("Object passed is not an instance of Author");
		}

		Author author = (Author)obj;

		return this.name.equals(author.name);
	}

}