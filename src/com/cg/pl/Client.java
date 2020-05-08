package com.cg.pl;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.bean.Author;

public class Client {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em= emf.createEntityManager();
		Author ar=null;
		int choice=0;
		 while(choice!=6) {
			 em.getTransaction().begin();
			 System.out.println("1.add author");
			 System.out.println("2.find Author");
			 System.out.println("3.update Author");
			 System.out.println("4.delete");
			
			 System.out.println("5.exit");
			 System.out.println("enter your choice");
			 choice =scanner.nextInt();
			 
			 switch(choice) {
			 
			 
			 case 1:
					Author author=new Author();

				    System.out.println("enter first name");
	                 String firstName= scanner.next();
	                 System.out.println("enter middle name");
	    	         String middleName= scanner.next();
	    	         System.out.println("enter last name");
	    	         String lastName= scanner.next();
	    	         
	    	         System.out.println("enter phoneno");
	    	         int phoneno=scanner.nextInt();
	    	         
	    	         author.setFirstName(firstName);
	    	         author.setMiddleName(middleName);
	    	         author.setLastName(lastName);
                     
                     author.setPhoneNo(phoneno);
                     em.persist(author);
                     break;
                     
			 case 2: System.out.println("enter your id");
			         int authorId=scanner.nextInt();
                     ar=em.find(Author.class,authorId);

			         if(ar==null) 
			         {
			        	 System.out.println("author id not found");
			         }
			         else
			         {
			        	 System.out.println("author found");
			        	 author=em.find(Author.class,authorId);
			        	 System.out.println("id is"+ar.getAuthorId());
			        	 System.out.println("first name:"+ar.getFirstName());
			        	 System.out.println("middle name :"+ar.getMiddleName());
			        	 System.out.println("last name:"+ar.getLastName());
			        	 System.out.println("phone number:"+ar.getPhoneNo());
			         }
			         break;
			 case 3: System.out.println("enter ur id");
			          authorId=scanner.nextInt();
			         ar=em.find(Author.class,authorId);
			         if(ar==null)
			         {
			        	 System.out.println("author id not found");
			         }
			         else
			         {    
			        	 
			        	 System.out.println("enter first name");
		                 String fName= scanner.next();
		                 System.out.println("enter middle name");
		    	         String mName= scanner.next();
		    	         System.out.println("enter last name");
		    	         String lName= scanner.next();
		    	        

		    	         System.out.println("enter phoneno");
		    	         int pno=scanner.nextInt();
		    	         
		    	         ar.setFirstName(fName);
		    	         ar.setMiddleName(mName);
		    	         ar.setLastName(lName);
	                     
	                     ar.setPhoneNo(pno);
	                     em.persist(ar);

//			        	 em.merge(author);
//			        	 System.out.println(author.getFirstName());
//			        	 System.out.println(author.getMiddleName());
//			        	 System.out.println(author.getLastName());
//						 System.out.println("id found");
			         }
			         break;
			         
			 case 4: System.out.println("enter id"); 
                      authorId=scanner.nextInt();
                      ar=em.find(Author.class, authorId);
                      if(ar==null)
                      {
                    	  System.out.println("author id not found");
                      }
                      else
                      {
                    	  em.remove(ar);
                    	  System.out.println("removed");
                      }
                      break;
                      
                      
			 
			 
			 case 5: System.out.println("exited sucessfully");  
			         return;
			         
			 }
			 em.getTransaction().commit();
		 }
		 em.close();
		 emf.close();

	}

}
