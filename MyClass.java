import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MyClass {

	private static UrlList _urls = new UrlList();
	public static void main(String[] args)
	{

		boolean flag = true;
		while (flag)
		{
			System.out.println("Please choose the Command");
			System.out.println("1. storeurl");
			System.out.println("2. get");
			System.out.println("3. count");
			System.out.println("4. list");
			System.out.println("5. exit");

			int selection = Integer.parseInt(new Scanner(System.in).nextLine());

			switch (selection)
			{
				case 1:
					StoreUrl();
					break;

				case 2:
					Get();
					break;

				case 3:
					Count();
					break;

				case 4:
					List();
					break;
				case 5:
					System.out.println("Program is terminated");
					flag = false;
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;
			}
		}
	}

	private static void List()
	{
		System.out.println("The List of Urls \n");
		ObjectMapper map = new ObjectMapper();
		try {
			
			String jsonString = map.writeValueAsString(_urls);
			
	        
			System.out.println(jsonString);
		} 
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static UrlData GetUrlData(String url)
	{
		for(int i=0; i< _urls.Urls.size(); i++) {
			if(_urls.Urls.get(i).getUrl().equals(url)) {
				return _urls.Urls.get(i);
			}
		}
		
		return null;
	}

	private static void Count()
	{
		
		  System.out.println("Please enter the Url :"); 
		  String url = new Scanner(System.in).nextLine(); 
		  UrlData data = GetUrlData(url);
		  if (data != null) 
		  {
			  System.out.println("The usage count is :" + data.getCount()); 
			  } 
		  else 
		  {  
			  System.out.println("Url does not exist in the Database"); 
		   }
		 
	}

	private static void Get()
	{
		System.out.println("Please enter the Url :");
		String url = new Scanner(System.in).nextLine();
		UrlData data = GetUrlData(url);
		if (data != null)
		{
			data.setCount(data.getCount() + 1);
			System.out.println("The unique key is :" + data.getId());
		}
		else
		{
			System.out.println("Url does not exist in the Database");
		}
	}

	private static void StoreUrl()
	{
		System.out.println("Please enter the Url :");
		String url = new Scanner(System.in).nextLine();
		UrlData data = GetUrlData(url);
		if (data != null)
		{
			System.out.println("Url is already in the database");
		}
		else
		{
			_urls.Urls.add(new UrlData(url));
		}
	}

}
