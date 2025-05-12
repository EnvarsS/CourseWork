package course.example.coursework.Services;

import course.example.coursework.Enum.Scene;

import java.sql.Connection;
import java.sql.ResultSet;

public class LoginService {
    private static final String roleGroupQuery = "SELECT r.rolname AS group_role FROM pg_auth_members m JOIN pg_roles r ON m.roleid = r.oid JOIN pg_roles u ON m.member = u.oid WHERE u.rolname = current_user;";
    public static Scene getUserRoleGroup(){
        try {
            ResultSet roleGroup = ConnectionService.currentConnection.createStatement().executeQuery(roleGroupQuery);
            roleGroup.next();
            switch (roleGroup.getString("group_role")){
                case "clients" ->  { return Scene.CLIENT; }
                case "mechanics" ->  { return Scene.MECHANIC; }
                case "admins" ->  { return Scene.ADMIN; }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
