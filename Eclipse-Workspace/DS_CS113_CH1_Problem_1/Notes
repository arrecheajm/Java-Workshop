package vet_office;

/**
 * @author jma_u
 *
 */
public class Pet {
	private MyLinkedList<String> diet; 
	private String name;
	private MyLinkedList<String> medical_record;
	private int ID;
	private boolean isNocturnal;
	
	/*** CONSTRUCT ***/
	
	
	/**
	 * @param name
	 * @param ID
	 * @param isNocturnal
	 * @throws Exception
	 */
	public Pet(String name, int ID, boolean isNocturnal) throws Exception {
		initStorage();
		setAll(name, ID, isNocturnal, null, null);
	}
		

	/**
	 * @param name
	 * @param ID
	 * @param isNocturnal
	 * @param diet
	 * @param medical_records
	 * @throws Exception
	 */
	public Pet(String name, int ID, boolean isNocturnal, String diet, String medical_records) throws Exception {
		initStorage();
		setAll(name,ID,isNocturnal, diet, medical_records);
	}
	
	/**
	 * 
	 */
	private void initStorage() {
		this.diet = new MyLinkedList<String>();
		this.medical_record = new MyLinkedList<String>();
	}
	
	/*** SET  ***/
	
	/**
	 * @param name
	 * @param ID
	 * @param isNocturnal
	 * @param diet
	 * @param medical_record
	 * @throws Exception
	 */
	public void setAll(String name, int ID, boolean isNocturnal, String diet, String medical_record) throws Exception {
		setName(name);
		setID(ID);
		setNocturnal(isNocturnal);
		addDiet(diet);
		addMedicationRecord(medical_record);
	}
	
	/**
	 * @param name
	 * @throws Exception
	 */
	public void setName (String name) throws Exception {
		if (name != null) {
			this.name = name;
		} else {
			throw new Exception("Pet name cannot be null");
		}
	}
	
	/**
	 * @param ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 * @param nocturnal
	 */
	public void setNocturnal(boolean isNocturnal) {
		this.isNocturnal = isNocturnal;
	}
	
	/**z
	 * @param diet
	 */
	public void addDiet(String diet) {
		if (diet != null) {
			this.diet.add(diet);
		}
	}
	
	/**
	 * @param medical_record
	 */
	public void addMedicationRecord(String medical_record) {
		if (medical_record != null) {
			this.medical_record.add(medical_record);
		}
	}
	
	
	/*** GET ***/
	
	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return
	 */
	public int getID() {
		return this.ID;
	}
	/**
	 * @return
	 */
	public boolean getNocturnal() {
		return this.isNocturnal;
	}
	/**
	 * @return
	 */
	public String getDiet() {
		return this.diet.toString();
	}
	/**
	 * @return
	 */
	public String getMedicalRecord() {
		return this.medical_record.toString();
	}
}
