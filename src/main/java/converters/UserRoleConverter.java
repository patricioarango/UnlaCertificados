package converters;

import org.springframework.stereotype.Component;

import entities.UserRole;
import models.UserRoleModel;

@Component
public class UserRoleConverter {
	
	public UserRoleModel entityToModel(UserRole rol) {
		return new UserRoleModel(rol.getRole());
	}

	public UserRole modeltoEntity(UserRoleModel rol) {
		return new UserRole(rol.getRole());
	}
}
