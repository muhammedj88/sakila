package da;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class ResourceBase<T> {
	 
	  protected EntityManager getEntityManager() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SakilaSystem3");
	    return emf.createEntityManager();
	  }

	//CRUD-Create 
			public abstract void insert(T e);
	  
	//CRUD-Read
	        public abstract List<T> getAll();
			public abstract T getByID(int id);
	     
	//CRUD-Update
			public abstract void update(T e);
			
	//CRUD-Delete
			public abstract void delete(int id);
}
