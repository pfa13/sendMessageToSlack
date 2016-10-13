public static void sendSlackMessage(String message) throws MalformedURLException, IOException {
        
	// url webhook integration in Slack	
	String url = "xxxxxx";
	HttpClient cliente =  new HttpClient();            
	PostMethod post = new PostMethod(url);
	JSONObject objeto = new JSONObject();
	
	try {                          
		
		// @name channel or user in Slack
		objeto.put("channel", "xxxx");
		objeto.put("text", message);
		objeto.put("username", "xxxx");
		
		post.addParameter("payload", objeto.toString());
		post.getParams().setContentCharset("UTF-8");
		
		int responseCode = cliente.executeMethod(post);
		
		String response = post.getResponseBodyAsStream().toString();
		if(responseCode != HttpStatus.SC_OK) {
			System.out.println("Slack post may have failed. Response " + response);
		}            
		
	} catch (Exception e) {
		System.out.println("JSONException posting to Slack " + e);
	}  finally {
		post.releaseConnection();
	}
	
}