# oauth2

####测试验证  
1. 登录  
post  
http://localhost:7000/login  
form-data  
username:admin  
password:admin  
header:  
Authorization: Basic VXNlck1hbmFnZW1lbnQ6JDJhJDEwJFpSbVBGVmdFNm8yYW9hSzZodjQ5cE90NUJaSUtCREx5d0NhRmt1QXM2elltUmtwS0hneXVP  
  ########由下面可得  
  public static void main(String[] args) {  
        String clientId = "UserManagement";  
        String clientSecret = "$2a$10$ZRmPFVgE6o2aoaK6hv49pOt5BZIKBDLywCaFkuAs6zYmRkpKHgyuO";  

        StringBuilder txt = new StringBuilder("");  
        txt.append(clientId).append(":").append(clientSecret);  

        System.out.println(Base64.toBase64String(txt.toString().getBytes()));  
    }  
2. 用户查询  
post  
http://localhost:7000/user/getByUsername  
form-data  
username:admin  
header:  
Authorization: Bearer 0d3a5502-c557-490a-9d46-29a22dc816ea #登录返回的token  