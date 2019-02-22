public interface IsbnInterface {

    public Integer checkNumberOrX(int integer);

    public void removeDashes(String string);

    public Integer calculateChecksum(String string);

    public boolean properLength(String  string);


}
