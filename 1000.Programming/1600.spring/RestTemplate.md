
# RestTemplate
| Spring에서 제공하고있는jdbcTemplate이나,  JmsTemplate과 같은맥락의 Template
로 RESTful Serice 호출과 관련된 여러 메소드를 제공하여 REST 클라이언트를 쉽게 개발할
수 있도록 도와주는 것이다.

HTTP Method를 제공

getForObject() 메소드를 사용하면 서버로부터 어떤 리소스를 조회하는 기능을 구현할 수 있고,  
postForLocation() 메소드를 사용하면 서버 측에 리소스를 생성하거나 수정하는 기능을 구현할
수 있다. 작성자는 header 정보를 추가하기위해 exchange 만 사용

| Method | DESC |
|---|---|
|DELETE| delete(java.lang.String, java.lang.Object...)|
| GET| getForObject(java.lang.String, java.lang.Class, java.lang.Object...)|
| | getForEntity(java.lang.String, java.lang.Class, java.lang.Object...)
| HEAD| headForHeaders(java.lang.String, java.lang.Object...)|
| OPTIONS| optionsForAllow(java.lang.String, java.lang.Object...)|
| POST| postForLocation(java.lang.String, java.lang.Object, java.lang.Object...)|
|| postForObject(java.lang.String, java.lang.Object, java.lang.Class, java.lang.Object...)|
| PUT| put(java.lang.String, java.lang.Object, java.lang.Object...)|
| any| exchange(java.lang.String, org.springframework.http.HttpMethod, org.springframework.http.HttpEntity, java.lang.Class, java.lang.Object...)|
||execute(java.lang.String, org.springframework.http.HttpMethod, org.springframework.web.client.RequestCallback, org.springframework.web.client.ResponseExtractor, java.lang.Object...)|



```java

public class ApiChatClientUtils {
  
    private Logger logger = LoggerFactory.getLogger(ApiChatClientUtils.class);
    private String getApiServerUrl() {
        return "http://" + CommConstants.REST_API_URL + ":" + CommConstants.REST_API_PORT;
    }
     
    /**
     * Secret키와 Content-type을 설정
     * @param appType
     * @param params
     * @return HttpEntity<?>
     */
    private HttpEntity<?> apiClientHttpEntity(String appType, String params) {
         
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", CommConstants.REST_API_SECRETKEY);
        requestHeaders.set("Content-Type", "application/" + appType);
         
        if ( "".equals(params) || StringUtil.isNull(params) )
            return new HttpEntity<Object>(requestHeaders);
        else
            return new HttpEntity<Object>(params, requestHeaders);
    }
  
    public ResponseEntity<ChatVO> retriveChatUser(String strId) {
        String baseUrl = getApiServerUrl() + "/plugins/restapi/v1/users/{id}";
         
        RestTemplate restTemplate = new RestTemplate();
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);
         
        HttpEntity<?> requestEntity = apiClientHttpEntity("json", null);
         
        ResponseEntity<ChatVO> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity, ChatVO.class, strId);
        logger.info("getUsername=" + responseEntity.getBody().getUsername() + "\n"
                    + "getName=" + responseEntity.getBody().getName() + "\n"
                    + "getEmail=" + responseEntity.getBody().getEmail() + "\n"
                );
        ;
        logger.info(responseEntity.getStatusCode().toString());
        return responseEntity;
    }
     
    public void createChatUser(String strId, String strPW, String strName, String strEmail) throws Exception {
        String baseUrl = getApiServerUrl() + "/plugins/restapi/v1/users";
         
        RestTemplate restTemplate = new RestTemplate();
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);
         
        JSONObject parameters = new JSONObject();
        parameters.put("username", strId);
        parameters.put("password", strPW);
        parameters.put("name", strName);
        parameters.put("email", strEmail);
         
        HttpEntity<?> requestEntity = apiClientHttpEntity("json", parameters.toString());
         
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, null);
        logger.info(responseEntity.getBody());
    }
     
    public void deleteChatUser(String strId) {
        String baseUrl = getApiServerUrl() + "/plugins/restapi/v1/users/{id}";
         
        RestTemplate restTemplate = new RestTemplate();
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);
         
        HttpEntity<?> requestEntity = apiClientHttpEntity("json", null);
         
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.DELETE, requestEntity, null, strId);
        logger.info(responseEntity.getBody());
    }
}


```
