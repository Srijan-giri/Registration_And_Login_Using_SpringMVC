package spring.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import spring.model.UserRegistration;

@Component
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	@Resource(name="sessionFactory")
	 private SessionFactory factory;
	
	
	
	@Transactional
	public void createUser(UserRegistration user)
	{
		this.hibernateTemplate.saveOrUpdate(user);
	}

	@Transactional
	public boolean loginUser(String email,String password)
	{
		 Session session = factory.getCurrentSession();
		 boolean isFound=false;
		try {

//			Transactional tx = (Transactional) session.beginTransaction();
			Query<UserRegistration> query = session.createQuery("from UserRegistration  where email=:email and password=:password",UserRegistration.class);
		    query.setParameter("email", email);
		    query.setParameter("password", password);
	        UserRegistration user = query.getSingleResult();
	        System.out.println(user);
	        System.out.println(user.getEmail().toString());
	        System.out.println(user.getPassword().toString());
			
		
			if(user!=null && user.getEmail().toString().equals(email) &&
					user.getPassword().toString().equals(password) 
					) {
				    isFound=true;
			    }
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return isFound;
		
		
		
	}
}
