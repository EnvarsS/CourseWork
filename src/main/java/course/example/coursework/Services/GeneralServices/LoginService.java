package course.example.coursework.Services.GeneralServices;

import course.example.coursework.Enum.SceneType;

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
