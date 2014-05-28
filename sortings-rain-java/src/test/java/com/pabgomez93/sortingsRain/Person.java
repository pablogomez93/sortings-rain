package com.pabgomez93.sortingsRain;

public class Person {
	private int age;
	private String name;
	
	public Person(int age, String name) {
		setAge(age);
		setName(name);
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))
			return false;
		
		if (this == obj)
			return true;
		
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null && other.name != null)
			return false;
		if (!name.equals(other.name))
			return false;
		
		return true;
	}
	
}
