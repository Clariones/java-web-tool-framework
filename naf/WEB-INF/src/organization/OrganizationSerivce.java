package organization;

import java.util.List;
import java.util.Stack;

public class OrganizationSerivce {
	public OrganizationList listAll() {
		OrganizationList list = new OrganizationList();
		return list;
	}
	protected OrgEditForm getEditForm(Organization root){
		OrgEditForm form=new OrgEditForm();
		
		buildForm(form,root);
		
		return form;
		
	}
	public OrgEditForm getDefaultEditForm(){
		
		return getEditForm(this.getDefault());
		
	}
	protected void buildForm(OrgEditForm form, Organization root) {
		
		Integer level=0;
		Integer index=0;
		
		Stack <String>keyStack=new Stack<String>();
		buildField(form,level, index, keyStack, root);
		
	}
	
	protected String getKey(Stack <String>keyStack){
		
		int size=keyStack.size();
		
		if(keyStack.size()==0){
			return "";
		}
		StringBuilder stringBuilder=new StringBuilder();
		int index=0;
		for(String frame:keyStack){
			if(index>0){
				stringBuilder.append(".");
			}
			stringBuilder.append(frame);
			index++;
			
		}
		return stringBuilder.toString();
		
	}
	
	protected void buildField(OrgEditForm form, Integer level, Integer index, Stack <String>keyStack,Organization node) {
		
		
		
		
		OrgField field=new OrgField();
		
		field.setName("name");
		field.setLevel(level);
		field.setIndex(index);
		field.setValue(node.getName());
		String key=getKey(keyStack);
		
		field.setKey(key);
		
		
		form.addField(field);
		
		if(node.isLeaf()){
			
			return;
		}
		level++;
		List<Organization> orgList=node.getSubOrganizations();
		index=0;
		for(Organization org:orgList){
			keyStack.push("subOrganizations."+index);
			buildField(form, level, index,keyStack, org);
			keyStack.pop();
			index++;
		}

		level--;
		
	}
	public Organization getDefault() {
		Organization root = createNew("Aaxis Group");

		root.enterSubOrganization(createNew("Aaxis China"))
				.enterSubOrganization(createNew("Consulting"))
					.addSubOrganization(createNew("Project Manager Team"))
					.addSubOrganization(createNew("Testing Team"))
					.addSubOrganization(createNew("Arch Team"))
					.addSubOrganization(createNew("BA Team"))
				.jumpOut()					
				.enterSubOrganization(createNew("Share Service"))
					.addSubOrganization(createNew("CX"))
					.addSubOrganization(createNew("Commerce"))
					.addSubOrganization(createNew("Infra"))
				.jumpOut()
				.addSubOrganization(createNew("Administration"))
			.jumpOut()
			.addSubOrganization(createNew("Aaxis US"));

		return root;
	}

	protected Organization createNew(String name) {
		Organization org = new Organization();

		org.setName(name);

		return org;
	}

	public static void main(String[] args) {
		OrganizationSerivce service = new OrganizationSerivce();
		service.getDefault();
	}

}
