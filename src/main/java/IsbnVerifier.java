class IsbnVerifier {
    HelperInterface helper = new HelperService();
    boolean isValid(String stringToVerify) {
        Boolean answer = helper.isValid(stringToVerify);
        return answer;
}

}
