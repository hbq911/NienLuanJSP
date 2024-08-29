<% 
request.getSession().removeAttribute("u");
request.getSession().removeAttribute("cart");
response.sendRedirect(request.getContextPath()+"/Home");

%>