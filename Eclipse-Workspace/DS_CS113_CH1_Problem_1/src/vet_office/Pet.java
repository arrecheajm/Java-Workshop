package vet_office;

/**
 * @author jma_u
 *
 */
public class Pet {
	private MyLinkedList<String> diet; // Should this be a linked list of a structure that holds diet details?
	private String name;
	private MyLinkedList<String> medical_record;
	private int ID;
	private boolean isNocturnal;
	
	// CONSTRUCTORS //
	
	/**
	 * @param ID
	 * @param name
	 * @throws Exception
	 */
	public Pet(int ID, String name) throws Exception {
		this(ID, name, null, null);
	}
		

	/**
	 * @param ID
	 * @param name
	 * @param diet
	 * @param medical_records
	 * @throws Exception
	 */
	public Pet(int ID, String name, MyLinkedList<String> diet, MyLinkedList<String> medical_records) throws Exception {
		
		this.ID = ID;
		
		if (name == null) {
			throw new Exception("Pet name cannot be null");
		} else {
			this.name = name;
		}
		
		this.diet = new MyLinkedList<String>();		
		if (diet != null) {
			this.diet.add((Object) diet.toString());
		}
		
		this.medical_record = new MyLinkedList<String>();		
		if (medical_record != null) {
			int numberOfRecords = medical_records.size();			
			for (int i=0; i<numberOfRecords; i++) {
				this.medical_record.add((Object) medical_records.get(i).toString());
			}			
		}
		
	}
}
