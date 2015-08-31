package dao;

import javax.persistence.Query;
import entity.CustomerEntity;
import bean.Customer;

public class CustomerDAO extends BaseDAO{

	public void addCustomerdao(Customer cust) {
		
		if(cust !=null){
			CustomerEntity custEntity = new CustomerEntity(cust.getUname(),
					cust.getFullName(), cust.getPword(), cust.getGender(),
					cust.getFavnumber(), cust.getAddress(), cust.isRecvNewLetter(),
					cust.getMobileNum(), cust.getCountry());
			
			em.persist(custEntity);
			em.flush();
		}else{
			System.err.println("Null value can't be saved");
		}

	}
	
	 public boolean validatelogindao(String uname, String pword) {
         boolean flag=false;
          Query q = em.createQuery("SELECT u FROM CustomerEntity u WHERE u.uname = :uname AND u.pword = :pword");
          q.setParameter("uname", uname);
          q.setParameter("pword", pword);
          try{
              CustomerEntity cust = (CustomerEntity) q.getSingleResult();
            if (uname.equalsIgnoreCase(cust.getUname())&&pword.equals(cust.getPword())) {
               flag=true;
            }
          }catch(Exception e){      
              return false;
          }
          em.flush();

         return flag;
    }

}
