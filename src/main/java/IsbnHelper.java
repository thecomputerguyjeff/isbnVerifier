import java.lang.reflect.Array;

public class IsbnHelper implements IsbnInterface {

    private String isbn;
    private Integer checksum=0;


    public boolean properLength(String  isbns) {

        if (calculateChecksum(isbns) == 0) {

            isbn = isbn.replaceAll(" ", "");

            if (isbn.length() == 10)
                return true;
            else
                return false;
        }
        else
            return false;
    }
    public Integer checkNumberOrX(int integer){

        Integer newNumber=0;

        if (integer==9){
            if (isbn.substring(integer).equalsIgnoreCase("X"))
            newNumber = 10;
            else
                try {newNumber =Integer.parseInt(isbn.substring(integer));}
                catch (Exception e){
                    isbn = isbn.replace(isbn.substring(integer, integer+1)," ");
                    newNumber=0;
                }
        }
        else
            try {newNumber =Integer.parseInt(isbn.substring(integer, integer+1));}
            catch (Exception e){
                isbn = isbn.replace(isbn.substring(integer, integer+1)," ");
                newNumber=0;
            }

        return newNumber;
    }

    public void removeDashes(String isbns){

        if (isbns.indexOf("-")>0)
            isbn = isbns.replaceAll("-", "");
        else
            isbn=isbns;

    }

    public Integer calculateChecksum(String isbns){
        int j=10;
        removeDashes(isbns);

        for(int i=0; i<isbn.length(); i++){
            int number = checkNumberOrX(i);
            checksum +=(number*j);
            j--;
        }
        checksum = checksum % 11;
        return checksum;
    }
}
