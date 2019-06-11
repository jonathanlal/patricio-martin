package com.patriciomartin.servlets;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import static java.nio.charset.StandardCharsets.UTF_8;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;


import com.patriciomartin.models.Globals;
import com.patriciomartin.models.GoogleStorage;
import com.patriciomartin.models.UTF8Control;
import com.patriciomartin.objects.Url;
import com.patriciomartin.objects.Urls;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		
	

		String p = request.getParameter("x");
		GoogleStorage gs = new GoogleStorage();
		if(p == null) {
			
	     
				
				Properties prop = new Properties();
				byte[] b = gs.readBlob(Globals.DEFAULT_BUCKET, "email.properties");
		         prop.load(new ByteArrayInputStream(b));
		         request.setAttribute("properties", prop);
				
			
		}else if(p.equals("CREATE")) {
		
			gs.createBucket("booboo");
		}else if(p.equals("UPLOAD")) {
//			gs.createBlob(Globals.DEFAULT_BUCKET, "email.properties");
		}else if(p.equals("READ")) {
			Properties prop = new Properties();
			byte[] b = gs.readBlob(Globals.DEFAULT_BUCKET, "email.properties");
	         prop.load(new ByteArrayInputStream(b));

	         // print the properties list from System.out
	         prop.list(System.out);
			
			System.out.println("COOL : "+prop.get("main.test2"));
//			String s = new String(b);
//			System.out.println("s: "+s);
//			String c = ClassLoader.getResource("resource-file.txt");
//			URL path = new URL(c);
//			try (FileOutputStream fos = new FileOutputStream()) {
//				   fos.write(b);
//				   //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
//		ResourceBundle bundle = ResourceBundle.getBundle("email", new UTF8Control());

			
//			File file = new File(s);
//			URL[] urls = {file.toURI().toURL()};
//			ClassLoader loader = new URLClassLoader(urls);
//			
//			Locale l = new Locale("en");
//			ResourceBundle rb = ResourceBundle.getBundle("email.properties", l, loader);
//			System.out.println("k: "+rb.getString("main.test"));
			}

		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
		rd.forward(request, response);
		}
		
		
		
//		String path = this.getClass().getClassLoader().getResource("").getPath();
//		String fullPath = URLDecoder.decode(path, "UTF-8");
//		String pathArr[] = fullPath.split(Globals.URL_MAPPINGS_LOCATION);
//		System.out.println(fullPath);
//		System.out.println(pathArr[0]);
//		fullPath = pathArr[0];
//		String reponsePath = "";
		// to read a file from webcontent
//		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
//		return reponsePath;
//		/patricio-martin/src/main/webapp/WEB-INF/url-mappings.xml
//		File file = null;
//		file = new File(getServletContext().getRealPath("")+Globals.URL_MAPPINGS_LOCATION_REL);	 ///USE JAXB TO MAKE OBJECT FROM XML
//		
//		
//		ServletContext context = getServletContext();
//		String fullPath = context.getRealPath(Globals.URL_MAPPINGS_LOCATION_REL);
		
//		
//		List<Url> url_maps = getUrlMappings();
//		
//		for(Url url : url_maps) {
//			
//		System.out.println(fullPath);
		
//		String pathname;
		
		// Create your service object
//		Storage storage = StorageOptions.getDefaultInstance().getService();
//
//		// Create a bucket
//		String bucketName = "my_unique_bucket"; // Change this to something unique
//		Bucket bucket = storage.create(BucketInfo.of(bucketName));
//
//		// Upload a blob to the newly created bucket
//		BlobId blobId = BlobId.of(bucketName, "my_blob_name");
//		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
//		Blob blob = storage.create(blobInfo, "a simple blob".getBytes(UTF_8));

		
//	    ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LdnQKcUAAAAAC5zuGJEcDsDU555aKVt0ZQTfLOQ", "6LdnQKcUAAAAAI43aVbujpheAy4gXwEgUDvBVTp9", false);
//       
//	    String recaptcha = c.createRecaptchaHtml(null, null);
//	    request.setAttribute("captcha", recaptcha);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
//		rd.forward(request, response);
		
		
		
