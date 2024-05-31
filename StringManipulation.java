public class StringManipulation {
    public static void main(String[] args) {
        String A = "The early bird catches the worm";
        String B = "Patience is a virtue";

    
        String wordFromA = A.substring(4, 9); 
        String wordFromB = B.substring(10, 16); 

       
        String concatenatedSentence = (wordFromA + " " + wordFromB).toLowerCase();
        String capitalizedSentence = concatenatedSentence.substring(0, 1).toUpperCase() + concatenatedSentence.substring(1);

       
        int lastIndexV = capitalizedSentence.lastIndexOf('V');

        System.out.println("Concatenated and capitalized sentence: " + capitalizedSentence);
        System.out.println("Last occurrence of 'V' (index): " + lastIndexV);
    }
}
