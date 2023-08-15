package RegexSplitter;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetItemName {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        return result;
    }

    public String getItemName() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String output = (new GetItemName()).readRawDataToString();
        //String pattern = "";
        //Pattern pattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("(.*?);", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(output);
        //Pattern pattern1 = Pattern.compile();

//        while (matcher.find()) {
//             //Print matched Patterns
//            System.out.println(matcher.group());
//        }


//        String[] parts = output.split(Pattern.quote("##"));
//        for (String part : parts) {
//            //System.out.println(part.trim());
//        }
        //output = output.replaceAll("(.*)##(.*)", " sheesh ");
        return output;
    }

    public void getItems() throws Exception {

        String output = (new GetItemName()).readRawDataToString();
        Pattern itemPattern = Pattern.compile("(?i)(?:naMe|name):(.*?)(?:[;|^@*!]|%expiration)(.*?)(?:[;|^@*!]|type:)(.*?)(?:[;|^@*!]|expiration:)(.*?)##?" , Pattern.CASE_INSENSITIVE);
        Matcher matcher = itemPattern.matcher(output);

        //"naMe:(.*?);price:(.*?);type:(.*?);expiration:(.*?)##"

        while (matcher.find()) {
            String name = matcher.group(1);
            String price = matcher.group(2);
            String type = matcher.group(3);
            String expiration = matcher.group(4);

            if (name.equals("")){
                name = null;
            }
            System.out.println( name);
            System.out.println( price);
            System.out.println( type);
            System.out.println( expiration);
            System.out.println("---------");
        }
    }



    public static ArrayList<String> splitElement() throws Exception {
        ArrayList<String> items = new ArrayList<>();

        String output = (new GetItemName()).readRawDataToString();
        String[] parts = output.split(Pattern.quote("##"));
        items.addAll(Arrays.asList(parts));

//        for (String part : parts) {
//            items.add(part);
//        }
        return items;
    }

//    public static ArrayList<String> splitFields(ArrayList<String> instanceOf) throws Exception {
//
//        String[] fields = instanceOf.split(Pattern.quote(";"));
////        for (String field: instanceOf) {
////            String[] fields = field.split(";");
////
////        }
//
//        return fields;
//    }
//    public String splitItems() throws Exception {
//        String output = getItemName();
//
//        Pattern pattern = Pattern.compile("(.*?)price", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(output);
//
//        while (matcher.find()) {
//            // Print matched Patterns
//            System.out.println(matcher.group());
//        }
//        return getItemName();
//    }

    public static void main(String[] args) throws Exception{
        //String output = (new GetItemName()).getItemName();
        //String output = (new GetItemName()).getItems();
        new GetItemName().getItems();

        //String output = (new GetItemName()).splitItems();
        //System.out.println(output);
        //System.out.println(output);

//        try {
//            ArrayList<String> splitItems = splitElement();
//
//            for (String item : splitItems) {
//                System.out.println(item.trim());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
