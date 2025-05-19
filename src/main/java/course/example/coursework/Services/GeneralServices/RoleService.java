package course.example.coursework.Services.GeneralServices;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class RoleService {
    private static final String roleRequest = """
            SELECT r.rolname AS group_role
            FROM pg_auth_members m
            JOIN pg_roles r ON m.roleid = r.oid
            JOIN pg_roles u ON m.member = u.oid
            WHERE u.rolname = current_user;
            """;
    public static String getCurrentRoleGroup(){
        try(Session session = HibernateService.getSessionFactory().openSession()){
            NativeQuery<String> roleQuery = session.createNativeQuery(roleRequest);
            return roleQuery.uniqueResult();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
