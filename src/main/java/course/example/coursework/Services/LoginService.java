package course.example.coursework.Services;

import course.example.coursework.Enum.SceneType;

import java.sql.ResultSet;

public class LoginService {
    public static SceneType getUserRoleGroup(){
        try {
            String role = RoleService.getCurrentRoleGroup();
            if(role == null)
                throw new Exception("No role found");
            return switch (role){
                case "clients" -> SceneType.CLIENT;
                case "admins" -> SceneType.ADMIN;
                case "mechanics" -> SceneType.MECHANIC;
                default -> null;
            };
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
