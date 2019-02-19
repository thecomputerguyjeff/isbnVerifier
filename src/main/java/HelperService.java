public class HelperService implements HelperInterface {
    @Override
    public Character[] breakUpIsbn(String isbn) {
        //this function breaks up the ISBN into a Character Array
        // it will return an empty array if ISBN was the wrong size
        Character[] isbnArr = new Character[10];
        int arrCount = 0;
        for (int i = 0; i < isbn.length(); i++) {
            Character currentChar = isbn.charAt(i);
            if (currentChar != '-') {
                if (arrCount == 10){
                    return new Character[0];
                }
                isbnArr[arrCount] = currentChar;
                arrCount++;
            }
        }
        if (arrCount != 10){
            return new Character[0];
        }
        return isbnArr;
    }

    @Override
    public Boolean isValid(String isbnToValidate) {

        Character[] isbnArr = breakUpIsbn(isbnToValidate);

        //if breakUpIsbn encountered invalid isbn, it will return an empty array
        if (isbnArr.length == 0){
            return false;
        }
        Integer sum = 0;
        for (int i = 0; i < isbnArr.length; i++) {
            Character currentChar = isbnArr[i];

            //If Check Digit was X, replace with 10 and finish sum
            if (i== isbnArr.length - 1 && currentChar == 'X'){
                sum+=isbnArr.length*(isbnArr.length-i);
                break;
        } else if (Character.isLetter(currentChar)) {
                //besides for the X Check Digit, if find character, return invalid
                return false;
            }
            sum+=Character.getNumericValue(currentChar)*(isbnArr.length-i);
        }
        if (sum%11 == 0){
            return true;
        }
        return false;
    }
}
