package com.mycompany.app;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
/**
 * Hello world!
 *
 */


/*public class App 
{     public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
      }
*/

// arraylistten seçtiği bir sayı ve girilen 2 intin ortalmasını hesaplayan metod,

	public static int ort(ArrayList<Integer> arr , int a, int b)
{
		System.out.println("inside ort");
		

	int randomNum = 0 + (int)(Math.random() * arr.size()); 
	if(a>0 || b>0){
	int sum=a+b+arr.get(randomNum);
	int ort=sum/3;
	return ort;
}
	
	else
		return 0;
				


}

//-------------------------------------------------------------------------



    public static void main( String[] args )
    {
   port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          boolean result = App.search(inputList, input2AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
  
 //  System.out.println( "Hello World!" );


