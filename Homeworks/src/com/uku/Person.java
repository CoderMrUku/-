package com.uku;

public class Person {
	public int age;
	public String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) return false;
		Person person = (Person)obj;
		return (this.age == person.age) && (this.name.equals(person.name));
	}
	
	@Override
	public String toString() {
		return ("[age:" + this.age + ", name:" + this.name + "]");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize - age:" + this.age + ", name:" + this.name);
	}
}
