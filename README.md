# eWallet
An open and simple eWallet API.

Credit amount to account
https://EW/AddMoney/{accId}/{amount}

Debit amount to account
https://EW/RemoveMoney/{accId}/{amount}

Funds Transfer betweeen one account to another account
https://EW/SendMoney/{debitAccId}/{amount}/{creditAccId}

Funds Transfer Internal betweeen one account to another account
https://EW/FundsTransfer/InternalAccount/{debitAccId}/{amount}/{creditAccId}

Funds Transfer External betweeen one account to another account
https://EW/FundsTransfer/ExternalAccount/{debitAccId}/{amount}/{creditAccId}


#####
http://stackoverflow.com/questions/20414548/spring-3-javaconfig-problems-injecting-datasource
http://viralpatel.net/blogs/spring-4-mvc-tutorial-maven-example/
http://stackoverflow.com/questions/28893796/returning-a-simple-map-structure-from-spring-mvc-controller-to-ajax

https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwi_5tm5-_zRAhWJuI8KHbGwCPoQFggdMAA&url=http%3A%2F%2Fwww.dineshonjava.com%2F&usg=AFQjCNG28SG00xziLso6fdOX_EcadkEUHA

http://o7planning.org/en/10129/spring-mvc-tutorial-for-beginners

@RestController
public class HelloSpring4Controller {
	
	@RequestMapping("/hello")  
	 public ModelAndView sayHello() {  
	  String message = "Welcome to Spring 4.0 !!! dineshonjava.com";  
	  return new ModelAndView("hello", "message", message);  
	 }  
	
	@RequestMapping("/something")
	@ResponseBody
	public String helloWorld() {
	    return "Hello World";
	}
	
	@RequestMapping("/helloWorld")
	public ModelAndView helloWorld(Model model) {
	model.addAttribute("message", "Hello World!");
	return new ModelAndView(); 
	}
	
	   @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	    public @ResponseBody
	    Map<String, String> myTest() {
	        System.out.println("------------------------------------test");

	        Map<String,String> myMap = new HashMap<String, String>();
	        myMap.put("a", "1");
	        myMap.put("b", "2");
	        return myMap;
	    }
}
http://www.codejava.net/frameworks/spring/spring-mvc-with-jdbctemplate-example

example for call table value on select example
http://plnkr.co/edit/VdmvcOptoP5LC5VSyY9L?p=preview

http://stackoverflow.com/questions/27730826/ui-grid-save-updated-cell-data-to-database

pagination example
http://plnkr.co/edit/UttxPkXG8fYQDX85fnyZ?p=preview

http://www.proxygear.com/technic/2014/07/30/really_simple_angularjs_file_upload.html

create self signed private and public key for auth. between client and server.
https://www.youtube.com/watch?v=1xtBkukWiek

http://coolpythoncodes.com/first-data-science-job/
https://medium.com/@GalarnykMichael
