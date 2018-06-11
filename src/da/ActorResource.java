package da;

import java.util.List;

import javax.persistence.EntityManager;

import model2.Actor;

public class ActorResource extends ResourceBase<Actor> {

	  private EntityManager em;
	  private List<Actor> listActors;
	
	@Override
	public void insert(Actor a) {
		em =this.getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Actor> getAll()  {
		em =this.getEntityManager();
		em.getTransaction().begin();
		listActors = em.createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
		em.getTransaction().commit();
		em.close();
	    return listActors;
	}

	@Override
	public Actor getByID(int id) {
		em =this.getEntityManager();
		em.getTransaction().begin();
		Actor actor=em.find(Actor.class, id);
		em.getTransaction().commit();
		em.close();
		return actor;
	}

	@Override
	public void update(Actor a) {
		em =this.getEntityManager();
		em.getTransaction().begin();
        em.merge(a);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(int id) {
		em =this.getEntityManager();
		em.getTransaction().begin();
		Actor actor=em.find(Actor.class, id);
	    em.remove(actor);
	    em.getTransaction().commit();
	    em.close();
		
	}

}
