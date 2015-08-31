package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseDAO {
	
	@PersistenceContext
	protected EntityManager em;

}
