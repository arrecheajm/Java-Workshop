package ac_Digital_Records_Models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class contains data for identifying each animal
 * @author jma_u
 *
 */
public class Animal_Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 791719246074651526L;
	private String name;
	private String nickname;
	private String species;
	private String sex;
	private LocalDate dOB;
	private LocalDate dOA;
	private Time_Stamp lastEdited;
	private Time_Stamp created;
	//Vet_Log vetLog; Removed until defined
	
	/****** CONSTRUCTORS ******/
	
	/**
	 * @param name
	 * @param nickname
	 * @param species
	 * @param sex
	 * @param initials
	 */
	public Animal_Data(String name, String nickname, String species, String sex, String initials) {
		setAll(name, nickname, species, sex, null, null, initials);
		created = Time_Stamp.stamp(initials);
	}
	/**
	 * @param name
	 * @param nickname
	 * @param species
	 * @param sex
	 * @param dOB
	 * @param dOA
	 * @param initials
	 */
	public Animal_Data(String name, String nickname, String species, String sex, LocalDate dOB, 
			LocalDate dOA, String initials) {
		
		setAll(name, nickname, species, sex, dOB, dOA, initials);
		created = Time_Stamp.stamp(initials);
	}
	
	/**
	 * @param other
	 * @param initials
	 */
	public Animal_Data(Animal_Data other, String initials) {
		created = Time_Stamp.stamp(initials);
		setAll(other.getName(), other.getNickname(), other.getSpecies(), other.getSex(), other.getDOB(),
			other.getDOA(), initials);		
	}
	
	/****** MUTATORS ******/
	
	/**
	 * @param name
	 * @param nickname
	 * @param species
	 * @param sex
	 * @param dOB
	 * @param dOA
	 * @param initials
	 */
	public void setAll(String name, String nickname, String species, String sex, LocalDate dOB, 
			LocalDate dOA, String initials) {
		
		setName(name, initials);
		setnickname(nickname, initials);
		setSpecies(species, initials);
		setSex(sex, initials);
		setDOB(dOB, initials);
		setDOA(dOA, initials);		
	}
	
	/**
	 * @param sex
	 * @param initials
	 */
	public void setSex(String sex, String initials) {
		this.sex = sex;
		stamp(initials);
		
	}

	/**
	 * @param dOA
	 * @param initials
	 */
	public void setDOA(LocalDate dOA, String initials) {
		if (dOA != null) {
			this.dOA = dOA;
		} else {
			this.dOA = LocalDate.now();
		}
		stamp(initials);		
	}
	
	/**
	 * @param dOB
	 * @param initials
	 */
	public void setDOB(LocalDate dOB, String initials) {
		if (dOB != null) {
			this.dOB = dOB;
			stamp(initials);
		} else {
			System.err.println("DOB cannot be null, setDOB() request ignored...");
		}		
	}
	
	/**
	 * @param species
	 * @param initials
	 */
	public void setSpecies(String species, String initials) {
		this.species = species;
		stamp(initials);
		
	}
	
	/**
	 * @param nickname
	 * @param initials
	 */
	public void setnickname(String nickname, String initials) {
		this.nickname = nickname;
		stamp(initials);
		
	}
	
	/**
	 * @param name
	 * @param initials
	 */
	public void setName(String name, String initials) {
		this.name = name;
		stamp(initials);
		
	}
	
	/****** ACCESSORS ******/
	
	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @return
	 */
	public String getNickname() {
		return this.nickname;
	}
	/**
	 * @return
	 */
	public String getSex() {
		return this.sex;
	}
	/**
	 * @return
	 */
	public String getSpecies() {
		return this.species;
	}
	/**
	 * @return
	 */
	public LocalDate getDOB() {
		return this.dOB;
	}
	/**
	 * @return
	 */
	public LocalDate getDOA() {
		return this.dOA;
	}
	/**
	 * @return
	 */
	public Time_Stamp getCreatedStamp() {
		return this.created;
	}
	/**
	 * @return
	 */
	public Time_Stamp getLastEditedStamp() {
		return this.lastEdited;
	}
	
	/****** UTILITY ******/
	
	/**
	 * @param initials
	 */
	private void stamp(String initials) {
		lastEdited = Time_Stamp.stamp(initials);
	}

}
