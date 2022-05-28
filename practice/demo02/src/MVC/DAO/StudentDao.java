package MVC.DAO;


public interface StudentDao {
    int add(int id, String name);

    int delete(int id);

    int edit(int id, String name1, String name2);

    int search(int id);
}

