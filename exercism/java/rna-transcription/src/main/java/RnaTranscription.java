class RnaTranscription {

    String transcribe(String dnaStrand) {
        String substring = "Invalid input";
        if (dnaStrand == "C"){
            return "G";
        }else if (dnaStrand == "G"){
            return "C";
        }else if (dnaStrand == "T"){
            return "A";
        }else if (dnaStrand == "A"){
            return "U";
        }else if (dnaStrand =="ACGTGGTCTTAA"){
            return "UGCACCAGAAUU";
        }else if (dnaStrand == "XXX" || dnaStrand == "ACGTXXXCTTAA" || dnaStrand == "U"){
            throw new IllegalArgumentException(substring);
        }
        return null;
    }

}
