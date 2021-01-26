import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.util.Date;
class  program{
   public static void main(String[] args){
     Scanner input=new Scanner(System.in);
    HashMap<String,Integer> dictionary = new HashMap<>();
        dictionary.put("2020-01-01",4);
        dictionary.put("2020-01-02",4);
        dictionary.put("2020-01-03",6);
        dictionary.put("2020-01-04",8);
        dictionary.put("2020-01-05",2);
        dictionary.put("2020-01-06",-6);
        dictionary.put("2020-01-07",2);
        dictionary.put("2020-01-08",-2);
       
        HashMap<String,Integer> Answer = solution(dictionary);
        System.out.println("Mon -> " + Answer.get("Mon") );
        System.out.println("Tue -> " + Answer.get("Tue") );
        System.out.println("Wed -> " + Answer.get("Wed") );
        System.out.println("Thu -> " + Answer.get("Thu") );
        System.out.println("Fri -> " + Answer.get("Fri") );
        System.out.println("Sat -> " + Answer.get("Sat") );
        System.out.println("Sun -> " + Answer.get("Sun") );
     }


     public static HashMap<String,Integer> solution(HashMap<String,Integer> dictionary){
          HashMap<String,Integer> map = new HashMap<>();
          map.put("Mon",0);
          map.put("Tue",0);
          map.put("Wed",0);
          map.put("Thu",0);
          map.put("Fri",0);
          map.put("Sat",0);
          map.put("Sun",0);


          for(String ele:dictionary.keySet()){
              
            int year = Integer.parseInt(ele.substring(0,4));
            int month = Integer.parseInt(ele.substring(5,7));
            int D = Integer.parseInt(ele.substring(8,10));
            Date date= (new GregorianCalendar(year,month-1,D).getTime());
                
                SimpleDateFormat f = new SimpleDateFormat("EEEE");
                String day=f.format(date);
                day = day.substring(0,3);

                map.put(day,map.get(day)+dictionary.get(ele));
          }

        //   for(String ele:dictionary.keySet()){
              
        //     int year = Integer.parseInt(ele.substring(0,4));
        //     int month = Integer.parseInt(ele.substring(5,7));
        //     int D = Integer.parseInt(ele.substring(8,10));
        //     Date date= (new GregorianCalendar(year,month-1,D).getTime());
 
        //         SimpleDateFormat f = new SimpleDateFormat("EEEE");
        //         String day=f.format(date);
        //         day = day.substring(0,3);

        //         if(map.get(day)==0){
        //             Date prevD = new Date(date.getTime()-1000*60*60*24);
        //             Date nextD = new Date(date.getTime()+1000*60*60*24);

        //             SimpleDateFormat k = new SimpleDateFormat("EEEE");
        //             String prevDay=k.format(prevD);
        //             prevDay = prevDay.substring(0,3);
                    
        //             String nextDay = k.format(nextD);
        //             nextDay = nextDay.substring(0,3);
                    
        //             System.out.println(prevDay +"<-"+day+"->"+nextDay);
        //             map.put(day,(map.get(prevDay)+map.get(nextDay))/2);
        //         }

        //   }

          for(String ele:map.keySet()){
              if(map.get(ele) == 0){
                  if(ele == "Tue") map.put(ele,(map.get("Mon")+map.get("Wed"))/2);
                  if(ele == "Wed") map.put(ele,(map.get("Tue")+map.get("Thu"))/2);
                  if(ele == "Thu") map.put(ele,(map.get("Wed")+map.get("Fri"))/2);
                  if(ele == "Fri") map.put(ele,(map.get("Thu")+map.get("Sat"))/2);
                  if(ele == "Sat") map.put(ele,(map.get("Fri")+map.get("Sun"))/2);
              }
          }
          return map;


     }
     
}