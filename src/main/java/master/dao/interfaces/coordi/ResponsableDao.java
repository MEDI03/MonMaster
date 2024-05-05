package master.dao.interfaces.coordi;

public interface ResponsableDao {
		public boolean checkLogin(String email,String password);
		public int getById(String email);
}
