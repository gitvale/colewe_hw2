package uni.colewe.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import uni.colewe.client.MyDictService;
import uni.colewe.shared.MyDictionaryEntry;

@SuppressWarnings("serial")
public class MyDictServiceImpl extends RemoteServiceServlet implements MyDictService{
	
	private MyDictionary dict;

	@Override
	public List<MyDictionaryEntry> queryServer(String query, boolean rev, boolean sw) throws IllegalArgumentException {
		if(dict == null){
			String path = getServletContext().getRealPath("/WEB-INF/dictdata.txt");
			dict = new MyDictionary(path);
		}
		return new ArrayList<MyDictionaryEntry>(dict.treeLookUp(query, rev, sw));
	}

}
