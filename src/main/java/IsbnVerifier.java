
class IsbnVerifier extends IsbnVarifierMethods{
    private IsbnVarifierMethods Varifier=new IsbnVarifierMethods();

    boolean isValid(String stringToVerify) {
        Integer number=null;
        Integer isbn=0;
        Integer y=0;
        String character;
        for(int i=0; i<stringToVerify.length();i++) {
            character=stringToVerify.substring(i,i+1);
            if(!(character.equals("-"))) {
                number = Varifier.parseIt(character, i, stringToVerify);

                if (number == null) {
                    return false;
                }
                isbn = isbn + (number * (10 - y));
                y++;
            }
        }
        if(y!=10){
            return false;
        }
        return Varifier.testModEleven(isbn);
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}