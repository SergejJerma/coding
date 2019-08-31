package examination;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class WorkWithData {
	public void workWithData() {
	Session session = Meniu.factory.openSession();
	Transaction tx = null;
	tx = session.beginTransaction();

	CriteriaBuilder cb = session.getCriteriaBuilder();
	javax.persistence.criteria.CriteriaQuery<Testing> cr = cb.createQuery(Testing.class);
	
	Root<Testing> root = cr.from(Testing.class);
	
	Query<Testing> query = session.createQuery(cr);
	
	List<Testing> testingAll = query.getResultList();

	for (Testing element: testingAll) {
		System.out.println(element.getId());
	}
		session.close();
	}
}
