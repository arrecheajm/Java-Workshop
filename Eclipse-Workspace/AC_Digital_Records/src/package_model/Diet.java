package package_model;

/**
 * Class contains a collection of food groups as a part of animal's diet. Diet Cannot be created or 
 * edited without providing initials for TimeStamp
 * @author jma_u
 *
 */
public class Diet {
	private Food_Group[] foodGroups;
	private String notes;
	private Boolean locked;
	private Time_Stamp lastEdited;
	private Time_Stamp created;
}
