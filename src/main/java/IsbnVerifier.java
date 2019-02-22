class IsbnVerifier {

    IsbnInterface isbnChecker = new IsbnHelper();

    boolean isValid(String stringToVerify) {

        return isbnChecker.properLength(stringToVerify);

    }

}
