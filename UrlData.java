
public class UrlData
{
	private static int _counter = 1;
	
	private int Id;
	
	public final int getId()
	{
		return Id;
	}
	public final void setId(int value)
	{
		Id = value;
	}

	private String Url;
	public final String getUrl()
	{
		return Url;
	}
	public final void setUrl(String value)
	{
		Url = value;
	}

	private int Count;
	public final int getCount()
	{
		return Count;
	}
	public final void setCount(int value)
	{
		Count = value;
	}

	//constructor..
	// Default constr, param construc
	public UrlData()
	{
		
	}
	
	public UrlData(String url)
	{
		setId(_counter++);
		setUrl(url);
	}
}