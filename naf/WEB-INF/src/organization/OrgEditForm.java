package organization;

import java.util.ArrayList;
import java.util.List;

public class OrgEditForm {

	private List<OrgField> fields;
	
	
	public List<OrgField> getFields() {
		if(fields==null){
			fields=new ArrayList<OrgField>();
		}
		return fields;
	}
	
	
	public void setFields(List<OrgField> fields) {
		this.fields = fields;
	}


	public void addField(OrgField field) {
		
		getFields().add(field);
		
	}

}
