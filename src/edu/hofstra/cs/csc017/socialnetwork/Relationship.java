package edu.hofstra.cs.csc017.socialnetwork;

public class Relationship {
	
    private Person firstPerson;
    private Person secondPerson;
    private RelationshipType relation;

    public Relationship(Person firstPerson, Person secondPerson, RelationshipType relation) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
        this.relation = relation;
    }
    
    public boolean isInRelation(Person person) {
    	return (relation == RelationshipType.FOLLOW || relation == RelationshipType.FRIEND) && 
    			(person.equals(firstPerson) || person.equals(secondPerson));
    			
    }
    
    public Person getFriend(Person person) {
    	return person.equals(firstPerson) ? secondPerson : firstPerson;
    }

    @Override
    public String toString() {
        if (relation == RelationshipType.FOLLOW) {
            return firstPerson.getFullName() + " is following " + secondPerson.getFullName();
        }
        return firstPerson.getFullName() + " is a friend of " + secondPerson.getFullName();
    }

	public Person getFirstPerson() {
		return firstPerson;
	}

	public void setFirstPerson(Person firstPerson) {
		this.firstPerson = firstPerson;
	}

	public Person getSecondPerson() {
		return secondPerson;
	}

	public void setSecondPerson(Person secondPerson) {
		this.secondPerson = secondPerson;
	}

	public RelationshipType getRelation() {
		return relation;
	}

	public void setRelation(RelationshipType relation) {
		this.relation = relation;
	}
    
}
