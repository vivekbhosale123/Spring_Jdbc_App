package org.techhub.clientApp;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.techhub.model.Voter;
import org.techhub.service.VoterServiceImple;

public class ClientApplication {

	public static void main(String[] args) {
//		System.out.println("hello");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		VoterServiceImple vsi =(VoterServiceImple) context.getBean("voterSer");
		do {
			Scanner xyz = new Scanner(System.in);
			System.out.println("1:insert the data");
			System.out.println("2:View the data");
			System.out.println("3:delete the data by id");
			System.out.println("4:Update the data by id");
			System.out.println("5:Search the Data by name");
			System.out.println("enter the choice");
			int ch = xyz.nextInt();
			xyz.nextLine();
			switch (ch) {
			case 1:
				System.out.println("enter the name email contact and age");
				String name = xyz.nextLine();
				String email = xyz.nextLine();
				String contact = xyz.nextLine();
				int age = xyz.nextInt();
				Voter v = new Voter();
				v.setName(name);
				v.setEmail(email);
				v.setContact(contact);
				v.setAge(age);
				boolean b =vsi.isAddVoter(v);
				if (b) {
					System.out.println("voter added successfully");
				} else {
					System.out.println("voter not added successfully");
				}
				break;
			case 2:
				List<Voter>list=vsi.isViewAll();
				for(Voter v1:list)
				{
				   System.out.println(v1.getId()+"\t"+v1.getName()+"\t"+v1.getEmail()+"\t"+v1.getContact()+"\t"+v1.getAge());
				}
				break;
			case 3:
				System.out.println("enter the id for delete");
				int id=xyz.nextInt();
				boolean b1=vsi.isDelete(id);
				if(b1)
				{
					System.out.println("deleted successfully");
				}
				else
				{
					System.out.println("deleted not successfully");
				}
				break;
			case 4:
				System.out.println("enter the name email contact and age");
			    name=xyz.nextLine();
			    email=xyz.nextLine();
			    contact=xyz.nextLine();
			    age=xyz.nextInt();
			    System.out.println("enter id for upadte");
			    id=xyz.nextInt();
			    Voter v1 = new Voter();
			    v1.setName(name);
			    v1.setEmail(email);
			    v1.setContact(contact);
			    v1.setAge(age);
			    v1.setId(id);
			    b=vsi.isUpdate(v1);
			    if(b)
			    {
			    	System.out.println("updated successfully");
			    }
			    else
			    {
			    	System.out.println("updated not successfully");
			    }
				break;
			case 5:
				System.out.println("enter the id for search");
				id=xyz.nextInt();
				v1=vsi.isSearch(id);
				System.out.println(v1.getId()+"\t"+v1.getName()+"\t"+v1.getEmail()+"\t"+v1.getContact()+"\t"+v1.getAge());
				break;
			default:
				System.out.println("wrong choice");
			}
		} while (true);
	}

}
