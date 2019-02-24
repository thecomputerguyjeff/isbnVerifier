import static java.lang.Integer.parseInt;

public class IsbnVarifierMethods implements IsbnVarifierInterface {
    public boolean checkCharacter(String character) {
        if ((character.equals("0")) || (character.equals("1")) || (character.equals("2")) || (character.equals("3")) || (character.equals("4")) || (character.equals("5")) || (character.equals("6")) || (character.equals("7")) || (character.equals("8")) || (character.equals("9"))) {
            return true;
        }
        else
            return false;
    }
    public Integer parseIt(String character, Integer i,String stringToVerify){
        Integer number=null;
        if((i==stringToVerify.length()-1)&&(character.equalsIgnoreCase("x"))) {
            number=10;
        }
        else if(this.checkCharacter(character)){
            number=parseInt(character);
        }
        return number;
    }
    public boolean testModEleven(Integer isbn){
        isbn=isbn%11;
        if(isbn==0)
            return true;
        else
            return false;
    }
}
