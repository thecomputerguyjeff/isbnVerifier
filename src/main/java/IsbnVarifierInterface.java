public interface IsbnVarifierInterface {
    public boolean checkCharacter(String testString);
    public Integer parseIt(String character, Integer i, String stringToVerify);
    public boolean testModEleven(Integer isbn);

}
