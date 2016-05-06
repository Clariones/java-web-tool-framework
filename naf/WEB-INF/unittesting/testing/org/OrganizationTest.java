package testing.org;

import org.junit.Test;

import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import organization.OrgEditForm;
import organization.Organization;
import organization.OrganizationSerivce;

public class OrganizationTest {
	@Test
	public void testURL() {

		OrganizationSerivce service = new OrganizationSerivce();
		Organization org = service.getDefault();
		System.out.println(getObjectExpr(org));

	}
	
	@Test
	public void testForm() {

		OrganizationSerivce service = new OrganizationSerivce();
		OrgEditForm form = service.getDefaultEditForm();
		System.out.println(getObjectExpr(form));

	}
	

	class PropertiesExclusionStrategy implements com.google.gson.ExclusionStrategy {

		public boolean shouldSkipField(FieldAttributes fa) {

			if (fa.getName().equals("parentOrganization")) {
				return true;
			}
			return false;
		}

		public boolean shouldSkipClass(Class<?> clazz) {

			return false;
		}

	}

	protected String getObjectExpr(Object target) {
		Gson serializer = new GsonBuilder().setExclusionStrategies(new PropertiesExclusionStrategy())
				.setPrettyPrinting().create();
		return "class: '" + target.getClass().getName() + "'\r\n" + serializer.toJson(target);

	}

}