//		System.out.println(Globals.getUrlMappingFile().exists());
	
		
//			System.out.println(reponsePath);
//			
//		}
//		
		
//	}
		
//		BufferedReader br = new BufferedReader(new FileReader(xmlFile));
//		String line;
//		StringBuilder sb = new StringBuilder();
//
//		while((line=br.readLine())!= null){
//			System.out.println(line.trim());
//		    sb.append(line.trim());
//		}
//		br.close();
//        	System.out.println(subscribers.get(1).getUrl());
//        	System.out.println(subscribers.get(1).url);
//        	System.out.println(url.getUrls());
//        	System.out.println(url.getUrl_en());
//        	System.out.println(url.toString());
//        }
		
//		System.out.println(Globals.getLanguage(null));

		
//		HashMap<String, String> urls = Urls.getUrlJspMappings("en");
//		for(Entry<?, ?> e: urls.entrySet()){
//			String k = (String) e.getKey();
//			String v = (String) e.getValue();
//		System.out.println("K: "+k+" | v: "+v);	
//		}
		
	public HashMap<String, String> getUrlNameMappingsXML(List<Url> url_maps){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: url_maps) {
			URLS.put(um.name, um.url);
		}
		return URLS;
	} 
	public HashMap<String, String> getUrlLanguageMappingsXML(){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: getUrlMappings()) {
			URLS.put(um.url, um.lang);
		}
		return URLS;
	} 
	/**
	 * 
	 * @return hashmap of <'/about/', 'about.jsp>
	 */
	public HashMap<String, String> getUrlJspMappingsXML(){
		HashMap<String,String> URLS = new HashMap<String,String>();
		for(Url um: getUrlMappings()) {
			URLS.put(um.url, um.call);
		}
		return URLS;
	} 
public String getURLanguageEquivalentXML(String session_lang, String requri){
	String new_url = null;
	List<Url> url_maps = getUrlMappings();
	for(Url um: url_maps) {
		if(requri.equals(um.url)) {
		String c_name = um.name;
		String c_call = um.call;
			for(Url um2: url_maps) {
				if(um2.name.equals(c_name) &&  um2.call.equals(c_call) && um2.lang.equals(session_lang)){
					new_url = um2.url;
					break;
				}
			}
		if(new_url != null) {break;}
		}
	}
return new_url;
}
	public List<Url> getUrlMappings(){
		 File xmlFile = new File(getServletContext().getRealPath("")+"/WEB-INF/url-mappings.xml");	 ///USE JAXB TO MAKE OBJECT FROM XML
		 List<Url> urls =  null;
		 try {
		 urls = (List<Url>) unmarshall(xmlFile);
		} catch (JAXBException e) {e.printStackTrace();}
	return urls;
	}
    public static List<Url> unmarshall(File xmlFile) throws JAXBException{
	    Urls urls = new Urls();
	    JAXBContext jaxbCtxt = JAXBContext.newInstance(Urls.class);
	    Unmarshaller jaxbUnmarshaller = jaxbCtxt.createUnmarshaller();
	    urls= (Urls)jaxbUnmarshaller.unmarshal(xmlFile);    
    return urls.getUrls();
    }
    
    
    
    
	
	public void printIT(Object someObject) throws IllegalArgumentException, IllegalAccessException {
		for (Field field : someObject.getClass().getDeclaredFields()) {
		    field.setAccessible(true); // You might want to set modifier to public first.
		    Object value = field.get(someObject); 
		    if (value != null) {
		        System.out.println(field.getName() + "=" + value);
		    }
		}
	}
	


	public void printFields(Field[] fields) throws Exception {
//	    Class<?> objClass = obj.getClass();
//		Field[] fields = Mappings.class.getDeclaredFields();
//	    Field[] fields = objClass.getFields();
		
	    for(Field field : fields) {
	        String name = field.getName();
	        Object value = field.get(null);

	        System.out.println(name + ": " + value.toString());
	    }
	}


}
